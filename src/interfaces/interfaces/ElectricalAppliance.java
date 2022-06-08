package interfaces.interfaces;

public interface ElectricalAppliance {
    double voltage = 90.0d;  // default voltage of every electrical appliance object

    public double getElectricalCurrent(double resistance);
}
