public class Song {
    public static final int INITIAL_PLAY_COUNT = 0;

    private String songTitle;
    private String artist;
    private int playCount;

    public Song(String songTitle, String artist) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.playCount = INITIAL_PLAY_COUNT;
    }

    public void play() {
        playCount++;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlayCount() {
        return playCount;
    }
}