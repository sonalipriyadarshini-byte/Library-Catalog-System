import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void displayBook() {
        System.out.println("Title: " + title + " | Author: " + author);
    }
}

// Library class
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Add book
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    // List all books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the catalog.");
            return;
        }

        System.out.println("\n--- Library Catalog ---");
        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with that title.");
        }
    }

    // Search by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found by that author.");
        }
    }
}

// Main class
public class LibraryCatalogSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== Library Catalog System =====");
            System.out.println("1. Add Book");
            System.out.println("2. List All Books");
            System.out.println("3. Search by Title");
            System.out.println("4. Search by Author");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();

                    library.addBook(title, author);
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}