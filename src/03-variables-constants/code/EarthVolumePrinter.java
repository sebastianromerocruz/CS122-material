class EarthVolumePrinter {
    public static void main(String[] args) {
        // Step 1: Define our constants
        final double PI = 3.14159;

        // Step 2: Define our variables
        double radiusOfEarth = 6.3781E6;
        double pi = 3.14159;
        
        // Step 3: Calculate the area
        double areaOfEarth = (4.0 / 3.0) * PI * Math.pow(radiusOfEarth, 2);

        // Step 4: Display the result to the user   
        System.out.println("The area of the Earth is: " + areaOfEarth);
    }
}