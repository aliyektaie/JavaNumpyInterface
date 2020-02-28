package tests;

import numpy.NumpyArray;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class LoadNumpyDataTests {
    // Due to the nature of FP values and rounding, it may not be exactly the same.
    private final static double FLOATING_POINT_MAX_DIFFERENCE = 0.00000001;

    @Test
    public void testLoadMultiDimensionalByteArray() {
        // Array saved with numpy
        byte[] data = {-109, 78, 85, 77, 80, 89, 1, 0, 118, 0, 123, 39, 100, 101, 115, 99, 114, 39, 58, 32,
                39, 124, 105, 49, 39, 44, 32, 39, 102, 111, 114, 116, 114, 97, 110, 95, 111, 114, 100, 101,
                114, 39, 58, 32, 70, 97, 108, 115, 101, 44, 32, 39, 115, 104, 97, 112, 101, 39, 58, 32, 40,
                50, 44, 32, 50, 44, 32, 51, 41, 44, 32, 125, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 10, 1, 2, 3,
                4, 5, 6, 7, 8, 9, 10, 11, 12};

        byte[][][] array = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}};
        byte[][][] loaded = (byte[][][]) NumpyArray.load(new ByteArrayInputStream(data));

        Assert.assertEquals(array.length, loaded.length);
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(array[i].length, loaded[i].length);

            for (int j = 0; j < array[i].length; j++) {
                Assert.assertEquals(array[i][j].length, loaded[i][j].length);

                for (int k = 0; k < array[i][j].length; k++) {
                    Assert.assertEquals(array[i][j][k], loaded[i][j][k]);
                }
            }
        }
    }

    @Test
    public void testLoadMultiDimensionalShortArray() {
        // Array saved with numpy
        byte[] data = {-109, 78, 85, 77, 80, 89, 1, 0, 118, 0, 123, 39, 100, 101, 115, 99, 114, 39, 58, 32,
                39, 60, 105, 50, 39, 44, 32, 39, 102, 111, 114, 116, 114, 97, 110, 95, 111, 114, 100, 101, 114,
                39, 58, 32, 70, 97, 108, 115, 101, 44, 32, 39, 115, 104, 97, 112, 101, 39, 58, 32, 40, 50, 44,
                32, 50, 44, 32, 51, 41, 44, 32, 125, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 10, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0,
                6, 0, 7, 0, 8, 0, 9, 0, 10, 0, 11, 0, 12, 0};


        short[][][] array = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}};
        short[][][] loaded = (short[][][]) NumpyArray.load(new ByteArrayInputStream(data));

        Assert.assertEquals(array.length, loaded.length);
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(array[i].length, loaded[i].length);

            for (int j = 0; j < array[i].length; j++) {
                Assert.assertEquals(array[i][j].length, loaded[i][j].length);

                for (int k = 0; k < array[i][j].length; k++) {
                    Assert.assertEquals(array[i][j][k], loaded[i][j][k]);
                }
            }
        }
    }

    @Test
    public void testLoadMultiDimensionalIntArray() {
        // Array saved with numpy
        byte[] data = {-109, 78, 85, 77, 80, 89, 1, 0, 118, 0, 123, 39, 100, 101, 115, 99, 114, 39, 58, 32,
                39, 60, 105, 52, 39, 44, 32, 39, 102, 111, 114, 116, 114, 97, 110, 95, 111, 114, 100, 101,
                114, 39, 58, 32, 70, 97, 108, 115, 101, 44, 32, 39, 115, 104, 97, 112, 101, 39, 58, 32, 40,
                50, 44, 32, 50, 44, 32, 51, 41, 44, 32, 125, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 10, 1, 0, 0,
                0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 5, 0, 0, 0, 6, 0, 0, 0, 7, 0, 0, 0, 8, 0, 0, 0, 9, 0,
                0, 0, 10, 0, 0, 0, 11, 0, 0, 0, 12, 0, 0, 0};

        int[][][] array = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}};
        int[][][] loaded = (int[][][]) NumpyArray.load(new ByteArrayInputStream(data));

        Assert.assertEquals(array.length, loaded.length);
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(array[i].length, loaded[i].length);

            for (int j = 0; j < array[i].length; j++) {
                Assert.assertEquals(array[i][j].length, loaded[i][j].length);

                for (int k = 0; k < array[i][j].length; k++) {
                    Assert.assertEquals(array[i][j][k], loaded[i][j][k]);
                }
            }
        }
    }

    @Test
    public void testLoadMultiDimensionalLongArray() {
        // Array saved with numpy
        byte[] data = {-109, 78, 85, 77, 80, 89, 1, 0, 118, 0, 123, 39, 100, 101, 115, 99, 114, 39, 58, 32,
                39, 60, 105, 56, 39, 44, 32, 39, 102, 111, 114, 116, 114, 97, 110, 95, 111, 114, 100, 101,
                114, 39, 58, 32, 70, 97, 108, 115, 101, 44, 32, 39, 115, 104, 97, 112, 101, 39, 58, 32, 40,
                50, 44, 32, 50, 44, 32, 51, 41, 44, 32, 125, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 10, 1, 0, 0,
                0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, -3, -1, -1, -1, -1, -1, -1, -1, 4, 0, 0, 0, 0, 0, 0,
                0, -5, -1, -1, -1, -1, -1, -1, -1, 6, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0,
                0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 12,
                0, 0, 0, 0, 0, 0, 0};

        long[][][] array = {{{1, 2, -3}, {4, -5, 6}}, {{7, 8, 9}, {10, 11, 12}}};
        long[][][] loaded = (long[][][]) NumpyArray.load(new ByteArrayInputStream(data));

        Assert.assertEquals(array.length, loaded.length);
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(array[i].length, loaded[i].length);

            for (int j = 0; j < array[i].length; j++) {
                Assert.assertEquals(array[i][j].length, loaded[i][j].length);

                for (int k = 0; k < array[i][j].length; k++) {
                    Assert.assertEquals(array[i][j][k], loaded[i][j][k]);
                }
            }
        }
    }

    @Test
    public void testLoadMultiDimensionalFloatArray() {
        /*
        ----------------------------------------
        Python code that generated this content:
            Note the dtype=np.float32
        ----------------------------------------

        import numpy as np

        data = [[[1.1, 2.2, -3.4], [4.5, -5.24, 6.6]], [[7, 8, 9], [10, 11, 12]]]
        data = np.array(data, dtype=np.float32)

        np.save('/path/to/file', data)

         */
        byte[] data = {-109, 78, 85, 77, 80, 89, 1, 0, 118, 0, 123, 39, 100, 101, 115, 99, 114, 39, 58, 32,
                39, 60, 102, 52, 39, 44, 32, 39, 102, 111, 114, 116, 114, 97, 110, 95, 111, 114, 100, 101,
                114, 39, 58, 32, 70, 97, 108, 115, 101, 44, 32, 39, 115, 104, 97, 112, 101, 39, 58, 32, 40,
                50, 44, 32, 50, 44, 32, 51, 41, 44, 32, 125, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 10, -51, -52,
                -116, 63, -51, -52, 12, 64, -102, -103, 89, -64, 0, 0, -112, 64, 20, -82, -89, -64, 51, 51,
                -45, 64, 0, 0, -32, 64, 0, 0, 0, 65, 0, 0, 16, 65, 0, 0, 32, 65, 0, 0, 48, 65, 0, 0, 64, 65};

        float[][][] array = {{{1.1f, 2.2f, -3.4f}, {4.5f, -5.24f, 6.6f}}, {{7, 8, 9}, {10, 11, 12}}};
        float[][][] loaded = (float[][][]) NumpyArray.load(new ByteArrayInputStream(data));

        Assert.assertEquals(array.length, loaded.length);
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(array[i].length, loaded[i].length);

            for (int j = 0; j < array[i].length; j++) {
                Assert.assertEquals(array[i][j].length, loaded[i][j].length);

                for (int k = 0; k < array[i][j].length; k++) {
                    Assert.assertTrue(Math.abs(array[i][j][k] - loaded[i][j][k]) < FLOATING_POINT_MAX_DIFFERENCE);
                }
            }
        }
    }

    @Test
    public void testLoadMultiDimensionalDoubleArray() {
        /*
        ----------------------------------------
        Python code that generated this content:
            Note the dtype=np.double
        ----------------------------------------

        import numpy as np

        data = [[[1.1, 2.2, -3.4], [4.5, -5.24, 6.6]], [[7, 8, 9], [10, 11, 12]]]
        data = np.array(data, dtype=np.double)

        np.save('/path/to/file', data)

         */
        byte[] data = {-109, 78, 85, 77, 80, 89, 1, 0, 118, 0, 123, 39, 100, 101, 115, 99, 114, 39, 58, 32,
                39, 60, 102, 56, 39, 44, 32, 39, 102, 111, 114, 116, 114, 97, 110, 95, 111, 114, 100, 101,
                114, 39, 58, 32, 70, 97, 108, 115, 101, 44, 32, 39, 115, 104, 97, 112, 101, 39, 58, 32, 40,
                50, 44, 32, 50, 44, 32, 51, 41, 44, 32, 125, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 10, -102,
                -103, -103, -103, -103, -103, -15, 63, -102, -103, -103, -103, -103, -103, 1, 64, 51, 51, 51,
                51, 51, 51, 11, -64, 0, 0, 0, 0, 0, 0, 18, 64, -10, 40, 92, -113, -62, -11, 20, -64, 102, 102,
                102, 102, 102, 102, 26, 64, 0, 0, 0, 0, 0, 0, 28, 64, 0, 0, 0, 0, 0, 0, 32, 64, 0, 0, 0, 0, 0,
                0, 34, 64, 0, 0, 0, 0, 0, 0, 36, 64, 0, 0, 0, 0, 0, 0, 38, 64, 0, 0, 0, 0, 0, 0, 40, 64};

        double[][][] array = {{{1.1, 2.2, -3.4}, {4.5, -5.24, 6.6}}, {{7, 8, 9}, {10, 11, 12}}};
        double[][][] loaded = (double[][][]) NumpyArray.load(new ByteArrayInputStream(data));

        Assert.assertEquals(array.length, loaded.length);
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(array[i].length, loaded[i].length);

            for (int j = 0; j < array[i].length; j++) {
                Assert.assertEquals(array[i][j].length, loaded[i][j].length);

                for (int k = 0; k < array[i][j].length; k++) {
                    Assert.assertTrue(Math.abs(array[i][j][k] - loaded[i][j][k]) < FLOATING_POINT_MAX_DIFFERENCE);
                }
            }
        }
    }
}
