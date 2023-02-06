import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CPU {
    private int PC, IR, AC, REG;

    // Methods
    // Implements the fetch and execute cycle. The cycle runs until the halt
    // instructions is encountered.
    public void run() {
        while (true) {
            fetch();
            executeInstruction();
        }
    }

    // Fetch reads an instruction from memory at the address stored in PC and stores
    // it in IR, then increments PC.
    public void fetch() {
        // Instruction is located at the memory address stored in PC is being read and
        // stored in the IR
        // PC is incremented by 1 so that the next instruction can be fetched.
        // Retrieves value stored at the memory address specified by the PC.
        IR = memory.get(PC);
        PC++;
    }

    public void executeInstruction(int opcode, int operand) {
        switch (opcode) {
            case 0x0001: // Load AC from memory
                AC = memory.get(operand);
                break;
            case 0x0010: // Store AC to memory
                memory.set(operand, AC);
                break;
            case 0x0011: // Load AC from REG
                AC = REG;
                break;
            case 0x0100: // Store AC to REG
                REG = AC;
                break;
            case 0x0101: // Add to AC from memory
                AC += memory.get(operand);
                break;
            case 0x0110: // Load REG with operand
                REG = operand;
                break;
            case 0x0111: // Add REG to AC
                AC += REG;
                break;
            case 0x1000: // Multiply REG to AC
                AC *= REG;
                break;
            case 0x1001: // Subtract REG from AC
                AC -= REG;
                break;
            case 0x1010: // Divide AC by REG value
                AC /= REG;
                break;
            case 0x1011: // Jump to subroutine starting at the address
                stack.push(PC);
                stack.push(IR);
                stack.push(AC);
                stack.push(REG);
                PC = operand;
                break;
            case 0x1100: // Return from the subroutine
                REG = stack.pop();
                AC = stack.pop();
                IR = stack.pop();
                PC = stack.pop();
                break;
            case 0x1111: // Halt
                halt();
                break;

        }
    }
    File outputFile = new File ("output.txt");
    try (FileWriter writer = new FileWriter(outputFile)){
        writer.write(" ");
    }
    catch (IOException e) {
        System.out.println("Error " + e.getMessage());
    }
}
}
