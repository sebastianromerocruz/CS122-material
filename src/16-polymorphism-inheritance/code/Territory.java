public class Territory extends PoliticalEntity {
    private final PoliticalEntity sovereign;

    public Territory(String name, String typeOfGovernment, PoliticalEntity sovereign) {
        super(name, typeOfGovernment);
        this.sovereign = sovereign;
    }

    @Override
    public void holdElections() {
        System.out.printf("%s, a non-governing territory of %s, is holding local elections.\n", getName(),
                sovereign.getName());
    }

    public PoliticalEntity getSovereign() {
        return sovereign;
    }
}
