package polymorphism.sortingAndSearching;

import java.util.concurrent.atomic.AtomicInteger;

public class Pikachu {
    private final String nickname;
    private final AtomicInteger level;
    private final String type;

//    public static void main(String[] args) {
//        // Create two Pikachu objects
//        Pikachu puka = new Pikachu("Puka", 5, "Electric");
//        Pikachu sparky = new Pikachu("Sparky", 5, "Electric");
//
//        // Level them both up a completely random, probably different number of levels
//        for (int i = 0; i < (int) (Math.random() * 100); i++) { puka.levelUp();   }
//        for (int j = 0; j < (int) (Math.random() * 100); j++) { sparky.levelUp(); }
//
//        // Print the name and level of the winner
//        System.out.printf(
//                "The Pikachu with a higher level is: %s, with a level of %d!\n",
//                puka == sparky ?          "Both" : (puka.compareTo(sparky) > 0 ? puka.getNickname() : sparky.getNickname()),
//                puka == sparky ? puka.getLevel() : (puka.compareTo(sparky) > 0 ? puka.getLevel()    : sparky.getLevel())
//        );
//    }

    // TODO - 1. Ensure that Pikachu objects are sortable and searchable in Pikachu arrays
    // TODO - 2. Implement way for Pikachu class to check for equality between Pikachu objects based on levels
    // TODO - 3. Implement way for Pikachu class to check for inequality (>, <, etc.) between Pikachu objects based on levels
    // TODO - 4. Uncomment main() method after finishing steps 1 through 3 and test

    public Pikachu(String nickname, int level, String type) {
        this.nickname = nickname;
        this.level = new AtomicInteger(level);
        this.type = type;
    }

    public void levelUp() {
        level.incrementAndGet();
    }

    public String getNickname() {
        return nickname;
    }

    public int getLevel() {
        return level.get();
    }

    public String getType() {
        return type;
    }
}
