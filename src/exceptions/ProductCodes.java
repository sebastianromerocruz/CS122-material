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
        int district, numberOfValidCodes = 0, numberOfBannedCodes = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter product code (%s to quit): ", TERMINATION_CODE);
        code = scanner.nextLine();

        while (!code.equals("XXX")) {
            try {
                zone = code.charAt(ZONE_INDEX);
                district = Integer.parseInt(code.substring(DISTRICT_LOW_IDX, DISTRICT_HIGH_IDX));

                numberOfValidCodes++;
                if (zone == INVALID_ZONE && district >= INVALID_DISTRICT) {
                    numberOfBannedCodes++;
                }
            } catch (StringIndexOutOfBoundsException exception) {
                System.out.printf("ERROR: Improper code length: %s", code);
            } catch (NumberFormatException exception) {
                System.out.printf("ERROR: District is not numeric: %s", code);
            }

            System.out.printf("Enter product code (%s to quit): ", TERMINATION_CODE);
            code = scanner.nextLine();
        }

        System.out.printf("Number of valid codes entered: %d.", numberOfValidCodes);
        System.out.printf("Number of banned codes entered: %d.", numberOfBannedCodes);
    }
}
