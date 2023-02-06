import java.io.*;
import java.util.*;

public class Memory {
    private int[] memory = new int[4096];
    private int[] subTracker = new int[30];
    private File inputFile;
    private File outputFile;

    public void main(String[] args) {
        try {
            inputFile = new File(args[0]);
            outputFile = new File(args[1]);
            if (outputFile.exists()) {
                System.out.println("Output file already exists.");
                System.exit(0);
            }
            load();
            CPU.run();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    void load() {
        Scanner sc = null;
        try {
            sc = new Scanner(inputFile);
            int subIndex = 0;
            int lineNum = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.length() == 0 || line.charAt(0) == ';')
                    continue;
                String[] parts = line.split(" ");
                int address = Integer.parseInt(parts[1], 16);
                String opcode = parts[2];
                switch (opcode) {
                    case "0001":
                        memory[address] = 0x0001;
                        break;
                    case "0010":
                        memory[address] = 0x0010;
                        break;
                    case "0011":
                        memory[address] = 0x0011;
                        break;
                    case "0100":
                        memory[address] = 0x0100;
                        break;
                    case "0101":
                        memory[address] = 0x0101;
                        break;
                    case "0110":
                        memory[address] = 0x0110;
                        break;
                    case "0111":
                        memory[address] = 0x0111;
                        break;
                    case "1000":
                        memory[address] = 0x1000;
                        break;
                    case "1001":
                        memory[address] = 0x1001;
                        break;
                    case "1010":
                        memory[address] = 0x1010;
                        break;
                    case "1011":
                        memory[address] = 0x1011;
                        break;
                    case "1100":
                        memory[address] = 0x1100;
                        break;
                    case "1111":
                        memory[address] = 0x1111;
                        break;
                    case "B":
                        subTracker[subIndex++] = address;
                        break;
                }
            }
            Arrays.sort(subTracker);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } finally {
            if (sc != null)
                sc.close();
        }
    }

    String read(int address) {
        return Integer.toHexString(memory[address]);
    }
    public void store (int address, int value) {
        memory[address] = value;
    }

    public int load (int address) {
        return memory[address];
    }

    void write(int address, String data) {
        memory[address] = Integer.parseInt(data, 16);
    }

    public static int get(int pC) {
        return 0;
    }

    public static void set(int operand, int aC) {
    }
}
