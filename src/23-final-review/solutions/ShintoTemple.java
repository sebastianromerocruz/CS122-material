/**
 * Represents a Shinto temple, a type of temple that can be visited and explored.
 * A Shinto temple has a name, location, year built, and a torii.
 * A torii is a traditional Japanese gate that marks the entrance to a Shinto shrine.
 * A Shinto temple can be visited and explored, and a prayer can be conducted at the temple.
 * If a visitor tries to visit a Shinto temple without a torii, a VisitationNotAllowedException is thrown.
 * 
 * @see Temple
 * @see Prayer
 * @see VisitationNotAllowedException
 */
public class ShintoTemple extends Temple implements Prayer {
    private static final String NAME = "Shinto Shrine";

    public static void main(String[] args) {
        ShintoTemple shintoTemple = new ShintoTemple("Tokyo", 1600, false);

        System.out.println(shintoTemple);
        shintoTemple.explore();
    }

    private boolean hasTorii;

    /**
     * Constructs a new Shinto temple with the specified location, year built, and torii.
     * 
     * @param location the location of the Shinto temple
     * @param yearBuilt the year the Shinto temple was built
     * @param hasTorii true if the Shinto temple has a torii, false otherwise
     */
    public ShintoTemple(String location, int yearBuilt, boolean hasTorii) {
        super(NAME, location, yearBuilt);
        this.hasTorii = hasTorii;
    }

    /**
     * Conducts a prayer at the Shinto temple.
     * 
     * @throws VisitationNotAllowedException if the prayer cannot be conducted
     */
    @Override
    public void conductPrayer() throws VisitationNotAllowedException {
        if (!hasTorii()) {
            throw new VisitationNotAllowedException("Visitation to this Shinto temple is restricted without a torii.");
        }
        System.out.println("Conducting a prayer at the Shinto Shrine.");
    }


    /**
     * Explores the Shinto temple. 
     * If the Shinto temple has a torii, the visitor passes through the torii.
     * If the prayer cannot be conducted, a message is printed to the console.
     * 
     * @see #conductPrayer()
     * @see VisitationNotAllowedException
     */
    @Override
    public void explore() {
        try {
            conductPrayer();
        } catch (VisitationNotAllowedException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Exploring the mystical atmosphere of the Shinto Shrine.");
        if (hasTorii) {
            System.out.println("Passing through the sacred Torii, marking the entrance to the shrine.");
        }
    }

    /**
     * Returns true if the Shinto temple has a torii, false otherwise.
     * 
     * @return true if the Shinto temple has a torii, false otherwise
     */
    public boolean hasTorii() {
        return hasTorii;
    }
}