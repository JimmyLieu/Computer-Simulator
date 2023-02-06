import java.io.*;
import java.util.*;
import java.ArrayList;

public class Memory {
    static String[] memory = new String[4096];
   
    public static File inputFile;
    public File outputFile;

    public void main(String[] args) {
        try {
            inputFile = new File(args[0]);
            outputFile = new File(args[1]);
            if (outputFile.exists()) {
                System.out.println("Output file already exists.");
                System.exit(0);
            }
            Memory.load();
            CPU.run();
        } catch (Exception e) {
            System.out.println("Error: " + e);
       
    }
}
    public static String get(int address){
        return memory[address];
}
    public static String set(int address){
        return memory[address];

    }


    private static void load() throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        ArrayList<String> memlocation = new ArrayList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            
        }

    }
}