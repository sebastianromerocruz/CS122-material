package exceptions;

public class StandardDeviation {
    public static void main(String[] args) {
        StandardDeviation stdev = new StandardDeviation();

        int[] grades = null;

        System.out.printf("The standard deviation is %.2f.\n", stdev.getStandardDeviation(grades));
    }

    public double getStandardDeviation(int[] numbers) {
        double standardDeviation = 0.0d;
        double average = this.getAverage(numbers);

        for(double number : numbers) {
            standardDeviation += Math.pow(number - average, 2);
        }

        return standardDeviation;
    }

    private double getAverage(int[] numbers) {
        return (double) this.getSum(numbers) / numbers.length;
    }

    private int getSum(int[] numbers) throws StandardDeviationNotCalculableException {
        if (numbers == null || numbers.length == 0) {
            throw new StandardDeviationNotCalculableException("This array is unsuitable for standard deviation " +
                    "calculations. Check that it is not null or empty.");
        }

        int sum = 0;
        for (int number : numbers) sum += number;

        return sum;
    }
}
