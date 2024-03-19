public class DekuScrub extends Enemy {
    private static final int DEKU_NUT_INDEX = 0;

    private boolean isHidden;

    public DekuScrub(boolean isHidden) {
        super("Deku Scrub", 100, "Deku Seeds", 20);
        this.isHidden = isHidden;
    }

    public void hide() {
        // The super reference can also be used to reference other variables and methods defined in the parent class
        System.out.printf("%s is %s!\n", super.getName(), isHidden ? "coming out" : "hiding");
        isHidden = !isHidden;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    @Override
    public String dropItem() {
        // Drop a deku nut
        return Enemy.ITEMS[DEKU_NUT_INDEX];
    }
}

