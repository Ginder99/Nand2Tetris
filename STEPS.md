# Nand2Tetris - Step-by-Step Guide

This repository contains solutions for "The Elements of Computing Systems" by Noam Nisan and Shimon Schocken. Each directory represents a step in building a modern computer from first principles.

## Project Steps Overview

Follow these steps in order to progressively build understanding from basic logic gates to a complete computer system with an assembler.

---

## Step 1: Boolean Logic and Gates
**Directory:** [01_Gates](01_Gates)

**Objective:** Build basic logic gates from NAND gates

**What you'll learn:**
- How to construct fundamental logic gates (AND, OR, NOT, XOR)
- Multi-bit variants (And16, Or16, Not16)
- Multiplexers and Demultiplexers
- Foundation of all digital circuits

**Key Components:**
- Basic gates: `Not.hdl`, `And.hdl`, `Or.hdl`, `Xor.hdl`
- 16-bit gates: `Not16.hdl`, `And16.hdl`, `Or16.hdl`
- Multiplexers: `Mux.hdl`, `Mux16.hdl`, `Mux4Way16.hdl`, `Mux8Way16.hdl`
- Demultiplexers: `DMux.hdl`, `DMux4Way.hdl`, `DMux8Way.hdl`
- Multi-way gates: `Or8Way.hdl`

---

## Step 2: Arithmetic Logic Unit (ALU)
**Directory:** [02_ALU](02_ALU)

**Objective:** Build arithmetic circuits and the ALU

**What you'll learn:**
- Binary addition circuits
- The Arithmetic Logic Unit - the computational heart of the CPU
- How computers perform arithmetic and logic operations

**Key Components:**
- Adders: `HalfAdder.hdl`, `FullAdder.hdl`, `Add16.hdl`, `Inc16.hdl`
- Complete ALU: `ALU.hdl`

---

## Step 3: Memory and Sequential Logic
**Directory:** [03_RAM](03_RAM)

**Objective:** Build memory units from flip-flops to RAM

**What you'll learn:**
- Sequential logic and state
- Building memory from 1-bit registers to large RAM units
- Program Counter functionality

**Key Components:**
- Basic memory: `1Bit.hdl`, `Register.hdl`
- RAM hierarchy: `RAM8.hdl`, `RAM64.hdl`, `RAM512.hdl`, `RAM4K.hdl`, `RAM16K.hdl`
- Program Counter: `PC.hdl`

---

## Step 4: Assembly Language Programming
**Directory:** [04_ASM](04_ASM)

**Objective:** Write programs in Hack assembly language

**What you'll learn:**
- Low-level programming
- Direct hardware manipulation
- Assembly language concepts

**Key Programs:**
- `Mult.asm` - Multiplication program
- `Fill.asm` - Screen manipulation program

---

## Step 5: Computer Architecture
**Directory:** [05_Computer](05_Computer)

**Objective:** Build a complete computer system

**What you'll learn:**
- CPU architecture and instruction execution
- Memory architecture
- Complete computer system integration

**Key Components:**
- `CPU.hdl` - The central processing unit
- `Memory.hdl` - Complete memory system
- `Computer.hdl` - The complete Hack computer

---

## Step 6: Assembler
**Directory:** [06_Assembler](06_Assembler)

**Objective:** Build an assembler to translate assembly to machine code

**What you'll learn:**
- Two-pass assembly process
- Symbol table management
- Translation from assembly to binary machine code

**Implementation:**
- Written in Java
- Translates `.asm` files to `.hack` binary files
- See [06_Assembler/README.md](06_Assembler/README.md) for usage instructions

**Key Files:**
- `HackAssembler.java` - Main assembler program
- `Parser.java` - Parse assembly instructions
- `Instruction.java` - Instruction handling
- `Tables.java` - Symbol and instruction tables
- `HackAssemblerTest.java` - Test suite

---

## How to Use This Guide

1. **Start with Step 1** and work through each step sequentially
2. **Read the objectives** to understand what you'll build
3. **Navigate to the directory** for each step
4. **Implement the components** using the HDL (Hardware Description Language) for hardware projects
5. **Test your implementations** using the provided test scripts
6. **Move to the next step** once you've completed and tested all components

## Prerequisites

- Basic understanding of boolean logic
- Familiarity with binary numbers
- Text editor for HDL/assembly files
- Nand2Tetris software suite (for testing)

## Testing Your Work

Each hardware project can be tested using the Hardware Simulator from the Nand2Tetris software suite. Load the `.tst` test files and compare your output with the expected `.cmp` comparison files.

For the assembler (Step 6), see the specific README in the [06_Assembler](06_Assembler) directory.

## Next Steps

After completing these 6 steps, you'll have:
- Built a complete computer from NAND gates
- Written assembly programs
- Created an assembler

The course continues with:
- Virtual Machine (VM translator)
- High-level language (Jack)
- Compiler
- Operating System

## Resources

- **Book:** "The Elements of Computing Systems" by Nisan & Schocken
- **Website:** [nand2tetris.org](https://www.nand2tetris.org)
- **Software Suite:** Download from the official website

---

*Happy building! You're creating a computer from scratch!* 🚀
