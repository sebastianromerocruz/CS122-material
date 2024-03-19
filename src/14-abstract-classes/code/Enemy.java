public abstract class Enemy {
    private final String name;
    private final String weaponName;
    private final int attackPower;
    private int healthPoints;

    public static final String[] ITEMS = {
            "Deku Stick",
            "Heart",
            "Potion"
    };

    protected Enemy(String name, int healthPoints, String weaponName, int attackPower) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.weaponName = weaponName;
        this.attackPower = attackPower;
    }



    public float attack() {
        return (float) attackPower / healthPoints;
    }

    // Leave the implementation up to the child classes
    public abstract String dropItem();

    public int getAttackPower() {
        return this.attackPower;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String getName() {
        return name;
    }

    public String getWeaponName() {
        return weaponName;
    }
}
