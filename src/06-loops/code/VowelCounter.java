import java.util.Scanner;

class VowelCounter {
    public static void main(String[] args) {
        /*
         * Ask for input
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Say anything: ");
        String anything = scanner.nextLine().toLowerCase();  // I immediately lowercase this to make the check easier

        scanner.close();

        int vowelAmount = 0;

        /*
         * Iterating from 0 to the length of the input
         */
        for (int idx = 0; idx < anything.length(); idx++) {
            char character = anything.charAt(idx);

            /*
             * Using a switch to quickly check through the vowels.
             */
            switch (character) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelAmount++;
                    break;
            
                default:
                    break;
            }
        }

        System.out.println("Your input contained " + vowelAmount + " vowel(s).");
    }
}
