package homeworkAssignments.assignment01;

public class Guitarist extends BandMember {
    private final boolean isUsingDistortion;
    private final String guitarBrand;

    public Guitarist(String name, String instrument, boolean isLeader, boolean isUsingDistortion, String guitarBrand) {
        super(name, instrument, isLeader);
        this.isUsingDistortion = isUsingDistortion;
        this.guitarBrand = guitarBrand;
    }

    @Override
    public void perform() {
        System.out.printf("%s%s plays their %s%s %s!\n",
                getIsLeader() ? "Our band leader ": "",
                getName(),
                getIsUsingDistortion() ? "distorted " : "",
                getGuitarBrand(),
                getInstrument());
    }

    public String getGuitarBrand() {
        return guitarBrand;
    }

    public boolean getIsUsingDistortion() {
        return isUsingDistortion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guitarist that = (Guitarist) o;
        return super.equals(that) && isUsingDistortion == that.getIsUsingDistortion() &&
                guitarBrand.equals(that.getGuitarBrand());
    }
}
