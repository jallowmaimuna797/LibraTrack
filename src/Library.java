import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class Library implements Searchable, Borrowable {

    private Map<String, Book> books;
    private Map<String, Queue<Member>> reservationWaitlists;

    //constructor
    public Library() {
        books = new HashMap<>();
        reservationWaitlists = new HashMap<>();

        books.put("1001", new Book("Java Basics", "Ebrima Touraye", "1001", true));
        books.put("1002", new Book("Database Systems", "Ebrima Faal", "1002", true));
        books.put("1003", new Book("Web Development", "Muhammed Chaw", "1003", false));
        books.put("1004", new Book("Cybersecurity", "Maimuna Jallow", "1004", true));
        books.put("1005", new Book("Networking", "Ebou Badjie", "1005", false));
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    @Override
    public Book findBookByTitle(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void borrowBook(Book book) {
        book.setAvailable(false);
    }

    @Override
    public void returnBook(Book book) {
        book.setAvailable(true);

        Member nextMember = getNextReservation(book.getIsbn());

        if (nextMember != null) {
            System.out.println("The returned book is now available for: "
                    + nextMember.getName());
        }
    }

    public void displayCatalog() {
        for (Book book : books.values()) {
            System.out.println(book);
            System.out.println();
        }
    }

    public void displayAvailableBooks() {
        System.out.println("\nAvailable Books (Sorted by Title):");

        books.values().stream()
                .filter(Book::isAvailable)
                .sorted(java.util.Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);
    }

    public void reserveBook(String isbn, Member member) {
        Book book = books.get(isbn);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isAvailable()) {
            System.out.println("This book is available. No reservation needed.");
        } else {
            Queue<Member> waitlist = reservationWaitlists.computeIfAbsent(
                    isbn, key -> new LinkedList<>());

            waitlist.offer(member);

            System.out.println(member.getName() + " added to the reservation waitlist.");
        }
    }

    public Member getNextReservation(String isbn) {
        Queue<Member> waitlist = reservationWaitlists.get(isbn);

        if (waitlist != null) {
            return waitlist.poll();
        }

        return null;
    }
}