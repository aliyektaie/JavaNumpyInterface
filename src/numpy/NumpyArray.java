package numpy;

import numpy.wrappers.ArrayWrappers;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class NumpyArray {
    private IArrayWrapper data = null;

    public NumpyArray(Object data) {
        this.data = ArrayWrappers.createWrapper(data);
    }

    public void save(String path) {
        try {
            FileOutputStream fs = new FileOutputStream(path);
            fs.write(toByteArray());

            fs.flush();
            fs.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(OutputStream stream) throws IOException {
        byte[] buffer = toByteArray();
        stream.write(buffer);
    }

    private byte[] toByteArray() {
        // For more detail information on the file format refer to:
        // https://numpy.org/neps/nep-0001-npy-format.html

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            addFileHeaderToBuffer(output);
            addArrayContentToBuffer(output);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return output.toByteArray();
    }

    private void addArrayContentToBuffer(ByteArrayOutputStream output) throws IOException {
        data.serializeInto(output);
    }

    private void addFileHeaderToBuffer(ByteArrayOutputStream output) throws IOException {
        int lengthSoFar = 0;

        lengthSoFar = addMagicString(output);
        lengthSoFar += addFileVersion(output);

        lengthSoFar += 2; // The header length occupies 2 bytes. The final header length including the fields
        //                   added before should be divisible by 16. This is required by the specification.

        StringBuilder header = new StringBuilder();
        short headerLength = createHeaderString(header, lengthSoFar);

        // Write header length
        output.write(Utils.serializeToBuffer(headerLength, 2));

        // Write header content
        output.write(header.toString().getBytes(StandardCharsets.US_ASCII));

        // Just to check, if this exception occurs, there is a serious bug in the header serialization
        if ((output.toByteArray().length % 16) != 0) {
            throw new RuntimeException("Error in serializing numpy header.");
        }
    }

    private short createHeaderString(StringBuilder header, int lengthSoFar) {
        String headerContent = "{'descr': '%s', 'fortran_order': False, 'shape': (%s), }";
        headerContent = String.format(headerContent, getDataDescriptionType(), getDataShape());

        header.append(headerContent);
        header.append("                "); // Not sure if this is really needed. The sample files had additional space

        while (((lengthSoFar + header.length() + 1) % 16) != 0) {
            header.append(" ");
        }

        header.append('\n'); // Also required by the specification
        return (short) header.length();
    }

    private String getDataDescriptionType() {
        IArrayWrapper data = this.data;

        while (data.isArrayOfArray()) {
            data = (IArrayWrapper) data.get(0);
        }

        return data.getDescriptionString();
    }

    private String getDataShape() {
        StringBuilder result = new StringBuilder();
        String sep = "";

        IArrayWrapper data = this.data;

        do {
            result.append(sep);
            result.append(data.size());
            sep = ", ";

            if (data.isArrayOfArray()) {
                data = (IArrayWrapper) data.get(0);
            }
        } while (data.isArrayOfArray());

        return result.toString();
    }

    private int addFileVersion(ByteArrayOutputStream output) throws IOException {
        // Use file format version 1.0
        byte[] version = {0x01, 0x00};
        output.write(version);

        return version.length;
    }

    private int addMagicString(ByteArrayOutputStream output) throws IOException {
        byte[] magicString = {(byte) 0x93, 'N', 'U', 'M', 'P', 'Y'};
        output.write(magicString);

        return magicString.length;
    }
}
