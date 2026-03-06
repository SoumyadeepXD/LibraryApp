package model;

import java.util.*;

public class IssueManager {

    private Map<String, Inventory> inventoryMap = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addInventory(String bookId, int count) {
        inventoryMap.put(bookId, new Inventory(bookId, count));
    }

    public String issueBook(String bookId, String memberId) {
        Inventory inv = inventoryMap.get(bookId);
        if (inv == null) return "No inventory found.";
        if (!inv.isAvailable()) return "Book not available.";

        inv.issueBook();
        Transaction t = new Transaction(bookId, memberId);
        transactions.add(t);

        LibraryLogger.log("Issued: Book " + bookId + " to Member " + memberId);
        return "Book Issued Successfully!";
    }

    public String returnBook(String bookId, String memberId) {
        for (Transaction t : transactions) {
            if (t.bookId.equals(bookId) && t.memberId.equals(memberId) && t.returnDate == null) {
                t.close();
                double fine = FineCalculator.calculateFine(t);
                Inventory inv = inventoryMap.get(bookId);
                if (inv != null) inv.returnBook();

                LibraryLogger.log("Returned: Book " + bookId + " by Member " + memberId + " Fine=" + fine);
                return String.format("Returned Successfully! Fine: ₹%.2f", fine);
            }
        }
        return "Transaction not found!";
    }

    public String getInventoryStatus(String bookId) {
        Inventory inv = inventoryMap.get(bookId);
        return inv == null ? "Not Found" : inv.getStatus();
    }
}// Auto-generated file: IssueManager.java