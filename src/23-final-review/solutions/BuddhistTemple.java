/**
 * Represents a Buddhist Temple that extends the Temple class. 
 * A Buddhist Temple has a name, location, year built, and a boolean value 
 * indicating whether the temple is Zen.
 * A Buddhist Temple can be explored, and if the temple is Zen, the visitor 
 * can engage in meditation under the guidance of Zen masters.
 * 
 * @see Temple
 */
public class BuddhistTemple extends Temple {
    private static final String NAME = "Buddhist Temple";

    public static void main(String[] args) {
        BuddhistTemple buddhistTemple = new BuddhistTemple("Kyoto", 1200, true);

        System.out.println(buddhistTemple);
        buddhistTemple.explore();
    }

    private boolean isZen;

    /**
     * Constructs a new Buddhist Temple with the specified location, year built, and Zen status.
     * 
     * @param location the location of the Buddhist Temple
     * @param yearBuilt the year the Buddhist Temple was built
     * @param isZen true if the Buddhist Temple is Zen, false otherwise
     */
    public BuddhistTemple(String location, int yearBuilt, boolean isZen) {
        super(NAME, location, yearBuilt);
        this.isZen = isZen;
    }

    /**
     * Explores the Buddhist Temple.
     * If the Buddhist Temple is Zen, the visitor engages in meditation under the guidance of Zen masters.
     */
    @Override
    public void explore() {
        System.out.println("Exploring the serene ambiance of the Buddhist Temple.");
        if (isZen()) {
            System.out.println("Engaging in meditation under the guidance of Zen masters.");
        }
    }

    public boolean isZen() {
        return isZen;
    }
}