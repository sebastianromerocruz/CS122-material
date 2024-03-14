public class Enemy {
    private String name;
    private int healthPoints;
    private String weaponName;
    private int attackPower;

    public static void main(String[] args) {
        Enemy enemy = new Enemy("Deku Scrub", 100, "Deku Seeds", 20);

        System.out.printf("%s is attacking with %.2f power!", enemy.getName(), enemy.attack());
    }

    protected Enemy(String name, int healthPoints, String weaponName, int attackPower) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.weaponName = weaponName;
        this.attackPower = attackPower;
    }

    public float attack() {
        return (float) attackPower / healthPoints;
    }

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
