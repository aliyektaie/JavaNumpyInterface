package numpy.wrappers;

import numpy.IArrayWrapper;

public class JavaLongArrayWrapper implements numpy.IArrayWrapper {
    private long[] data = null;

    public JavaLongArrayWrapper() {

    }

    public JavaLongArrayWrapper(long[] data) {
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
        return data instanceof long[];
    }

    @Override
    public IArrayWrapper createInstance(Object data) {
        return new JavaLongArrayWrapper((long[]) data);
    }
}
