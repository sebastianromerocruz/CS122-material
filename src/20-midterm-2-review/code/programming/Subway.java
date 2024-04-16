public class Subway extends Train implements Comparable<Subway> {
    public static final int MAX_OCCUPANCY = 100;
    public static final String MANUFACTURER = "New York City Subway Rolling Stock";

    public static void main(String[] args) {
        Subway[] subwayTrains = {
            new Subway('C'),
            new Subway('R')
        };

        System.out.println();
        for (Subway train : subwayTrains) {
            for (int i = 0; i < 5; i++) {
                int riders = (int) (Math.random() * 30);

                train.boardRiders(riders);
            }

            train.travel("Lafayette Avenue", "Jay Street-MetroTech");
            System.out.println();
        }

        if (subwayTrains[0].compareTo(subwayTrains[1]) == 0) {
            System.out.printf(
                "The %c train the same amount of people as the %c train right now.\n", 
                subwayTrains[0].getLine(), 
                subwayTrains[1].getLine()
                );
        } else if (subwayTrains[0].compareTo(subwayTrains[1]) > 0) {
            System.out.printf(
                "The %c train has more people than the %c train right now.\n", 
                subwayTrains[0].getLine(), 
                subwayTrains[1].getLine()
                );
        } else {
            System.out.printf(
                "The %c train has less people than the %c train right now.\n", 
                subwayTrains[0].getLine(), 
                subwayTrains[1].getLine()
                );
        }
    }

    private char line;
    private int currentOccupancy;

    public Subway(char line) {
        super(MANUFACTURER);
        this.line = line;
        this.currentOccupancy = 0;
    }

    public char getLine() {
        return line;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public void boardRiders(int riderAmount) {
        currentOccupancy += riderAmount;
        System.out.printf("%d people/person tried to get on the %c train...\n", riderAmount, getLine());

        if (getCurrentOccupancy() >= MAX_OCCUPANCY) {
            System.out.printf("...but the %c train is full!\n", getLine());
            currentOccupancy = MAX_OCCUPANCY;
        }
    }

    @Override
    public void travel(String origin, String destination) {
        System.out.printf(
            "This stop is %s...",
            origin
            );
        System.out.printf(
            "This is a *REALLY LOUD STATIC*–bound %c train. The next stop is *EVEN LOUDER STATIC* (%s).\n",
            getLine(), 
            destination
            );
    }

    @Override
    public int compareTo(Subway o) {
        if (getCurrentOccupancy() == o.getCurrentOccupancy()) return 0;

        return getCurrentOccupancy() > o.getCurrentOccupancy() ? 1 : -1;
    }
}
