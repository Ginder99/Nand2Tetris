public abstract class Instruction {
    private final String instructionStr;
    public Instruction(String instruction) {
        instructionStr = instruction;
    }
    InstructionType getType() {
        throw new IllegalArgumentException("Invalid Type");
    }
    String generateCode() {
        throw new IllegalArgumentException("Can't parse symbols");
    }
    protected String getInstructionStr() {
        return instructionStr;
    }
    static class AInstruction extends Instruction {
        public AInstruction(String instruction) {
            super(instruction);
        }
        @Override
        public InstructionType getType() {
            return InstructionType.A_INSTRUCTION;
        }
        @Override
        public String generateCode() {
            String instructionStr = getInstructionStr();
            String address = instructionStr.substring(1);
            int addressInt;
            try {
                addressInt = Integer.parseInt(address);
            } catch (NumberFormatException e) {
                addressInt = Tables.SYMBOL_TABLE.computeIfAbsent(address, k -> Tables.MEMORY_ADDRESS++);
            }
            String binaryAddress = Integer.toBinaryString(addressInt);
            return "0".repeat(16 - binaryAddress.length()) + binaryAddress;
        }
    }
    static class CInstruction extends Instruction {
        public CInstruction(String instruction) {
            super(instruction);
        }
        @Override
        public InstructionType getType() {
            return InstructionType.C_INSTRUCTION;
        }
        @Override
        public String generateCode() {
            String instructionStr = getInstructionStr();
            String dest = "null", comp, jump = "null";
            if(instructionStr.contains("=")) {
                String[] parts = instructionStr.split("=");
                dest = parts[0];
                comp = parts[1];
            } else if(instructionStr.contains(";")) {
                String[] parts = instructionStr.split(";");
                comp = parts[0];
                jump = parts[1];
            } else {
                throw new IllegalArgumentException("Invalid Instruction");
            }
            return "111" + Tables.COMP_TABLE.get(comp) + Tables.DEST_TABLE.get(dest) + Tables.JUMP_TABLE.get(jump);
        }
    }
    static class LInstruction extends Instruction {
        public LInstruction(String instruction) {
            super(instruction);
        }
        @Override
        public InstructionType getType() {
            return InstructionType.L_INSTRUCTION;
        }
        @Override
        public String generateCode() {
            return null;
        }
    }
    enum InstructionType {
        A_INSTRUCTION, C_INSTRUCTION, L_INSTRUCTION;
    }
}
