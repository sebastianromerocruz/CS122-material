import java.util.Scanner;

class ObjectEqualsExample {
    public static void main(String[] args) {
        /*
         * Checking equality in VALUE
         */
        String anglicised_name = "Reina Kousaka";
        String romaji_name = "Rēna Kōsaka";
        System.out.println(romaji_name.equals(anglicised_name));

        final String USER_EMAIL = "sromerocruz@pace.edu";
        String email = "sromerocruz@pace.edu";
        System.out.println(USER_EMAIL.equals(email));

        /*
         * Checking equality in MEMORY LOCATION
         */
        Scanner scanner_a = new Scanner(System.in);
        Scanner scanner_b = new Scanner(System.in);
        Scanner scanner_alias = scanner_a;  // here, we don't create a new object, we just create another "link" to the same memory address
        System.out.println(scanner_a == scanner_b);
        System.out.println(scanner_a == scanner_alias);

        scanner_a.close();
        scanner_b.close();
    }
}
