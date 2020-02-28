package numpy.wrappers;

import numpy.IArrayWrapper;

public class JavaDoubleArrayWrapper implements numpy.IArrayWrapper {
    private double[] data = null;

    public JavaDoubleArrayWrapper() {

    }

    public JavaDoubleArrayWrapper(double[] data) {
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
        return data instanceof double[];
    }

    @Override
    public IArrayWrapper createInstance(Object data) {
        return new JavaDoubleArrayWrapper((double[]) data);
    }
}
