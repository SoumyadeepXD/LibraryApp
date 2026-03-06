package model;

import java.time.LocalDate;

public class Transaction {
    public String bookId;
    public String memberId;
    public LocalDate issueDate;
    public LocalDate returnDate;

    public Transaction(String bookId, String memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = LocalDate.now();
        this.returnDate = null;
    }

    public void close() {
        this.returnDate = LocalDate.now();
    }
}// Auto-generated file: Transaction.java