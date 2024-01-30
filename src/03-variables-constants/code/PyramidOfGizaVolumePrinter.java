public class PyramidOfGizaVolumePrinter {
    public static void main(String[] args) {
        // Constants
        final double PYRAMID_OF_GIZA_HEIGHT = 138.5;
        final double PYRAMID_OF_GIZA_BASE_SIDE_LENGTH = 230.33;

        // Calculations
        double pyramidOfGizaBaseArea = PYRAMID_OF_GIZA_BASE_SIDE_LENGTH * PYRAMID_OF_GIZA_BASE_SIDE_LENGTH;
        double pyramidOfGizaVolume = pyramidOfGizaBaseArea * PYRAMID_OF_GIZA_HEIGHT / 3;

        // Display results
        System.out.println(pyramidOfGizaVolume);
    }
}