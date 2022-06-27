package polymorphism.sortingAndSearching;

import java.util.Arrays;

public class Country implements Comparable<Country> {

    private final String stateName;
    private final int startYear;
    private final String continent;

    public static void main(String[] args) {
        Country france = new Country("France",1958, "Europe");
        Country japan = new Country("Japan", 1947, "Asia");
        Country portugal = new Country("Portugal", 1976, "Europe");
        Country algeria = new Country("Algeria", 1962, "Africa");
        Country mexico = new Country("Mexico", 1917, "North America");

        Country[] countries = new Country[] {
                portugal, japan, mexico, france, algeria
        };

        // Print contents before sorting...
        for (Country country : countries) {
            System.out.println("-> " + country);
        }

        // Sort...
        Comparer.selectionSort(countries);
        System.out.println();  // for nice formatting

        // Print contents after sorting...
        for (Country country : countries) {
            System.out.println("-> " + country);
        }

        Country theMotherland = new Country("Mexico", 1917, "North America");

        System.out.printf(
                "\nBinary search result: %s",
                Comparer.binarySearch(countries, theMotherland) == null ? "NOT FOUND!\n" : "FOUND!\n"
        );
    }

    public Country(String stateName, int startYear, String continent) {
        this.stateName = stateName;
        this.startYear = startYear;
        this.continent = continent;
    }

    // INHERITED FROM THE Object CLASS...
    @Override
    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }

        return continent.equals(((Country)o).continent) &&
                startYear == ((Country)o).startYear &&
                stateName.equals(((Country)o).stateName);
    }

    @Override
    public String toString() {
        return "%s, %s: %d".formatted(stateName, continent, startYear);
    }

    // ACCESSIBLE VIA THE Comparable INTERFACE...
    @Override
    public int compareTo(Country o) {
        return Integer.compare(startYear, o.startYear);
    }
}
