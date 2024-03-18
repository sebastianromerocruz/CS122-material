public class Game {
    //**
    // A simple demonstration of how our Lizalfos' power differs depending on their respective number of lives
    // */
    public static void main(String[] args) {
        Lizalfos lizalfosOne = new Lizalfos(1);
        Lizalfos lizalfosTwo = new Lizalfos(5);
        Lizalfos lizalfosThree = new Lizalfos(10);

        System.out.printf("%s\n", lizalfosOne.toString());

        System.out.printf(
                "These %s will have attack powers of  %.2f, %.2f, and %.2f, respectively.\n",
                lizalfosOne.getName(),
                lizalfosOne.attack(), lizalfosTwo.attack(), lizalfosThree.attack()
        );

        DekuScrub dekuScrub = new DekuScrub(false);

        System.out.printf("%s dropped a %s!\n", lizalfosOne.getName(), lizalfosOne.dropItem());
        System.out.printf("%s dropped a %s!\n", dekuScrub.getName(), dekuScrub.dropItem());
    }
}
