package assembler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Objects;

public class HackAssemblerTest {

    private static String TEST_ROOT;
    private static String INPUT_DIR = TEST_ROOT + "input/";
    private static String EXPECTED_DIR = TEST_ROOT + "expected/";
    private static String OUTPUT_DIR = TEST_ROOT + "output/";
    private static final String INPUT_EXTENSION = ".asm";

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java assembler/HackAssemblerTest <test path>");
            return;
        }
        TEST_ROOT = args[0];
        INPUT_DIR = TEST_ROOT + "input/";
        EXPECTED_DIR = TEST_ROOT + "expected/";
        OUTPUT_DIR = TEST_ROOT + "output/";
        new HackAssemblerTest().runTests();
    }

    public void runTests() throws Exception {
        File inputRoot = new File(INPUT_DIR);
        if (!inputRoot.exists() || !inputRoot.isDirectory()) {
            throw new IllegalStateException("Input directory not found: " + INPUT_DIR);
        }

        // Find all input files with the required extension
        Files.walk(inputRoot.toPath())
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(INPUT_EXTENSION))
                .forEach(inputFileName -> {
                    try {
                        testFileProcessing(inputFileName.toString());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        System.out.println("All tests completed!");
        Files.walk(Paths.get(OUTPUT_DIR))
                .sorted(Comparator.reverseOrder())
                .forEach(p -> p.toFile().delete());
    }

    private void testFileProcessing(String inputFileName) throws Exception {
        System.out.println("Test Started for: " + inputFileName);
        String expectedOutputFileName = inputFileName.replace(INPUT_DIR, EXPECTED_DIR).replace(INPUT_EXTENSION, ".hack");
        String actualOutputFileName = expectedOutputFileName.replace(EXPECTED_DIR, OUTPUT_DIR);
        File inputFile = new File(inputFileName);
        File expectedOutputFile = new File(expectedOutputFileName);
        File actualOutputFile = new File(actualOutputFileName);
        String currentPath = System.getProperty("user.dir");

        // Run the Java program as a separate process
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", currentPath, "assembler.HackAssembler", inputFile.getAbsolutePath());
        Process process = pb.start();

        // Read error stream asynchronously
        String errorOutput = readStream(process.getErrorStream());

        int exitCode = process.waitFor();

        // Check if there was an error
        if (exitCode != 0) {
            System.err.println("Error occurred while processing: " + inputFileName);
            System.err.println("Error details:\n" + errorOutput);
            throw new AssertionError("Process failed with exit code " + exitCode + "\n" + errorOutput);
        }

        // Compare output only if the process was successful
        if (!compareFiles(actualOutputFile, expectedOutputFile)) {
            throw new AssertionError("Test failed for: " + inputFileName);
        }
        System.out.println("Test Passed for: " + inputFileName);
    }

    private boolean compareFiles(File file1, File file2) throws IOException {
        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2))) {

            String line1, line2;
            int lineNumber = 1;

            while ((line1 = br1.readLine()) != null | (line2 = br2.readLine()) != null) {
                if (!Objects.equals(line1, line2)) {
                    System.err.println("Mismatch found at line " + lineNumber + ":");
                    System.err.println("Expected: " + (line2 == null ? "[EOF]" : line2));
                    System.err.println("Actual  : " + (line1 == null ? "[EOF]" : line1));
                    return false;
                }
                lineNumber++;
            }
        }
        return true;
    }


    private String readStream(InputStream inputStream) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }
        return result.toString();
    }
}
