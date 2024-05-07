/**
 * Represents a temple with a name, location, and year built.
 */
public abstract class Temple {
    private String name;
    private String location;
    private int yearBuilt;

    /**
     * Constructs a new Temple with the specified name, location, and year built.
     * @param name the name of the temple
     * @param location the location of the temple
     * @param yearBuilt the year the temple was built
     */
    protected Temple(String name, String location, int yearBuilt) {
        this.name = name;
        this.location = location;
        this.yearBuilt = yearBuilt;
    }

    /**
     * Explores the temple.
     */
    public abstract void explore();

    
    /**
     * The `equals` method in the Temple class checks if two Temple objects are equal based on their
     * year built, name, and location.
     * 
     * @param o The parameter `o` in the `equals` method represents the object to be compared for
     * equality with the current object.
     * @return The `equals` method is being overridden to compare two `Temple` objects based on their
     * year built, name, and location. It returns `true` if the compared objects are the same instance
     * or if their year built, name, and location are equal, and `false` otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temple temple = (Temple) o;
        return getYearBuilt() == temple.getYearBuilt() && getName().equals(temple.getName()) && getLocation().equals(temple.getLocation());
    }


    /**
     * The `toString` method in Java overrides the default implementation to return a formatted string
     * representation of a Temple object's attributes.
     * 
     * @return A string representation of a Temple object, including its name, location, and year built.
     */
    @Override
    public String toString() {
        return "Temple: " + name + "\n" +
                "Location: " + location + "\n" +
                "Year Built: " + yearBuilt;
    }

    // Getters for private attributes
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }
}