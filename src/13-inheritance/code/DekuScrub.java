public class DekuScrub extends Enemy {
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
}
