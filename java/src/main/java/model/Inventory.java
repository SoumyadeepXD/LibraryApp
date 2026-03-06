package model;

public class Inventory {
    private String bookId;
    private int totalCopies;
    private int issuedCopies;

    public Inventory(String bookId, int totalCopies) {
        this.bookId = bookId;
        this.totalCopies = totalCopies;
        this.issuedCopies = 0;
    }

    public boolean isAvailable() {
        return issuedCopies < totalCopies;
    }

    public void issueBook() {
        if (isAvailable()) issuedCopies++;
    }

    public void returnBook() {
        if (issuedCopies > 0) issuedCopies--;
    }

    public String getStatus() {
        return "Available: " + (totalCopies - issuedCopies) + "/" + totalCopies;
    }

    public String getBookId() { return bookId; }
}// Auto-generated file: Inventory.java