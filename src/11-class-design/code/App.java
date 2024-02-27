public class App {
    public static void main(String[] args) {
        Song elScorcho = new Song("El Scorcho", "Weezer");

        System.out.println(elScorcho.getArtist());
        System.out.println(elScorcho.getSongTitle());

        System.out.println("Before calling the play method: " + elScorcho.getPlayCount());
        elScorcho.play();
        System.out.println("After calling the play method: " + elScorcho.getPlayCount());
    }
}
