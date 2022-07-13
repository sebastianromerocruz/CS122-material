package exceptions;

import java.util.Scanner;

public class ProductCodes {
    public static final String TERMINATION_CODE = "XXX";
    public static final int ZONE_INDEX = 9;
    public static final int DISTRICT_LOW_IDX = 3;
    public static final int DISTRICT_HIGH_IDX = 7;
    public static final char INVALID_ZONE = 'R';
    public static final int INVALID_DISTRICT = 2000;

    public static void main(String[] args) {
        String code;
        char zone;
        int district;

        // We'll count the number of valid codes we encounter
        // As well as the number of banned codes
        int numberOfValidCodes = 0, numberOfBannedCodes = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter product code (%s to quit): ", TERMINATION_CODE);
        code = scanner.nextLine();

        // STEP 1: While the user doesn't enter the termination code
        while (!code.equals(TERMINATION_CODE)) {
            // Attempt the following things that COULD go wrong...
            try {
                // STEP 2: Extract the zone code (could be out of bounds)
                zone = code.charAt(ZONE_INDEX);

                // STEP 3: Extract the district code (could be a non-integer)
                district = Integer.parseInt(code.substring(DISTRICT_LOW_IDX, DISTRICT_HIGH_IDX));

                // STEP 4: If it passes both of those tests, it is a valid code
                numberOfValidCodes++;

                // STEP 5: But if happens to be in a district that is incompatible with the invalid zone, make sure to
                //         note that it is a banned code
                if (zone == INVALID_ZONE && district >= INVALID_DISTRICT) {
                    numberOfBannedCodes++;
                }
            } catch (StringIndexOutOfBoundsException exception) {
                // STEP 6: If step 2 went wrong, handle it here
                System.out.printf("ERROR: Improper code length: %s", code);
            } catch (NumberFormatException exception) {
                // STEP 7: If step 3 went wrong, handle it here
                System.out.printf("ERROR: District is not numeric: %s", code);
            }

            // STEP 8: Prompt the user to enter next code to start again
            System.out.printf("Enter product code (%s to quit): ", TERMINATION_CODE);
            code = scanner.nextLine();
        }

        // STEP 9: Print results
        System.out.printf("Number of valid codes entered: %d.", numberOfValidCodes);
        System.out.printf("Number of banned codes entered: %d.", numberOfBannedCodes);
    }
}
