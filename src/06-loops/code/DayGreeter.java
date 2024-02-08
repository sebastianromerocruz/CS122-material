import java.util.Scanner;

class DayGreeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which day of the week is it? ");
        String day = scanner.nextLine();

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                System.out.println("It's " + day + ", a weekday!");
                break;
        
            case "Saturday":
            case "Sunday":
                System.out.println("It's " + day + ", a weekend!");
                break;
        
            default:
                System.out.println("ERROR: Invalid day.");
        }

        scanner.close();
    }
}
