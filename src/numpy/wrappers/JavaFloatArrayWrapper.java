package numpy.wrappers;

import numpy.IArrayWrapper;

public class JavaFloatArrayWrapper implements numpy.IArrayWrapper {
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
}
