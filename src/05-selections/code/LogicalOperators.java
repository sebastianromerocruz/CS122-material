import java.util.Scanner;

class LogicalOperators {
    public static void main(String[] args) {
        /*
         * NOT operator
         */
        final int AMERICAN_DRINKING_AGE = 21;

        Scanner scanner = new Scanner(System.in);

        System.out.print("How old are you? ");
        int age = scanner.nextInt();

        System.out.println("You are NOT old enough to drink in the United States: " + 
                            !(age >= AMERICAN_DRINKING_AGE));

        /*
         * AND operator
         */
        System.out.print("Do you have valid identification with you? ");
        boolean hasIdentification = scanner.nextBoolean();

        System.out.println("You may purchase alcohol in the United States: " + 
                            (age >= AMERICAN_DRINKING_AGE && hasIdentification));

        /*
         * OR operator
         */
        System.out.print("Are you accompanied by an adult? ");
        boolean isAccompanied = scanner.nextBoolean();
        boolean isLicensedAdult = age >= AMERICAN_DRINKING_AGE && hasIdentification;
        
        System.out.println("You may go ahead with your purchase of alcohol: " + 
                            (isAccompanied || isLicensedAdult));

        scanner.close();
    }
}
