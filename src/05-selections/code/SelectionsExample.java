import java.util.Scanner;

class SelectionsExample {
    public static void main(String[] args) {
        final String USER_PASSWORD = "thisIsAGoodPassword";
        final int R_RATED_MOVIE_AGE = 18;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String userInput = scanner.nextLine();

        if (userInput.equals(USER_PASSWORD)) {
            System.out.println("Logging in...");
        } else {
            System.out.println("ERROR: Incorrect password.");
        }

        // System.out.print("How old are you? ");
        // int userAge = scanner.nextInt();

        // if (userAge == R_RATED_MOVIE_AGE) {
        //     System.out.println("Happy birthday! You can watch R-rated films by yourself.");
        // } else if (userAge > R_RATED_MOVIE_AGE) {
        //     System.out.println("You can watch R-rated films by yourself.");
        // } else {
        //     System.out.println("You need to be chaperoned by someone to watch R-rated films.");
        // }

        System.out.print("Is anybody in your party 18 or over? (true/false) ");
        boolean isChaperoned = scanner.nextBoolean();

        if (!isChaperoned) {
            System.out.print("How old are you? ");
            int userAge = scanner.nextInt();

            if (userAge == R_RATED_MOVIE_AGE) {
                System.out.println("Happy birthday! You can watch R-rated films by yourself.");
            } else if (userAge > R_RATED_MOVIE_AGE) {
                System.out.println("You can watch R-rated films by yourself.");
            }
        } else {
            System.out.println("You need to be chaperoned by someone to watch R-rated films.");
        }

        scanner.close();
    }   
}
