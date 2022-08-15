package exceptions;

public class StandardDeviation {
    public static void main(String[] args) {
        StandardDeviation stdev = new StandardDeviation();

        double[] grades = { 79.5, 82.0, 82.0, 67.5, 71.5 };

        System.out.printf("The mean was %.2f, with a standard deviation of %.2f.\n",
                stdev.getAverage(grades), stdev.getStandardDeviation(grades));
    }

    public double getStandardDeviation(double[] numbers) {
        double standardDeviation = 0.0d;
        double average = this.getAverage(numbers);

        for(double number : numbers) {
            standardDeviation += Math.pow(number - average, 2);
        }

        return standardDeviation / numbers.length;
    }

    private double getAverage(double[] numbers) {
        return this.getSum(numbers) / numbers.length;
    }

    private double getSum(double[] numbers) throws StandardDeviationNotCalculableException {
        if (numbers == null || numbers.length == 0) {
            throw new StandardDeviationNotCalculableException("This array is unsuitable for standard deviation " +
                    "calculations. Check that it is not null or empty.");
        }

        double sum = 0;
        for (double number : numbers) sum += number;

        return sum;
    }
}
