package homeworkAssignments.assignment01;

public class Bassist extends BandMember {
    private static int DEFAULT_NUMBER_OF_STRINGS = 4;

    private final int numberOfStrings;
    private final String bassBrand;

    public Bassist(String name, String instrument, boolean isLeader, int numberOfStrings, String bassBrand) {
        super(name, instrument, isLeader);
        this.numberOfStrings = numberOfStrings;
        this.bassBrand = bassBrand;
    }

    public Bassist(String name, String instrument, boolean isLeader, String bassBrand) {
        super(name, instrument, isLeader);
        this.bassBrand = bassBrand;
        this.numberOfStrings = DEFAULT_NUMBER_OF_STRINGS;
    }

    @Override
    public void perform() {
        System.out.printf("%s%s plays their %d-stringed %s %s!\n",
                getIsLeader() ? "Our band leader ": "",
                getName(),
                getNumberOfStrings(),
                getBassBrand(),
                getInstrument());
    }

    public String getBassBrand() {
        return bassBrand;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bassist that = (Bassist) o;
        return super.equals(that) && numberOfStrings == that.getNumberOfStrings() &&
                getBassBrand().equals(that.getBassBrand());
    }
}
