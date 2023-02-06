class Stack {
    private int stackBottom;
    private int stackSize;

    public Stack() {
        this.stackBottom = 0;
        this.stackSize = 0;
    }

    public void push(String str) {
        if (stackSize < stackBottom + 100) {
            int top = stackBottom + stackSize;
            // store the string in memory
            // increment the size of the stack
        } else {
            System.out.println("Error");
        }
    }
