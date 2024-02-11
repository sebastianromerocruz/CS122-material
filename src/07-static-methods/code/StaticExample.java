class StaticExample {
    static void printMultiplicationTable(int numberOfRows, int numberOfColumns) {
        for (int row = 1; row < numberOfRows; row++) {
            for (int column = 1; column < numberOfColumns; column++) {
                System.out.print((row * column) + "\t");
            }

            System.out.println();
        }
    }


    static void greetPerson(String name) {
        System.out.println("Hello, " + name + "!");
    }

    static void greet() {
        System.out.println("Hello!");
    }

    static void printOneToTenEvens() {
        final int LIMIT = 10;

        for (int number = 1; number <= LIMIT; number++) {
            if (number % 2 == 0) System.out.println(number);
        }
    }

    public static void main(String[] args) {
        greet();
        printOneToTenEvens();

        String userName = "Sebastián";
        greetPerson(userName);

        printMultiplicationTable(10, 5);
    }
}