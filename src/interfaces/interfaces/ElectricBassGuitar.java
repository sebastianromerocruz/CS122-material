package interfaces.interfaces;

public class ElectricBassGuitar extends StringedInstrument implements ElectricalAppliance {
    private final String brand;

    public static void main(String[] args) {
        double amplifierResistance = 100.50;
        ElectricBassGuitar rickenbacker4001 = new ElectricBassGuitar(4, "Rickenbacker");

        rickenbacker4001.play();

        System.out.printf("The electric current running through our amplifier is of about %.2f volts.\n",
                rickenbacker4001.getElectricalCurrent(amplifierResistance));
    }

    public ElectricBassGuitar(int numberOfStrings, String brand) {
        super(numberOfStrings);
        this.brand = brand;
    }

    // From the ElectricalAppliance interface
    @Override
    public double getElectricalCurrent(double resistance) {
        return voltage / resistance;
    }

    // From the MusicalInstrument interface
    @Override
    public void play() {
        System.out.printf(
                "Playing our %s %d-string electric bass guitar with a voltage of %.2f amps!\n",
                brand, super.getNumberOfStrings(), voltage
        );
    }
}
