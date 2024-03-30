public class Coordinates {
    private final double latitude;
    private final double longitude;

    public static void main(String args[]) {
        Coordinates pointA = new Coordinates(34.5d, 40.0d);
        Coordinates pointB = new Coordinates(34.5d, 40.0d);

        System.out.println(pointA.equals(pointB));
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
}
