class MemoryModel {
    static void increment(int integer) {
        integer++;
    }

    static void modifyArray(int[] anArray) {
        for (int idx = 0; idx < anArray.length; idx++) {
            anArray[idx] *= 100;
        }
    }

    public static void main(String[] args) {
        // int integer = 42;

        // System.out.println("The value of integer before we call increment() is: " + integer);
        // increment(integer);
        // System.out.println("The value of integer after we call increment() is: " + integer);

        int[] integers = { 1, 2, 3 };

        System.out.print("Array values before calling modifyArray(): ");
        for(int integer : integers) {
            System.out.print(integer + " ");
        }
        
        modifyArray(integers);
        
        System.out.print("\nArray values after calling modifyArray(): ");
        for(int integer : integers) {
            System.out.print(integer + " ");
        }
    }
}