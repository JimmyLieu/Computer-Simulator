class Stack {
    static int bottom = 0x3FF;
    static int size = 0;
    public static void push(String data) {
        Memory.write(data, bottom - size);
        size++;

         }

    public static String pop(){
        size--; 
         String temp = Memory.read(bottom - size);
        Memory.write(null, bottom - size);
        return temp;
    }
    }



