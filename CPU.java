import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;

public class CPU {
    //PC, IR, AC, REG, Instruction Counter, Subroutine number tracker
    public static int PC, IR, AC, REG;

    //Methods 
    public static int toInt(String hex){
        return Integer.parseInt(hex,16);
    }
    public static String intToHex(int num) {
        return Integer.toHexString(num);
      }
    //Fetch and execute cycle
    static void start(){
        while(true){
            fetch();
            execute();
        }
    }
    //fetch instructions from PC and store in IR
    static void fetch(){
        //Read data from Memory at address PC and store in IR
        //Increment PC

    }
    //execute instructions stored in IR
    static void execute(){
        //Store opcode and operand seperately
        //Increment instruction counter
        //Run commands according to opcode(use switch statement)
    }
    static public void executeInstruction(int opcode, int operand) {
        switch (opcode) {
            case 0x0001: // Load AC from memory
                AC = toInt(Memory.read(operand));
                break;
            case 0x0010: // Store AC to memory
                Memory.write(intToHex(AC), operand);
                break;
            case 0x0011: // Load AC from REG
                AC = REG;
                break;
            case 0x0100: // Store AC to REG
                REG = AC;
                break;
            case 0x0101: // Add to AC from memory
                AC += toInt(Memory.read(operand));
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
                Stack.push(intToHex(PC));              
                Stack.push(intToHex(IR));
                Stack.push(intToHex(AC));
                Stack.push(intToHex(REG));
                PC = operand;
                break;
            case 0x1100: // Return from the subroutine
                REG = toInt(Stack.pop());
                AC = toInt(Stack.pop());
                IR = toInt(Stack.pop());
                PC = toInt(Stack.pop());
                break;
            case 0x1111: // End
                System.exit(0);
                break;
            default :
                System.exit(1);
        }
    }
    
    public static void load() {
    }
       /**  class WriteToFile    {
            public static void main (String[] args) {
                try {
                    FileWriter myWriter = new FileWriter("output.txt");
                    myWriter.write("======Before Return from Subroutine 1 Status======");
                    myWriter.write("=============Stack Status=============");
                    myWriter.write(""");
                    myWriter.write("=============Registers & Memory Status=============");
    
                    
                    myWriter.write("======Before Return from Subroutine 2 Status======");
                    myWriter.write("=============Stack Status=============");
                    myWriter.write("=============Registers & Memory Status=============");
                    myWriter.write("======End of Program Status======");
                    myWriter.write("")


                    myWriter.close();

                } catch (IOException e) {
                    System.out.println("Error");
                }
            }
            
        }*/
    
}

