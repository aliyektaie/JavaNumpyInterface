package numpy.wrappers;

import numpy.IArrayWrapper;

public class JavaIntArrayWrapper implements IArrayWrapper {
    private int[] data = null;

    public JavaIntArrayWrapper() {

    }

    public JavaIntArrayWrapper(int[] data) {
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
        return data instanceof int[];
    }

    @Override
    public IArrayWrapper createInstance(Object data) {
        return new JavaIntArrayWrapper((int[]) data);
    }
}
