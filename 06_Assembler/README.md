### How to Run and test the assembler code
1. Clone this repository
3. Make sure you have Java installed on your machine. Preferably Java 17 or later

#### Running the HackAssembler code

1. Navigate to the 06_Assembler directory
2. Run the below command to compile HackAssembler.java
```bash
javac HackAssembler.java
```
4. Run the below command to run the assembler code
```bash
java HackAssembler <input_file_name>.asm
```
4. The above command will generate a file with the same name as the input file but with .hack extension

#### Testing the HackAssembler code
1. Navigate to the 06_Assembler directory
2. Run the below command to compile HackAssemblerTest.java
```bash
javac HackAssemblerTest.java
```
3. Create `input` directory in the 06_Assembler directory
4. Place the `.asm` files in the 'input' directory
5. Create `expected` directory in the 06_Assembler directory
6. Place the corresponding expected output `.hack` files in the 'expected' directory
7. Run the below command to run the test
```bash
java HackAssemblerTest <06_Assembler directory path>
```
8. The test will compare the generated `.hack` files with the expected `.hack` files and print the result
