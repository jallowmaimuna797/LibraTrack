import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Store the titles of the existing books
        String[] titles = {"Java Basics", "Database Systems", "Web Development", "Cybersecurity", "Networking"};
        String[] authors = {"Ebrima Touraye", "Ebrima Faal", "Muhammed Chaw", "Maimuna Jallow", "Ebou Badjie"};
        String[] isbn = {"1001", "1002", "1003", "1004", "1005"};
        String[] available = {"true", "true", "false", "true", "false"};

        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Display the current library catalog
        System.out.println("LibraTrack Library Catalog");
        System.out.println();

        // Loop through the arrays and display each book
        for (int i = 0; i < titles.length; i++) {
            System.out.println("Title: " + titles[i]);
            System.out.println("Author: " + authors[i]);
            System.out.println("ISBN: " + isbn[i]);
            System.out.println("Available: " + available[i]);
            System.out.println();
        }

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

        // Display the updated catalog
        System.out.println();
        System.out.println("Updated LibraTrack Library Catalog");
        System.out.println();

        // Loop through the updated arrays and display all books
        for (int i = 0; i < titles.length; i++) {
            System.out.println("Title: " + titles[i]);
            System.out.println("Author: " + authors[i]);
            System.out.println("ISBN: " + isbn[i]);
            System.out.println("Available: " + available[i]);
            System.out.println();
        }
        // LINEAR SEARCH FOR BOOK BY TITLE
        //  Asking the user to enter the title they want to search
        System.out.print("Enter the book title to search: ");
        String searchTitle = scanner.nextLine();

        //Create a variable to keep track of whether the book is found starting with false because we have not searched yet
        boolean found = false;

         // Linear search
        for (int i = 0; i < titles.length; i++) {

            // Compare the title in the array with the title entered by the user
            // equalsIgnoreCase() allows uppercase and lowercase differences
            if (titles[i].equalsIgnoreCase(searchTitle)) {

                // The book has been found, so change found from false to true
                found = true;

                // Display the information about the book that was found
                System.out.println();
                System.out.println("Book found!");
                System.out.println("Title: " + titles[i]);
                System.out.println("Author: " + authors[i]);
                System.out.println("ISBN: " + isbn[i]);
                System.out.println("Available: " + available[i]);

                // Stopping the loop because we already found the book
                break;}
            // Check if the book was not found
            }
        if (!found) {

            // Display a message to the user
            System.out.println();
            System.out.println("Book not found.");
        }
        scanner.close();


    }
}