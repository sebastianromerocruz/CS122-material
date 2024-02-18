import java.util.Scanner;

class ArrayExample {
    static void highestFromArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many random numbers would you like to store in an array? ");
        int length = scanner.nextInt();
        scanner.close();

        double[] numbers = new double[length];
        for (int idx = 0; idx < length; idx++) numbers[idx] = Math.random() * 100.0;

        double max = Double.MIN_VALUE;
        for (int idx = 0; idx < length; idx++) if (numbers[idx] > max) max = numbers[idx];

        System.out.println("The max number generated was: " + max);
    }
    
    static void inputArrays() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many numbers would you like to store in an array? ");
        int length = scanner.nextInt();
        double[] numbers = new double[length];

        for (int idx = 0; idx < length; idx++) numbers[idx] = scanner.nextDouble();

        scanner.close();
    }

    static void randomArrays() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many random numbers would you like to store in an array? ");
        int length = scanner.nextInt();
        scanner.close();

        double[] numbers = new double[length];

        // random numbers from 0.0 to 100.0
        for (int idx = 0; idx < length; idx++) numbers[idx] = Math.random() * 100.0;
        
        for (int idx = 0; idx < length; idx++) System.out.println(numbers[idx]);
    }

    public static void main(String[] args) {
        // final int EXAM_AMOUNT = 3;

        // int[] examGrades = new int[EXAM_AMOUNT];
        
        // examGrades[0] = 80;
        // examGrades[1] = 75;
        // examGrades[2] = 96;
        
        // for (int idx = 0; idx < examGrades.length; idx++) {
        //     System.out.println("Element at location " + idx + ": " + examGrades[idx]);
        // }
        
        // System.out.println(examGrades);

        // highestFromArray();
        int[] numbers = { 1, 2, 3 };

        for (int number : numbers) {
            System.out.println(number);
        }

        String[] members = { "Hitori", "Ikuyo", "Ryō", "Nijika" };

        for (String member : members) member = member.toUpperCase();
        for (String member : members) System.out.println(member);
    }
}