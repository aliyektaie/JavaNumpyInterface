package numpy.wrappers;

import numpy.IArrayWrapper;
import numpy.Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class JavaFloatArrayWrapper implements numpy.IArrayWrapper {
    public static final String D_TYPE = "<f4";
    private float[] data = null;

    public JavaFloatArrayWrapper() {

    }

    public JavaFloatArrayWrapper(float[] data) {
        this.data = data;
    }

    @Override
    public int size() {
        return this.data.length;
    }

    @Override
    public boolean isArrayOfArray() {
        return false;
    }

    @Override
    public Object get(int index) {
        return this.data[index];
    }

    @Override
    public boolean supportType(Object data) {
        return data instanceof float[];
    }

    @Override
    public IArrayWrapper createInstance(Object data) {
        return new JavaFloatArrayWrapper((float[]) data);
    }

    @Override
    public void serializeInto(ByteArrayOutputStream output) throws IOException {
        for (int i = 0; i < data.length; i++) {
            output.write(Utils.serializeToBuffer(Float.floatToIntBits(data[i]), 4));
        }
    }

    @Override
    public String getDescriptionString() {
        return D_TYPE; // for dtype=np.float32
    }
}
