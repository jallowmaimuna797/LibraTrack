import java.util.ArrayList;
import java.util.List;

    public class Library {

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

        public Book findBookByTitle(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }
    }

