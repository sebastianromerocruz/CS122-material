package exceptions;

public class Zero {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            System.out.printf("%d\n", numerator / denominator);
        } catch(ArithmeticException ae) {
            System.out.printf("%d cannot be divided by %d!\n", numerator, denominator);
        }

        System.out.print("PROGRAM ENDED.\n");
    }
}
