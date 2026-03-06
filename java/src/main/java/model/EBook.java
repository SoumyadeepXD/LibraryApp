package model;

public class EBook extends Book {
    private double fileSizeMB;

    public EBook(String id, String title, String author, String genre, double fileSizeMB) {
        super(id, title, author, genre);
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public String getDetails() {
        return "[E-Book]\n" +
                "Title: " + title +
                "\nAuthor: " + author +
                "\nGenre: " + genre +
                "\nFile Size: " + fileSizeMB + "MB" +
                "\nBarcode: " + id;
    }
}// Auto-generated file: EBook.java