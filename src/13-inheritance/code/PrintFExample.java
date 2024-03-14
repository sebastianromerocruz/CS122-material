public class PrintFExample {
    public static void main(String[] args) {
        String name = "Euphyllia";
        int age = 30;
        System.out.printf("Hello, %s! You are %d years old.%n", name, age);

        int number = 42;
        System.out.printf("Number: %04d%n", number);

        double pi_approximation = Math.PI;
        System.out.printf("Pi approximated to 3 significant figures is: %.3f%n", pi_approximation);
    }
}
