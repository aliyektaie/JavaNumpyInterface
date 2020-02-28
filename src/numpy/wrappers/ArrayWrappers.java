package numpy.wrappers;

import numpy.IArrayWrapper;

import java.util.ArrayList;

public class ArrayWrappers {
    private static ArrayList<IArrayWrapper> wrappers = null;

    static {
        wrappers = new ArrayList<>();

        wrappers.add(new JavaIntArrayWrapper());
        wrappers.add(new JavaByteArrayWrapper());
        wrappers.add(new JavaShortArrayWrapper());
        wrappers.add(new JavaLongArrayWrapper());
        wrappers.add(new JavaFloatArrayWrapper());
        wrappers.add(new JavaDoubleArrayWrapper());
    }

    public static IArrayWrapper createWrapper(Object array) {
        IArrayWrapper result = null;

        for (IArrayWrapper wrapper : wrappers) {
            if (wrapper.supportType(array)) {
                result = wrapper.createInstance(array);
                break;
            }
        }

        if (result == null) {
            throw new RuntimeException("Unsupported array type.");
        }

        return result;
    }
}
