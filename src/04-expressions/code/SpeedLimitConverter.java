class SpeedLimitConverter {
    public static void main(String[] args) {
        // Constants
        final double MILES_PER_KILOMETRE = 0.621371;

        // Variables
        double imperialSpeedLimit = 60.0;
        double metricSpeedLimit = 100.0;

        // Calculations
        double imperialToMetricSpeedLimit = imperialSpeedLimit / MILES_PER_KILOMETRE;
        double metricToImperialSpeedLimit = metricSpeedLimit * MILES_PER_KILOMETRE;

        // Display
        System.out.println(imperialSpeedLimit + " miles per hour is equivalent to " + imperialToMetricSpeedLimit +
                " kilometres per hour.");
        System.out.println(metricSpeedLimit + " kilometres per hour is equivalent to " + metricToImperialSpeedLimit +
                " metres per hour.");

        /* CHALLENGE */
        // Constants
        final double ACCELERATION_OF_GRAVITY_SI = 9.81; // m/s^2
        final double MILES_IN_METRE = 0.000621371;
        final double SECONDS_IN_HOUR = 3600.0;

        // Calculations
        double imperialAccelerationOfGravity = ACCELERATION_OF_GRAVITY_SI * MILES_IN_METRE * SECONDS_IN_HOUR *
                SECONDS_IN_HOUR;

        // Display
        System.out.println(ACCELERATION_OF_GRAVITY_SI + " metres per second-squared is equivalent to " +
                imperialAccelerationOfGravity + " miles per hour-squared.");
    }
}