package numpy.wrappers;

import numpy.IArrayWrapper;

public class JavaShortArrayWrapper implements numpy.IArrayWrapper {
    private short[] data = null;

    public JavaShortArrayWrapper() {

    }

    public JavaShortArrayWrapper(short[] data) {
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
        return data instanceof short[];
    }

    @Override
    public IArrayWrapper createInstance(Object data) {
        return new JavaShortArrayWrapper((short[]) data);
    }
}
