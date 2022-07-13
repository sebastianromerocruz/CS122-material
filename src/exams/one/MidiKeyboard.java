package exams.one;

public class MidiKeyboard implements Comparable {
    final private int numberOfKeys;
    final private String brand;

    public static void main(String[] args) {
        MidiKeyboard akaiMPK = new MidiKeyboard(25, "Akai");
        MidiKeyboard opOne = new MidiKeyboard(24, "Teenage Engineering");

        System.out.println(akaiMPK.compareTo(opOne));
    }

    public MidiKeyboard(int numberOfKeys, String brand) {
        this.numberOfKeys = numberOfKeys;
        this.brand = brand;
    }

    @Override
    public int compareTo(Object o) {
        return brand.compareTo(((MidiKeyboard) o).brand);
    }
}