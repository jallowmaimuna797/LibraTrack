public class Member {
    private String name;
    private int borrowLimit;
    private int borrowedBooks;

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

    @Override
    public String toString() {
        return "Member: " + name +
                ", Borrow Limit: " + borrowLimit +
                ", Borrowed Books: " + borrowedBooks;
    }
}