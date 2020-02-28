package numpy.wrappers;

import numpy.IArrayWrapper;

public class JavaByteArrayWrapper implements numpy.IArrayWrapper {
    private byte[] data = null;

    public JavaByteArrayWrapper() {

    }

    public JavaByteArrayWrapper(byte[] data) {
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
        return data instanceof byte[];
    }

    @Override
    public IArrayWrapper createInstance(Object data) {
        return new JavaByteArrayWrapper((byte[]) data);
    }
}
