public class PoliticalEntity {
    private final String name;
    private final String typeOfGovernment;

    protected PoliticalEntity(String name, String typeOfGovernment) {
        this.name = name;
        this.typeOfGovernment = typeOfGovernment;
    }

    public void holdElections() {
        System.out.printf("%s will now hold elections...", name);
    }

    public String getName() {
        return name;
    }

    public String getTypeOfGovernment() {
        return typeOfGovernment;
    }
}
