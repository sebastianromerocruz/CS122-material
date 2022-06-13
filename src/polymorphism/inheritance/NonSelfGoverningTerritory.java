package polymorphism.inheritance;

public class NonSelfGoverningTerritory extends PoliticalEntity {
    private final PoliticalEntity governingPoliticalEntity;

    public NonSelfGoverningTerritory(String name, String typeOfGovernment, PoliticalEntity governingPoliticalEntity) {
        super(name, typeOfGovernment);
        this.governingPoliticalEntity = governingPoliticalEntity;
    }

    @Override
    public void holdElections() {
        System.out.printf("%s, a non-governing territory of %s, is holding local elections.\n", getName(),
                governingPoliticalEntity.getName());
    }

    public PoliticalEntity getGoverningPoliticalEntity() {
        return governingPoliticalEntity;
    }
}
