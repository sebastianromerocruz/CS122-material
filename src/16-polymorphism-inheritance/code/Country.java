public class Country extends PoliticalEntity {
    private final String continent;

    public Country(String name, String continent, String typeOfGovernment) {
        super(name, typeOfGovernment);
        this.continent = continent;
    }

    @Override
    public void holdElections() {
        holdPresidentialElections();
        holdParliamentaryElections();
    }

    public String getContinent() {
        return continent;
    }

    private void holdPresidentialElections() {
        System.out.printf("%s, a %s in %s, is holding presidential elections...\n", getName(), getTypeOfGovernment(),
                getContinent());
    }

    private void holdParliamentaryElections() {
        System.out.printf("%s is also holding parliamentary elections...\n", getName());
    }
}
