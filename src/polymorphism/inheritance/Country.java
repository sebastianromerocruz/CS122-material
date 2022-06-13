package polymorphism.inheritance;

public class Country extends PoliticalEntity {
    private final String continent;

    public static void main(String[] args) {
        Country france = new Country("France", "Europe", "Semiparliamentary Presidential Republic");
        PoliticalEntity czechia = new Country("Czechia", "Europe", "Unitary Parliamentary Republic");
        Country japan = new Country("Japan", "Asia", "Unitary Parliamentary Constitutional Monarchy");
        NonSelfGoverningTerritory gibraltar = new NonSelfGoverningTerritory("Gibraltar", "Devolved representative democratic parliamentary dependency", france);

        PoliticalEntity[] countriesHoldingElections = { france, czechia, japan, gibraltar };

        for (PoliticalEntity politicalEntity : countriesHoldingElections) {
            politicalEntity.holdElections();
        }
    }

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
