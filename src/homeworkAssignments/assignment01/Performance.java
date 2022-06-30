package homeworkAssignments.assignment01;

public class Performance {
    public static void main(String[] args) {
        // Creating my objects
        Guitarist yui       = new Guitarist("Yui", "electric guitar", false, false, "Gibson");
        Guitarist azusa     = new Guitarist("Azusa", "electric guitar", false, true, "Fender");
        Bassist mio         = new Bassist("Mio", "bass guitar", true, 4, "Fender");
        KeyboardPlayer mugi = new KeyboardPlayer("Mugi", "keyboard", false, "organ");
        Drummer ritsu       = new Drummer("Ritsu", "drums", false, 1);

        // Calling each of their perform() methods
        mio.perform();
        yui.perform();
        azusa.perform();
        mugi.perform();
        ritsu.perform();

        // Checking a couple of equals()
        System.out.printf("\n%s and %s are%s equal.\n",
                yui.getName(), azusa.getName(),
                yui.equals(azusa) ? "" : " not");

        System.out.printf("%s and %s are%s equal.\n",
                mio.getName(), mio.getName(),
                mio.equals(mio) ? "" : " not");

        System.out.printf("%s and %s are%s equal.\n",
                mugi.getName(), ritsu.getName(),
                mugi.equals(ritsu) ? "" : " not");
    }
}