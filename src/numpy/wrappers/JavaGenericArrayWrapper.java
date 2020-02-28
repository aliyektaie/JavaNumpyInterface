package numpy.wrappers;

import numpy.IArrayWrapper;

public class JavaGenericArrayWrapper<Type extends Number> implements IArrayWrapper {
    private Type[] data = null;

    public JavaGenericArrayWrapper() {

    }

    public JavaGenericArrayWrapper(Type[] data) {

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
        // Stupid Java!!!!
        try {
            Type[] temp = (Type[]) data;
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public IArrayWrapper createInstance(Object data) {
        return new JavaGenericArrayWrapper<Type>((Type[]) data);
    }
}
