import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class CPU {
    // PC, IR, AC, REG, Instruction Counter, Subroutine number tracker
    public static int PC = 0x400;
    public static int IR, AC, REG;
    public static int instructionCounter = 0;
    static String[] opcodes;
    static String[] operands;

    // Methods
    public static int toInt(String hex) {
        return Integer.parseInt(hex, 16);
    }

    public static String intToHex(int num) {
        return Integer.toHexString(num);
    }

    // Fetch and execute cycle
    static void begin() {
        while (true) {
            fetch();
            execute();
        }
    }

    // fetch instructions from PC and store in IR
    static void fetch() {
        System.out.println(PC);
        IR = toInt(Memory.read(PC));
        PC++;

    }

    // execute instructions stored in IR
    static void execute() {
        // Store opcode and operand seperately
        System.out.println(IR);
    
        instructionCounter++;
        String instructionString = intToHex(IR);
        String instructionOpCode = instructionString.substring(0,1); 
        System.out.println(instructionString);
        String instructionOperand = instructionString.substring(1).trim();
        // Increment instruction counter
        System.out.println(instructionOpCode);
        System.out.println(instructionOperand);
        executesInstruction(toInt(instructionOpCode), toInt(instructionOperand));
        // Run commands according to opcode(use switch statement)
    }


     public static void executesInstruction(int opcode, int operand) {
            switch (opcode) {
                case 1: // Load AC from memory
                    AC = toInt(Memory.read(operand));
                    System.out.println(AC);
                    System.out.println("clic");
                    break;
                case 2: // Store AC to memory
                    Memory.write(intToHex(AC), operand);
                    System.out.println(AC);
                    break;
                case 3: // Load AC from REG
                    AC = REG;
                    break;
                case 4: // Store AC to REG
                    REG = AC;
                    break;
                case 5: // Add to AC from memory
                    AC += toInt(Memory.read(operand));
                    break;
                case 6: // Load REG with operand
                    REG = operand;
                    break;
                case 7: // Add REG to AC
                    AC += REG;
                    break;
                case 8: // Multiply REG to AC
                    AC *= REG;
                    break;
                case 9: // Subtract REG from AC
                    AC -= REG;
                    break;
                case 10: // Divide AC by REG value
                    AC /= REG;
                    break;
                case 11: // Jump to subroutine starting at the address
                    Stack.push(intToHex(PC));
                    Stack.push(intToHex(IR));
                    Stack.push(intToHex(AC));
                    Stack.push(intToHex(REG));
                    PC = operand;
                    break;
                case 12: // Return from the subroutine
                    writeToFile();
                    System.out.println("therefore");
                    REG = toInt(Stack.pop());
                    AC = toInt(Stack.pop());
                    IR = toInt(Stack.pop());
                    PC = toInt(Stack.pop());
                    break;
                case 15:
                    System.out.println("Therefore");
                    writeToFile();
                    System.exit(0);
                    break;
                default:
                    System.exit(1);
            }
        }
    

    static void writeToFile() {
        try {
            FileWriter fw = new FileWriter(Memory.outputFile, true);
            fw.write("======Before Return from Subroutine Status======");
            fw.write("=============Stack Status=============");
            fw.write("Stack contents at 3FC = ");
            fw.write("Stack contents at 3FD = ");
            fw.write("Stack contents at 3FE = ");
            fw.write("Stack contents at 3FF = ");
            fw.write("=============Stack Status=============");
            fw.write("PC = " + intToHex(PC));
            fw.write("IR = " + intToHex(IR));
            fw.write("AC = " + intToHex(AC));
            fw.write("REG = " + intToHex(REG));
            fw.write("Memory 940 = " + (Memory.read(0x940)));
            fw.write("Memory 941 = " + (Memory.read(0x941)));
            fw.write("Memory 942 = ");
            fw.write("Number of instructions executed = ");
            fw.write("======Before Return from Subroutine 2 Status======");
            fw.write("=============Registers & Memory Status=============");
            fw.write("======End of Program Status======");
            fw.write("=============Stack Status=============");
            fw.write("=============Registers & Memory Status=============");
            fw.write("======Before Return from Subroutine 1 Status======");
            fw.write("======Before Return from Subroutine 1 Status======");

            fw.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
