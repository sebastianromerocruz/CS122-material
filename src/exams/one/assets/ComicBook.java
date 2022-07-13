package exams.one.assets;
import exams.one.ReadingMaterial;

public class ComicBook extends ReadingMaterial implements Comparable {
    private final String title;

    public static void main(String[] args) {
        ComicBook akira = new ComicBook(100, "Akira");
        ComicBook mieruko = new ComicBook(76, "Mieruko");

        ComicBook[] comics = new ComicBook[] { akira, mieruko };
    }

    public ComicBook(int pageNumber, String title) {
        super(pageNumber);
        this.title = title;
    }

    @Override
    public int compareTo(Object o) {
        return title.compareTo(((ComicBook) o).title);
    }

    @Override
    public boolean equals(ComicBook o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        return title.equals(o.title);
    }

    @Override
    public void read() {
        System.out.printf("Reading %s...", title);
    }
}
