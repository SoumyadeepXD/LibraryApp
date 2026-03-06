package model;

public class PrintedBook extends Book {
    private int pages;

    public PrintedBook(String id, String title, String author, String genre, int pages) {
        super(id, title, author, genre);
        this.pages = pages;
    }

    @Override
    public String getDetails() {
        return "[Printed Book]\n" +
                "Title: " + title +
                "\nAuthor: " + author +
                "\nGenre: " + genre +
                "\nPages: " + pages +
                "\nBarcode: " + id;
    }
}// Auto-generated file: PrintedBook.java