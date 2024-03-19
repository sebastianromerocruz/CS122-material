public class Lizalfos extends Enemy {
    private int numberOfLives;


    public Lizalfos(int numberOfLives) {
        super("Lizalfos", 100, "Sword", 50);
        this.numberOfLives = numberOfLives;
    }

    @Override
    public float attack() {
        return (float) (((float) super.getAttackPower() / (float) super.getHealthPoints()) * (1.0 + 1.0 / (float) getNumberOfLives()));
    }

    @Override
    public String dropItem() {
        // Let's return a random item from the 3 possibilities
        int max = Enemy.ITEMS.length - 1;
        int min = 0;

        // See method 1: https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
        int randomIndex = (int) Math.floor(Math.random() * (max - min + 1) + min);

        return Enemy.ITEMS[randomIndex];
    }

    @Override
    public String toString() {
        return new StringBuilder(getName() + " object with " + getNumberOfLives() + " number of lives.").toString();
    }

    public float basicAttack() {
        return super.attack();
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }
}
