package interfaces.interfaces;

public abstract class StringedInstrument implements MusicalInstrument {
    private final int numberOfStrings;

    public StringedInstrument(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }
}
