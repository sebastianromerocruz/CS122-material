import java.util.Arrays;

/**
 * Japan is a class that demonstrates the use of abstract classes and interfaces in Java.
 * It contains a main method that creates instances of ShintoTemple and BuddhistTemple objects
 * and demonstrates the use of the searchForOffering method to search for offerings in an array.
 * 
 * @see ShintoTemple
 * @see BuddhistTemple
 * @see Temple
 * @see Prayer
 * @see VisitationNotAllowedException
 * @see searchForOffering
 */
public class Japan {
    public static final String[] OFFERINGS = {
        "Incense", 
        "Flowers", 
        "Fruits", 
        "Candles", 
        "Coins"
    };

    public static void main(String[] args) {
        Temple shintoTemple = new ShintoTemple("Kyōto", 794, true);
        Temple buddhistTemple = new BuddhistTemple("Nara", 607, true);

        System.out.println(shintoTemple);
        shintoTemple.explore();

        System.out.println(buddhistTemple);
        buddhistTemple.explore();

        System.out.println(searchForOffering(OFFERINGS, "Fruits"));
        System.out.println(searchForOffering(OFFERINGS, "Water"));
    }

    /**
     * The method recursively searches for a specific offering in an array of offerings.
     * 
     * @param offerings An array of strings representing different offerings.
     * @param offering The offering to search for in the offerings array.
     * @return The method `searchForOffering` is returning a boolean value, which indicates whether the
     * specified `offering` is found in the `offerings` array.
     */
    public static boolean searchForOffering(String[] offerings, String offering) {
        if (offerings == null) throw new NullPointerException("Offerings array cannot be null.");
        if (offerings.length == 0) return false;
        if (offerings[0].equals(offering)) return true;

        return searchForOffering(Arrays.copyOfRange(offerings, 1, offerings.length), offering);
    }
}
