import java.util.ArrayList;
import java.util.List;

    public class Library implements Searchable, Borrowable {

        private List<Book> books;

        public Library() {
            books = new ArrayList<>();
            books.add(new Book("Java Basics", "Ebrima Touraye", "1001", true));
            books.add(new Book("Database Systems", "Ebrima Faal", "1002", true));
            books.add(new Book("Web Development", "Muhammed Chaw", "1003", false));
            books.add(new Book("Cybersecurity", "Maimuna Jallow", "1004", true));
            books.add(new Book("Networking", "Ebou Badjie", "1005", false));
        }

        public List<Book> getBooks() {
            return books;
        }

        public void addBook(Book book) {
            books.add(book);
        }

        @Override
        public Book findBookByTitle(String title) {
            for (Book book : books) {
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

        }
        public void displayCatalog() {
            for (Book book : books) {
                System.out.println(book);
                System.out.println();
            }
        }

        public void displayAvailableBooks() {
            System.out.println("\nAvailable Books (Sorted by Title):");

            books.stream()
                    .filter(Book::isAvailable)
                    .sorted(java.util.Comparator.comparing(Book::getTitle))
                    .forEach(System.out::println);
        }
        
    }

