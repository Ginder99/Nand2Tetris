package assembler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Tables {
    public static int MEMORY_ADDRESS = 16;
    // Predefined symbols
    public static Map<String, Integer> SYMBOL_TABLE = new HashMap<>();
    static {
        IntStream.range(0, 16).forEach(i -> SYMBOL_TABLE.put("R" + i, i));
        SYMBOL_TABLE.put("SP", 0);
        SYMBOL_TABLE.put("LCL", 1);
        SYMBOL_TABLE.put("ARG", 2);
        SYMBOL_TABLE.put("THIS", 3);
        SYMBOL_TABLE.put("THAT", 4);
        SYMBOL_TABLE.put("SCREEN", 16384);
        SYMBOL_TABLE.put("KBD", 24576);
    }
    // Comp Mnemonics
    public static final Map<String, String> COMP_TABLE = new HashMap<>();
    static {
        COMP_TABLE.put("0", "0101010");
        COMP_TABLE.put("1", "0111111");
        COMP_TABLE.put("-1", "0111010");
        COMP_TABLE.put("D", "0001100");
        COMP_TABLE.put("A", "0110000");
        COMP_TABLE.put("!D", "0001101");
        COMP_TABLE.put("!A", "0110001");
        COMP_TABLE.put("-D", "0001111");
        COMP_TABLE.put("-A", "0110011");
        COMP_TABLE.put("D+1", "0011111");
        COMP_TABLE.put("A+1", "0110111");
        COMP_TABLE.put("D-1", "0001110");
        COMP_TABLE.put("A-1", "0110010");
        COMP_TABLE.put("D+A", "0000010");
        COMP_TABLE.put("D-A", "0010011");
        COMP_TABLE.put("A-D", "0000111");
        COMP_TABLE.put("D&A", "0000000");
        COMP_TABLE.put("D|A", "0010101");
        COMP_TABLE.put("M", "1110000");
        COMP_TABLE.put("!M", "1110001");
        COMP_TABLE.put("-M", "1110011");
        COMP_TABLE.put("M+1", "1110111");
        COMP_TABLE.put("M-1", "1110010");
        COMP_TABLE.put("D+M", "1000010");
        COMP_TABLE.put("D-M", "1010011");
        COMP_TABLE.put("M-D", "1000111");
        COMP_TABLE.put("D&M", "1000000");
        COMP_TABLE.put("D|M", "1010101");
    }
    // Dest Mnemonics
    public static final Map<String, String> DEST_TABLE = new HashMap<>();
    static {
        DEST_TABLE.put("null", "000");
        DEST_TABLE.put("M", "001");
        DEST_TABLE.put("D", "010");
        DEST_TABLE.put("MD", "011");
        DEST_TABLE.put("A", "100");
        DEST_TABLE.put("AM", "101");
        DEST_TABLE.put("AD", "110");
        DEST_TABLE.put("AMD", "111");
    }
    // Jump Mnemonics
    public static final Map<String, String> JUMP_TABLE = new HashMap<>();
    static {
        JUMP_TABLE.put("null", "000");
        JUMP_TABLE.put("JGT", "001");
        JUMP_TABLE.put("JEQ", "010");
        JUMP_TABLE.put("JGE", "011");
        JUMP_TABLE.put("JLT", "100");
        JUMP_TABLE.put("JNE", "101");
        JUMP_TABLE.put("JLE", "110");
        JUMP_TABLE.put("JMP", "111");
    }
}
