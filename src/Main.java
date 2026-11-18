import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Create a Library object
        Library library = new Library();
        Member member = new Student("Library Member");

        Map<String, Runnable> menu = new HashMap<>();

        menu.put("1", () -> addBook(scanner, library));
        menu.put("2", () -> searchBook(scanner, library));
        menu.put("3", () -> library.displayCatalog());
        menu.put("4", () -> toggleCheckout(scanner, library, member));
        menu.put("5", () -> library.displayAvailableBooks());
        String choice;

        do {
            System.out.println("\nLibraTrack Menu");
            System.out.println("1. Add a book");
            System.out.println("2. Search for a book");
            System.out.println("3. Display catalog");
            System.out.println("4. Checkout/Return a book");
            System.out.println("5. Display available books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextLine();

            if (menu.containsKey(choice)) {
                menu.get(choice).run();
            } else if (!choice.equals("0")) {
                System.out.println("Invalid choice. Try again.");
            }

        } while (!choice.equals("0"));

        System.out.println("Thank you for using LibraTrack!");
        scanner.close();
    }

    // Generic search method using Predicate
    static int genericSearch(String[] items, Predicate<String> condition) {

        for (int i = 0; i < items.length; i++) {

            if (condition.test(items[i])) {
                return i;
            }
        }

        return -1;
    }

    // Method for adding a new book
// Method for adding a new book
    static void addBook(Scanner scanner, Library library) {
        System.out.println("Enter details for a new book:");

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, isbn, true);
        library.addBook(book);

        System.out.println("Book added successfully.");
    }

    // Method for searching for a book
    static void searchBook(Scanner scanner, Library library) {
        System.out.print("Enter the book title to search: ");
        String searchTitle = scanner.nextLine();

        Book book = library.findBookByTitle(searchTitle);

        if (book != null) {
            System.out.println("\nBook found!");
            System.out.println(book);
        } else {
            System.out.println("\nBook not found.");
        }
    }

    // Method for checking out or returning a book
    static void toggleCheckout(Scanner scanner, Library library, Member member) {
        System.out.print("Enter the book title to checkout or return: ");
        String title = scanner.nextLine();

        Book book = library.findBookByTitle(title);

        if (book != null) {
            if (book.isAvailable()) {
                if (member.getBorrowedBooks() < member.getBorrowLimit()) {
                    library.borrowBook(book);
                    member.borrowBook();
                    System.out.println("Book checked out successfully.");
                } else {
                    System.out.println("You have reached your borrowing limit.");
                }
            } else {
                library.returnBook(book);
                member.returnBook();
                System.out.println("Book returned successfully.");
            }

            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }
}

