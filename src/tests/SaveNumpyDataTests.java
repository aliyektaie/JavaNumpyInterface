package tests;

import numpy.NumpyArray;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SaveNumpyDataTests {
    private static final String PYTHON_EXECUTABLE = "python3";

    @Test
    public void saveSingleDimensionIntArray() {
        createTempFolder();
        String slash = getFolderSeparator();
        createPythonScript(slash);

        int[] array = {1, 2, 3, 4, 5, 6};
        NumpyArray np = new NumpyArray(array);
        np.save("temp" + slash + "data.npy");

        String[] result = getPythonScriptResult(slash);
        Assert.assertEquals(2, result.length);
        Assert.assertEquals("int32", result[0]);
        Assert.assertEquals("[1 2 3 4 5 6]", result[1]);
    }

    @Test
    public void saveSingleDimensionByteArray() {
        createTempFolder();
        String slash = getFolderSeparator();
        createPythonScript(slash);

        byte[] array = {1, 2, 3, 4, 5, 6};
        NumpyArray np = new NumpyArray(array);
        np.save("temp" + slash + "data.npy");

        String[] result = getPythonScriptResult(slash);
        Assert.assertEquals(2, result.length);
        Assert.assertEquals("int8", result[0]);
        Assert.assertEquals("[1 2 3 4 5 6]", result[1]);
    }

    @Test
    public void saveSingleDimensionShortArray() {
        createTempFolder();
        String slash = getFolderSeparator();
        createPythonScript(slash);

        short[] array = {1, 2, 3, 4, 5, 6};
        NumpyArray np = new NumpyArray(array);
        np.save("temp" + slash + "data.npy");

        String[] result = getPythonScriptResult(slash);
        Assert.assertEquals(2, result.length);
        Assert.assertEquals("int16", result[0]);
        Assert.assertEquals("[1 2 3 4 5 6]", result[1]);
    }

    @Test
    public void saveSingleDimensionLongArray() {
        createTempFolder();
        String slash = getFolderSeparator();
        createPythonScript(slash);

        long[] array = {1, 2, 3, 4, 5, 6};
        NumpyArray np = new NumpyArray(array);
        np.save("temp" + slash + "data.npy");

        String[] result = getPythonScriptResult(slash);
        Assert.assertEquals(2, result.length);
        Assert.assertEquals("int64", result[0]);
        Assert.assertEquals("[1 2 3 4 5 6]", result[1]);
    }

    @Test
    public void saveSingleDimensionFloatArray() {
        createTempFolder();
        String slash = getFolderSeparator();
        createPythonScript(slash);

        float[] array = {0.2f, 1.4f, 3.14f};
        NumpyArray np = new NumpyArray(array);
        np.save("temp" + slash + "data.npy");

        String[] result = getPythonScriptResult(slash);
        Assert.assertEquals(2, result.length);
        Assert.assertEquals("float32", result[0]);
        Assert.assertEquals("[0.2  1.4  3.14]", result[1]);
    }

    @Test
    public void saveSingleDimensionDoubleArray() {
        createTempFolder();
        String slash = getFolderSeparator();
        createPythonScript(slash);

        double[] array = {0.2, 1.4, 3.14};
        NumpyArray np = new NumpyArray(array);
        np.save("temp" + slash + "data.npy");

        String[] result = getPythonScriptResult(slash);
        Assert.assertEquals(2, result.length);
        Assert.assertEquals("float64", result[0]);
        Assert.assertEquals("[0.2  1.4  3.14]", result[1]);
    }

    @Test
    public void saveTwoDimensionIntArray() {
        createTempFolder();
        String slash = getFolderSeparator();
        createPythonScript(slash);

        int[][] array = {{1,2,3}, {4,5,6}};
        NumpyArray np = new NumpyArray(array);
        np.save("temp" + slash + "data.npy");

        String[] result = getPythonScriptResult(slash);
        Assert.assertEquals(3, result.length);
        Assert.assertEquals("int32", result[0]);
        Assert.assertEquals("[[1 2 3]", result[1]);
        Assert.assertEquals(" [4 5 6]]", result[2]);
    }

    @Test
    public void saveThreeDimensionIntArray() {
        createTempFolder();
        String slash = getFolderSeparator();
        createPythonScript(slash);

        int[][][] array = {{{1,2,3}, {4,5,6}}, {{7,8,9}, {10,11,12}}};
        NumpyArray np = new NumpyArray(array);
        np.save("temp" + slash + "data.npy");

        String[] expected = {"[[[ 1  2  3]",
                "  [ 4  5  6]]",
                "",
                " [[ 7  8  9]",
                "  [10 11 12]]]"};
        String[] result = getPythonScriptResult(slash);
        Assert.assertEquals(1 + expected.length, result.length);
        Assert.assertEquals("int32", result[0]);

        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], result[i + 1]);
        }
    }

    private String[] getPythonScriptResult(String slash) {
        String scriptPath = System.getProperty("user.dir") + slash + "temp" + slash + "script.py";
        String dataPath = System.getProperty("user.dir") + slash + "temp" + slash + "data.npy";

        try {
            ProcessBuilder builder = new ProcessBuilder().command(PYTHON_EXECUTABLE, scriptPath, dataPath);
            Process process = builder.start();

            while (process.isAlive()) {
                Thread.sleep(20);
            }

            InputStream output = process.getInputStream();
            byte[] content = new byte[output.available()];
            output.read(content);

            String outString = new String(content).trim();
            return outString.split("\n");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void createPythonScript(String slash) {
        String[] pythonScript = {
                "import numpy as np",
                "import sys",
                "",
                "data = np.load(sys.argv[1])",
                "print(data.dtype)",
                "print(data)"
        };

        writeAllLines("temp" + slash + "script.py", pythonScript);
    }

    private void createTempFolder() {
        File folder = new File("temp");
        folder.mkdirs();
    }

    private String getFolderSeparator() {
        if (isWindows()) {
            return "\\";
        }

        return "/";
    }

    private boolean isWindows() {
        return (System.getProperty("os.name").toLowerCase().contains("win"));
    }

    public static void writeAllLines(String path, String[] lines) {
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            result.append(line).append("\r\n");
        }

        writeAllBytes(path, result.toString().getBytes(StandardCharsets.US_ASCII));
    }

    public static void writeAllBytes(String path, byte[] content) {
        try {
            FileOutputStream fs = new FileOutputStream(path);
            fs.write(content);

            fs.flush();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
