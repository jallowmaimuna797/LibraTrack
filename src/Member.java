public class Member {
    private String name;
    private int borrowLimit;

    // Initialize member details
    public Member(String name, int borrowLimit) {
        this.name = name;
        this.borrowLimit = borrowLimit;
    }

    // Getters and setters for member details
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
}
