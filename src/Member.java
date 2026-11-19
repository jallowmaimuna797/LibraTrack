import java.util.LinkedList;
public class Member {
    private String name;
    private int borrowLimit;
    private int borrowedBooks;
    private LinkedList<Transaction> borrowingHistory = new LinkedList<>();

    public Member(String name, int borrowLimit) {
        this.name = name;
        this.borrowLimit = borrowLimit;
        this.borrowedBooks = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook() {
        if (borrowedBooks < borrowLimit) {
            borrowedBooks++;
        }
    }

    public void returnBook() {
        if (borrowedBooks > 0) {
            borrowedBooks--;
        }
    }

    public void addTransaction(Transaction transaction) {
        borrowingHistory.add(transaction);
    }

    public void displayBorrowingHistory() {
        System.out.println("\nBorrowing History for " + name + ":");

        for (Transaction transaction : borrowingHistory) {
            System.out.println(transaction);
        }
    }

    @Override
    public String toString() {
        return "Member: " + name +
                ", Borrow Limit: " + borrowLimit +
                ", Borrowed Books: " + borrowedBooks;
    }
}