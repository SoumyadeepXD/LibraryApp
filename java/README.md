# Library Management System - JavaFX

A complete library management system built with **JavaFX** that allows users to manage books, members, issue/return transactions, and view logs.

## Features

✅ **Book Management**
- Search books by barcode
- View book details (title, author, genre, pages/file size)
- Check inventory status

✅ **Member Management**
- Search members by ID
- View member details (name, type, course/priority level)
- Support for Student and Premium members

✅ **Issue & Return**
- Issue books to members
- Return books with automatic fine calculation
- 14-day borrowing limit
- ₹2 per day fine after limit

✅ **Transaction Logs**
- View all transactions (issue/return events)
- Reload and clear logs

## Project Structure

```
src/main/java/
├── model/
│   ├── Book.java (base class for all books)
│   ├── PrintedBook.java
│   ├── EBook.java
│   ├── LibraryItem.java (abstract base)
│   ├── LibraryMemberBase.java (abstract base)
│   ├── StudentMember.java
│   ├── PremiumMember.java
│   ├── CentralLibrary.java (data loader)
│   ├── Inventory.java (stock management)
│   ├── IssueManager.java (transactions)
│   ├── Transaction.java (issue/return record)
│   ├── FineCalculator.java (late fees)
│   └── LibraryLogger.java (logging)
├── ui/
│   ├── LibraryApp.java (entry point)
│   ├── DashboardController.java (main controller)
│   ├── BooksViewController.java
│   ├── MembersViewController.java
│   ├── IssueReturnViewController.java
│   └── LogsViewController.java

src/main/resources/
├── ui/
│   ├── dashboard.fxml (main layout)
│   ├── books.fxml
│   ├── members.fxml
│   ├── issue_return.fxml
│   ├── logs.fxml
│   └── style.css
└── resources/
    ├── books.txt (book data)
    ├── members.txt (member data)
    └── logs.txt (transaction log)
```

## Sample Data

**Books** (`src/main/resources/books.txt`):
```
101,The Alchemist,Paulo Coelho,Fiction,Printed,208
102,Atomic Habits,James Clear,Self-help,EBook,5.8
```

**Members** (`src/main/resources/members.txt`):
```
M001,Soumyadeep,Student,CSE
M002,Rohan,Premium,2
```

## Running the Application

### Prerequisites
- Java 21+
- Maven 3.8+

### Build
```bash
cd java/
./mvnw clean package -DskipTests
```

### Run
```bash
./mvnw javafx:run
```

Or directly:
```bash
./mvnw exec:java@gui -DskipTests
```

## How to Use

1. **Search Books**: Go to "Books" tab → enter barcode (101 or 102) → click Search
2. **Search Members**: Go to "Members" tab → enter member ID (M001 or M002) → click Search
3. **Issue Book**: Go to "Issue / Return" → enter book barcode & member ID → click Issue
4. **Return Book**: Same tab → fill return fields → click Return (fine auto-calculated)
5. **View Logs**: Go to "Logs" → click "Reload Logs" to see all transactions

## Key Classes

### `Book.java` 
- Base class for all book types
- Methods: `getAuthor()`, `getGenre()`, `getDetails()`

### `CentralLibrary.java`
- Loads books and members from text files
- Methods: `findBook(barcode)`, `findMember(id)`

### `IssueManager.java`
- Manages book issues and returns
- Tracks transactions and calculates fines
- Methods: `issueBook()`, `returnBook()`, `getInventoryStatus()`

### `FineCalculator.java`
- Static fine calculation (14-day limit, ₹2/day after)
- Method: `calculateFine(Transaction)`

## UI Components

### Dashboard
- Sidebar with navigation buttons
- Content area for dynamic view loading
- Modern dark theme with gradient background

### Controllers
- Auto-wire FXML elements with `@FXML` annotations
- Load business logic from model classes
- Display results in TextArea components

## Error Handling

✅ Null checks on inventory lookups
✅ Try-with-resources for file I/O
✅ Input validation (empty fields, malformed data)
✅ NumberFormatException handling in data loading
✅ NIO file operations with charset handling

## Testing

Add test data and verify:
```bash
# Issue a book
- Book: 101
- Member: M001

# Return the book
- Book: 101
- Member: M001
# Fine should show (depends on return date)

# Check logs
# Should display: "Issued: Book 101 to Member M001"
#                 "Returned: Book 101 by Member M001 Fine=X.XX"
```

## Notes

- Books must have matching barcodes in `books.txt` and inventory setup in `MainController`
- Members must exist in `members.txt` to search
- Logs are appended to `src/main/resources/logs.txt`
- Fine calculation uses system date (14-day grace period)

---

**Version**: 1.0  
**Author**: Soumyadeep  
**Date**: March 2026
