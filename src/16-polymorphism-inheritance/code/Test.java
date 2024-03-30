public class Test {
    public static void main(String[] args) {
        Country france          = new Country("France", "Europe", "Semiparliamentary Presidential Republic");
        PoliticalEntity czechia = new Country("Czechia", "Europe", "Unitary Parliamentary Republic");
        Country japan           = new Country("Japan", "Asia", "Unitary Parliamentary Constitutional Monarchy");
        Territory gibraltar     = new Territory("Gibraltar", "Devolved representative democratic parliamentary dependency", france);

        PoliticalEntity[] countriesHoldingElections = { france, czechia, japan, gibraltar };

        for (PoliticalEntity politicalEntity : countriesHoldingElections) {
            politicalEntity.holdElections();
        }
    }
}
