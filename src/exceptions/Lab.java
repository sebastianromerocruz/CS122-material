package exceptions;

public class Lab {
    public static double getAverageLength(String[] strings) {
        double averageLength = -1;

        try {
            int amountOfStrings = strings.length;
            int sumOfLengths = 0;

            for (String string : strings) {
                sumOfLengths += string.length();
            }

            averageLength = (double) sumOfLengths / amountOfStrings;

            return averageLength;
        } catch (NullPointerException exception) {
            System.out.println("Either the array or one of its elements is null!");
        } catch (ArithmeticException exception) {
            System.out.println("Divide by zero error!");
        }

        return averageLength;
    }

    public static void main(String[] args) {
        String[] names = {
                "Achille Claude Debussy", "Charles-Camille Saint-Saëns",
                "Fryderyk Franciszek Chopin", "Louis-Hector Berlioz",
                "Joseph Maurice Ravel", "Eric Alfred Leslie Satie",
                null, "Gabriel Urbain Fauré"
        };

        double averageLengthOfNames = getAverageLength(names);

        System.out.printf("The average length of the elements of this list is %.2f.\n", averageLengthOfNames);
    }
}
