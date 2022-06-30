package homeworkAssignments.assignment01;

public class KeyboardPlayer extends BandMember {
    private static final String DEFAULT_PRESET = "piano";

    private final String preset;

    public KeyboardPlayer(String name, String instrument, boolean isLeader, String preset) {
        super(name, instrument, isLeader);
        this.preset = preset;
    }

    @Override
    public void perform() {
        System.out.printf("%s%s plays the %s on their %s!\n",
                getIsLeader() ? "Our band leader ": "",
                getName(),
                getPreset(),
                getInstrument());
    }

    public String getPreset() {
        return preset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyboardPlayer that = (KeyboardPlayer) o;

        return super.equals(that) && getPreset().equals(that.getPreset());
    }
}
