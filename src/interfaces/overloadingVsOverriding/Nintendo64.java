package interfaces.overloadingVsOverriding;

public class Nintendo64 {
    // Static attributes
    public static final int DEFAULT_NUMBER_OF_PLAYERS = 1;
    public static final String NO_CARTRIDGE = null;

    // Static methods
    public static void main(String[] args) {
        Nintendo64 myNintendo64 = new Nintendo64("Super Smash Bros.", 3);
        Nintendo64 yourNintendo64 = new Nintendo64("The Legend of Zelda: Ocarina of Time");
        Nintendo64 theirNintendo64 = new Nintendo64();

        System.out.println("My N64 is running " + myNintendo64.getCurrentCartridge() + " with " +
                myNintendo64.getNumberOfControllers() + " player(s).");

        System.out.println("Your N64 is running " + yourNintendo64.getCurrentCartridge() + " with " +
                yourNintendo64.getNumberOfControllers() + " player(s).");

        System.out.println("Their N64 is running " + theirNintendo64.getCurrentCartridge() + " with " +
                theirNintendo64.getNumberOfControllers() + " player(s).");
    }

    // Attributes
    private final String currentCartridge;
    private final int numberOfControllers;

    // Public methods; note the overloaded constructors
    public Nintendo64(String currentCartridge, int numberOfControllers) {
        this.currentCartridge = currentCartridge;
        this.numberOfControllers = numberOfControllers;
    }

    public Nintendo64(String currentCartridge) {
        this(currentCartridge, DEFAULT_NUMBER_OF_PLAYERS);
    }

    public Nintendo64() {
        this(NO_CARTRIDGE, DEFAULT_NUMBER_OF_PLAYERS);
    }

    public String getCurrentCartridge() {
        return currentCartridge;
    }

    public int getNumberOfControllers() {
        return numberOfControllers;
    }
}
