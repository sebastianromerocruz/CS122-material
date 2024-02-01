import java.util.Scanner;

class ScannerExample {
    public static void main(String[] args) {
        // Create a Scanner object and store it inside of the scanner variable
        // Note that, as an argument to its constructor, we need to specify that
        // we are using the system's standard input
        Scanner scanner = new Scanner(System.in);

        // We use the Scanner class's nextLine() method to prompt the user to enter a string,
        // creating a String object
        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        
        // Output
        System.out.println("Your name is " + name + ".");

        // We use the Scanner class's nextInt() method to prompt the user to enter an integer
        System.out.print("How old are you? ");
        int age = scanner.nextInt();
        
        // Output
        System.out.println("You are " + age + "-year(s)-old.");

        // To avoid memory leaks, we need to close the scanner so that it stops expecting input
        // using its close() method
        scanner.close();
    }
}
