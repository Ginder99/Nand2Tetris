package assembler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    private final BufferedReader reader;

    // Constructor
    public Parser(File file) throws IOException {
        this.reader = new BufferedReader(new FileReader(file));
        reader.mark(1000000);
    }
    // hasMoreLines ?
    public boolean hasMoreLines() throws IOException {
        return reader.ready();
    }
    // Advance and return current instruction
    public Instruction advance() throws IOException {
        String instruction = reader.readLine().trim();
        while(instruction.isBlank() || instruction.startsWith("//")) instruction = reader.readLine().trim();
        Instruction currentInstruction;
        if(instruction.startsWith("(") && instruction.endsWith(")")) {
            currentInstruction = new Instruction.LInstruction(instruction);
        } else if(instruction.startsWith("@")) {
            currentInstruction = new Instruction.AInstruction(instruction);
        } else {
            currentInstruction = new Instruction.CInstruction(instruction);
        }
        return currentInstruction;
    }
    // Reset Parser
    public void reset() throws IOException {
        reader.reset();
    }
    // Close Parser
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing file");
        }
    }
}