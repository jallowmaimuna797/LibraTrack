import java.time.LocalDateTime;

public class Transaction {
    private String bookTitle;
    private String transactionType;
    private LocalDateTime date;

    public Transaction(String bookTitle, String transactionType) {
        this.bookTitle = bookTitle;
        this.transactionType = transactionType;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "bookTitle='" + bookTitle + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", date=" + date +
                '}';
    }
}
