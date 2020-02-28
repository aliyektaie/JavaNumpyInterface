package tests;

import numpy.IArrayWrapper;
import numpy.wrappers.*;
import org.junit.Assert;
import org.junit.Test;

public class JavaArrayWrappersTests {
    @Test
    public void testJavaArrayWrapperWithIntArray() {
        int[] data = {0, 1, 2, 45, 42, 61, 8, 4};
        IArrayWrapper wrapper = ArrayWrappers.createWrapper(data);

        Assert.assertTrue(wrapper instanceof JavaIntArrayWrapper);
        Assert.assertEquals(data.length, wrapper.size());

        for (int i = 0; i < data.length; i++) {
            Assert.assertEquals(data[i], wrapper.get(i));
        }
    }

    @Test
    public void testJavaArrayWrapperWithByteArray() {
        byte[] data = {0, 1, 2, 45, 42, 61, 8, 4};
        IArrayWrapper wrapper = ArrayWrappers.createWrapper(data);

        Assert.assertTrue(wrapper instanceof JavaByteArrayWrapper);
        Assert.assertEquals(data.length, wrapper.size());

        for (int i = 0; i < data.length; i++) {
            Assert.assertEquals(data[i], wrapper.get(i));
        }
    }

    @Test
    public void testJavaArrayWrapperWithShortArray() {
        short[] data = {0, 1, 2, 45, 42, 61, 8, 4};
        IArrayWrapper wrapper = ArrayWrappers.createWrapper(data);

        Assert.assertTrue(wrapper instanceof JavaShortArrayWrapper);
        Assert.assertEquals(data.length, wrapper.size());

        for (int i = 0; i < data.length; i++) {
            Assert.assertEquals(data[i], wrapper.get(i));
        }
    }

    @Test
    public void testJavaArrayWrapperWithLongArray() {
        long[] data = {0, 1, 2, 45, 42, 61, 8, 4};
        IArrayWrapper wrapper = ArrayWrappers.createWrapper(data);

        Assert.assertTrue(wrapper instanceof JavaLongArrayWrapper);
        Assert.assertEquals(data.length, wrapper.size());

        for (int i = 0; i < data.length; i++) {
            Assert.assertEquals(data[i], wrapper.get(i));
        }
    }

    @Test
    public void testJavaArrayWrapperWithDoubleArray() {
        double[] data = {0, 1, 2, 45, 42.7, 61.5, 8, 4};
        IArrayWrapper wrapper = ArrayWrappers.createWrapper(data);

        Assert.assertTrue(wrapper instanceof JavaDoubleArrayWrapper);
        Assert.assertEquals(data.length, wrapper.size());

        for (int i = 0; i < data.length; i++) {
            Assert.assertEquals(data[i], wrapper.get(i));
        }
    }

    @Test
    public void testJavaArrayWrapperWithFloatArray() {
        float[] data = {0, 1, 2, 45, 42.7f, 61.5f, 8, 4};
        IArrayWrapper wrapper = ArrayWrappers.createWrapper(data);

        Assert.assertTrue(wrapper instanceof JavaFloatArrayWrapper);
        Assert.assertEquals(data.length, wrapper.size());

        for (int i = 0; i < data.length; i++) {
            Assert.assertEquals(data[i], wrapper.get(i));
        }
    }
}
