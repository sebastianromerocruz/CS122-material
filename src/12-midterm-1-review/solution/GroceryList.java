import java.util.Scanner;

public class GroceryList {
    public static String[] ITEMS = {
        "Kiwis", "Granola", "Eggs",
        "Yuzu", "Tamarind", "Hibiscus",
        "Gochujang", "Cod", "Pasta"
    };

    public static String END_SIGNAL = "DONE";

    public static boolean getItem(String[] cart, int itemsInCart) {
        // STEP 1
        if (itemsInCart >= cart.length) {
            System.out.println("ERROR: Cart full.");
            return false;
        }

        // STEP 2
        int randomIdx = (int) (Math.random() * ITEMS.length);
        String randomItem = ITEMS[randomIdx];
        System.out.println("Picked: " + randomItem);

        // STEP 3
        cart[itemsInCart] = randomItem;

        // STEP 4
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // STEP 1
        System.out.println("Welcome to the Grocery Lottery!");

        // STEP 2
        System.out.print("How big is your cart? ");
        int cartSize = scanner.nextInt();

        // STEP 3
        String[] cart = new String[cartSize];
        int cartCapacity = 0;

        // STEP 4
        String choice;
        do {
            // STEP 4.i
            System.out.print("\nTake an item? [Y/N/DONE] ");
            choice = scanner.next();

            // STEPS 4.ii and 4.iii
            if (choice.equals("N") || choice.equals(END_SIGNAL)) continue;

            // STEPS 4.iv
            if (getItem(cart, cartCapacity)) {
                System.out.println("Cart capacity: " + ++cartCapacity);
            } else {
                System.out.println("Cart capacity (FULL): " + cartCapacity);
            }
        } while (!choice.equals(END_SIGNAL)); 

        System.out.println("\nThank you for coming to the Grocery Lottery!");

        scanner.close();
    }
}
