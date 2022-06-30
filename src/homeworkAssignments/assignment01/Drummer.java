package homeworkAssignments.assignment01;

public class Drummer extends BandMember {
    private static final int DEFAULT_NUMBER_OF_BASS_DRUM_PEDALS = 1;
    private static final int MAX_NUMBER_OF_BASS_DRUM_PEDALS = 2;

    private final int numberOfBassDrumPedals;

    public Drummer(String name, String instrument, boolean isLeader, int numberOfBassDrumPedals) {
        super(name, instrument, isLeader);

        if (numberOfBassDrumPedals > MAX_NUMBER_OF_BASS_DRUM_PEDALS) {
            this.numberOfBassDrumPedals = DEFAULT_NUMBER_OF_BASS_DRUM_PEDALS;
        } else {
            this.numberOfBassDrumPedals = numberOfBassDrumPedals;
        }
    }

    @Override
    public void perform() {
        System.out.printf("%s%s plays their %s%s!\n",
                getIsLeader() ? "Our band leader ": "",
                getName(),
                getInstrument(),
                getNumberOfBassDrumPedals() < MAX_NUMBER_OF_BASS_DRUM_PEDALS ? "" : " with two bass pedals");
    }

    public int getNumberOfBassDrumPedals() {
        return numberOfBassDrumPedals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drummer that = (Drummer) o;
        return super.equals(that) && numberOfBassDrumPedals == that.getNumberOfBassDrumPedals();
    }
}
