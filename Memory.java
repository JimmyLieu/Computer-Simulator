import java.io.*;
import java.util.*;
public class Memory {
    
    static String[] memory = new String[4096];
    public static File inputFile;
    public static File outputFile;
    public static void main(String[] args) throws FileNotFoundException {
        try {
            inputFile = new File((args.length > 0 )? args[0]: "input.txt");
            outputFile = new File((args.length > 1)? args[1]: "output.txt");
            if (outputFile.exists()) {
                System.out.println("Output file already exists.");
                System.exit(0);
            }
            Memory.load();
            CPU.start();
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
    }
}
    ArrayList<String>memoryLocation = new ArrayList<>();

    public static void load() throws FileNotFoundException {
        try{
            Scanner scanner = new Scanner(new File("input.txt"));
        while (scanner.hasNextLine()){
            
            String line = scanner.nextLine();
            int period = line.indexOf(".");
            if (period == -1){
            }
            else{
            //line = line.substring(line.indexOf(".")+1);
            line = line.substring(line.indexOf(".") + 1 , line.indexOf(";"));
            System.out.println(line);
            }
        }
           

        scanner.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }}
    

    
    public static void write(String data, int i) {

    }
    public static String read(int i) {
        return null;
    }
}