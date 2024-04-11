package exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestData {
    public static final int MAX = 10;
    public static final String FILE_NAME = "test.txt";

    public static void main(String[] args) {
        int value;

        try {
            // Our output stream is no long System.out, but a PrintWriter object
            PrintWriter outFile = new PrintWriter(FILE_NAME);

            Random random = new Random();

            for (int lineNumber = 1; lineNumber <= MAX; lineNumber++) {
                for (int number = 1; number <= MAX; number++) {
                    value = random.nextInt(90) + MAX;
                    outFile.printf("%d\t", value); // The same methods—print(), printf(), println()—are available to us
                }

                outFile.print('\n');
            }

            outFile.close();
            System.out.printf("Output file has been created: %s!\n", FILE_NAME);
        } catch (IOException ioe) {
            System.out.println("ERROR: Something went wrong.");
        }
    }
}