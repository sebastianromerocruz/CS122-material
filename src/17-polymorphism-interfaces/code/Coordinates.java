package polymorphism.interfaces;

import java.lang.Comparable;
import java.util.Arrays;

public class Coordinates implements Comparable<Coordinates> {
    private final double latitude;
    private final double longitude;

    public static void main(String[] args) {

        Coordinates[] coordinates = {
                new Coordinates(Math.random(), Math.random()),
                new Coordinates(Math.random(), Math.random()),
                new Coordinates(Math.random(), Math.random()),
                new Coordinates(Math.random(), Math.random()),
                new Coordinates(Math.random(), Math.random()),
                new Coordinates(Math.random(), Math.random()),
        };

        System.out.println();

        Arrays.sort(coordinates);
    }

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object o) {
        // Check if the Object instance o exists and is of the same class.
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return ((Coordinates) o).getLatitude() == getLatitude() && ((Coordinates) o).getLongitude() == getLongitude();
    }

    @Override
    public int compareTo(Coordinates o) {
        // Here, we are asking Java to compare the string versions of our objects. If this is larger, this will return
        // 1. If it is smaller, it will return 0. Arrays.sort() uses these values with algorithms like selection sort
        // in order to actually sort.
        return toString().compareTo(o.toString());
    }

    @Override
    public String toString() {
        return "(%.2f, %.2f)".formatted(latitude, longitude);
    }
}
