package model;

public class Book extends LibraryItem {
    protected String author;
    protected String genre;

    public Book(String id, String title, String author, String genre) {
        super(id, title);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getDetails() {
        return "Title: " + title +
                "\nAuthor: " + author +
                "\nGenre: " + genre +
                "\nBarcode: " + id;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}