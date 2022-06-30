package homeworkAssignments.assignment01;

public abstract class BandMember implements Musician {
    private final String name;
    private final String instrument;
    private final boolean isLeader;

    protected BandMember(String name, String instrument, boolean isLeader) {
        this.name = name;
        this.instrument = instrument;
        this.isLeader = isLeader;
    }

    public String getName() {
        return name;
    }

    public String getInstrument() {
        return instrument;
    }

    public boolean getIsLeader() {
        return isLeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BandMember that = (BandMember) o;

        return isLeader == that.isLeader && name.equals(that.getName()) && instrument.equals(that.getInstrument());
    }
}