import java.io.*;
import java.util.*;

public class Memory {

    static String[] memoryArray = new String[4096];
    static String[] instruction = new String[0];
    ArrayList<String> memoryLocation = new ArrayList<>();
    public static File inputFile;
    public static File outputFile;

    public static void main(String[] args) throws FileNotFoundException {
        try{
        inputFile = new File((args.length > 0) ? args[0] : "input.txt");
        outputFile = new File((args.length > 1) ? args[1] : "output.txt");
    if(outputFile.exists() ==true ){
        outputFile.delete();
        outputFile.createNewFile();
    } 
       Memory.load();
        CPU.begin();
        CPU.writeToFile();
    } catch (Exception e) {

    }

    }

    public static void load() throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                int period = line.indexOf(".");
                if (period == -1) {
                } else {
                    // line = line.substring(line.indexOf(".")+1);
                    line = line.substring(line.indexOf(".") + 2, line.indexOf(";"));
                    //System.out.println(line);
                    String instruction = line.substring(4, 5).trim();
                    //System.out.println("opCode: " + instruction);
                    String memoryAddress = line.substring(0, 3).trim();
                    //Integer.parseInt(memoryAddress, 16);
                    //System.out.println("Memory Address: " + memoryAddress);
                    String opInstruction = line.substring(5, 9).trim();
                    //System.out.println("Address of Instruction: " + opInstruction);
                    //System.out.println("");
                    write(opInstruction, CPU.toInt(memoryAddress));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void write(String data, int i) {
        // Write the data into the array at the address given by the first 3 digit
        // numbers
        // Take in address and at memory location and data i want to put in there
        memoryArray[i] = data;
    }

    // i = address of the location
    public static String read(int i) {
        return memoryArray[i];
    }
}