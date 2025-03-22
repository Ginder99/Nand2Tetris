import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HackAssembler {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java HackAssembler <file.asm>");
            return;
        }
        String filename = args[0];
        int instructionAddress = 0;
        Parser parser = new Parser(new File(filename));
        // First Pass
        while(parser.hasMoreLines()) {
            Instruction instruction = parser.advance();
            if(Instruction.InstructionType.L_INSTRUCTION.equals(instruction.getType())) {
                Tables.SYMBOL_TABLE.put(instruction.getInstructionStr().substring(1, instruction.getInstructionStr().length() - 1), instructionAddress);
            } else {
                instructionAddress++;
            }
        }
        parser.reset();
        // Output file name. Replace .asm with .hack. Replace 'input' with 'output'
        String outputFileName = filename.substring(0, filename.lastIndexOf('.')) + ".hack";
        outputFileName = outputFileName.replace("input", "output");
        Path path = Paths.get(outputFileName);
        Files.createDirectories(path.getParent()); // Create directories if needed
        Files.write(path, new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); // Clear or create file
        // Second Pass
        while(parser.hasMoreLines()) {
            Instruction instruction = parser.advance();
            if(instruction.getType().equals(Instruction.InstructionType.L_INSTRUCTION)) continue;
            String binaryString = instruction.generateCode();
            try {
                Files.write(Paths.get(outputFileName), (binaryString + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new IOException("Error writing to file", e);
            }
        }
        parser.close();
    }
}
