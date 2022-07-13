package exams.one;

import exams.one.assets.ComicBook;

public abstract class ReadingMaterial {
    protected final int pageNumber;

    protected ReadingMaterial(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public abstract boolean equals(ComicBook o);

    public abstract void read();
}
