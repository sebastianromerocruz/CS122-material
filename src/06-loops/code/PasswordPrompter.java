import java.util.Scanner;

class PasswordPrompter {
    public static void main(String[] args) {
        final String PASSWORD = "correctPassword";

        Scanner scanner = new Scanner(System.in);
    
        // System.out.print("Enter your password: ");
        // String userPassword = scanner.nextLine();

        // while (!userPassword.equals(PASSWORD)) {
        //     System.out.print("Incorrect password. Enter your password: ");
        //     userPassword = scanner.nextLine();
        // }

        String userPassword;

        do {
            System.out.print("Enter your password: ");
            userPassword = scanner.nextLine();

            if (!userPassword.equals(PASSWORD)) { System.out.print("Incorrect! "); }
        } while (!userPassword.equals(PASSWORD));

        System.out.println("Welcome.");

        scanner.close();
    }
}
