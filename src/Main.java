import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        // Store the titles of the existing books
        String[] titles = {"Java Basics", "Database Systems", "Web Development", "Cybersecurity", "Networking"};
        String[] authors = {"Ebrima Touraye", "Ebrima Faal", "Muhammed Chaw", "Maimuna Jallow", "Ebou Badjie"};
        String[] isbn = {"1001", "1002", "1003", "1004", "1005"};
        String[] available = {"true", "true", "false", "true", "false"};

        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Display the full catalog
        printCatalog(titles, authors, isbn, available);

        // Search for a book using generic search
        searchBook(scanner, titles, authors, isbn, available);

        // Display available books sorted by title
        displayAvailableBooks(titles, authors, isbn, available);
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

    // Method for displaying available books using Streams
    static void displayAvailableBooks(String[] titles, String[] authors, String[] isbn, String[] available) {

        System.out.println("\nAvailable Books (Sorted by Title):");

        IntStream.range(0, titles.length)
                .filter(i -> available[i].equals("true"))
                .boxed()
                .sorted(Comparator.comparing(i -> titles[i]))
                .forEach(i -> {
                    System.out.println("Title: " + titles[i]);
                    System.out.println("Author: " + authors[i]);
                    System.out.println("ISBN: " + isbn[i]);
                    System.out.println("Available: " + available[i]);
                    System.out.println();
                });
    }
    /**
     * Add a new book to the library catalog.
     * Prompts the user to enter the book's title, author, and ISBN.
     * Create larger arrays, copies the existing book details, and add.
     * The new book with its availability set to true.
     *
     * @param scanner  the Scanner object used to read user input
     * @param titles   the array containing the existing book titles
     * @param authors  the array containing the existing book authors
     * @param isbn     the array containing the existing book ISBNs
     * @param available the array containing the availability status of each book
     * @return a two-dimensional array containing the updated book catalog arrays
     */
// Method for adding a new book
static String[][] addBook(Scanner scanner, String[] titles, String[] authors, String[] isbn, String[] available) {
    // Ask the user to enter the details of a new book
    System.out.println("Enter details for a new book:");

    System.out.print("Enter title: ");
    String newTitle = scanner.nextLine();

    System.out.print("Enter author: ");
    String newAuthor = scanner.nextLine();

    System.out.print("Enter ISBN: ");
    String newBookIsbn = scanner.nextLine();

    // Create new arrays with one extra space for the new book
    String[] newTitles = new String[titles.length + 1];
    String[] newAuthors = new String[authors.length + 1];
    String[] newIsbn = new String[isbn.length + 1];
    String[] newAvailable = new String[available.length + 1];

    // Copy the existing books into the new arrays
    for (int i = 0; i < titles.length; i++) {
        newTitles[i] = titles[i];
        newAuthors[i] = authors[i];
        newIsbn[i] = isbn[i];
        newAvailable[i] = available[i];
    }

    // Add the new book at the end of the new arrays
    newTitles[titles.length] = newTitle;
    newAuthors[authors.length] = newAuthor;
    newIsbn[isbn.length] = newBookIsbn;

    // Make the new book available
    newAvailable[available.length] = "true";

    // Replace the old arrays with the new larger arrays
    titles = newTitles;
    authors = newAuthors;
    isbn = newIsbn;
    available = newAvailable;

    // Return the updated arrays
    return new String[][]{titles, authors, isbn, available};

}
    /**
     * Display all books currently stored in the library catalog.
     * Prints each book's title, author, ISBN, and availability status.
     *
     * @param titles the array containing the book titles
     * @param authors the array containing the book authors
     * @param isbn the array containing the book ISBNs
     * @param available the array containing the availability status of each book
     */
// Method for printing the full catalog
static void printCatalog(String[] titles, String[] authors, String[] isbn, String[] available) {

    // Display the current library catalog
    System.out.println("LibraTrack Library Catalog");
    System.out.println();

    // Loop through the arrays and display each book
    // TASK 4: Print the full catalog using a loop
        for (int i = 0; i < titles.length; i++) {
            System.out.println("Title: " + titles[i]);
            System.out.println("Author: " + authors[i]);
            System.out.println("ISBN: " + isbn[i]);
            System.out.println("Available: " + available[i]);
            System.out.println();
        }
    }

    /**
     *Searches for a book by title using linear search.
     * Compares the entered title with the titles in the catalog,
     * ignoring differences between uppercase and lowercase letters.
     * Displays the book's details if a match is found.
     *
     * @param scanner the Scanner object used to read the search title
     * @param titles the array containing the book titles
     * @param authors the array containing the book authors
     * @param isbn the array containing the book ISBNs
     * @param available the array containing the availability status of each book
     */
// Method for Linear search
static void searchBook(Scanner scanner, String[] titles, String[] authors, String[] isbn, String[] available) {

     // LINEAR SEARCH FOR BOOK BY TITLE
    //  Asking the user to enter the title they want to search
    System.out.print("Enter the book title to search: ");
    String searchTitle = scanner.nextLine();

    //Create a variable to keep track of whether the book is found starting with false because we have not searched yet
    boolean found = false;

    // Use generic search with a Predicate to find a book by title
    int index = genericSearch(titles,
            title -> title.equalsIgnoreCase(searchTitle));

    if (index != -1) {
        System.out.println();
        System.out.println("Book found!");
        System.out.println("Title: " + titles[index]);
        System.out.println("Author: " + authors[index]);
        System.out.println("ISBN: " + isbn[index]);
        System.out.println("Available: " + available[index]);

    } else {
        System.out.println();
        System.out.println("Book not found.");
    }
}
    /**
     * Checks out or returns a book in the library catalog.
     * Searches for a book by title and changes its availability status.
     * If the book is available, it is checked out; otherwise, it is returned.
     *
     * @param scanner the Scanner object used to read the book title
     * @param titles the array containing the book titles
     * @param available the array containing the availability status of each book
     */
// Method for checking out or returning a book
static void toggleCheckout(Scanner scanner, String[] titles, String[] available) {
    // TASK 5: Toggle checkout/return status
    // Ask the user for the book they want to check out or return
    System.out.print("Enter the book title to checkout or return: ");
    String statusTitle = scanner.nextLine();

    // Search through the books
    for (int i = 0; i < titles.length; i++) {

        // Check if the entered title matches a book
        if (titles[i].equalsIgnoreCase(statusTitle)) {

            // If the book is available, check it out
            if (available[i].equals("true")) {
                available[i] = "false";
                System.out.println("Book checked out successfully.");
            } else {

                // If the book is not available, return it
                available[i] = "true";
                System.out.println("Book returned successfully.");
            }

            // Display the new availability status
            System.out.println("Title: " + titles[i]);
            System.out.println("Available: " + available[i]);

            break;
        }

    }
}
}

