package main;

import static books.BookRepository.handleAddBook;

import books.Author;
import books.Book;
import books.BookRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main class to run the library system.
 */
public class Main {
  private static final List<Author> authors = new ArrayList<>();
  public static final BookRepository bookRepository = new BookRepository();
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    initializeAuthors();
    showMainMenu();
  }

  /**
   * Initializes the list of authors.
   */
  private static void initializeAuthors() {
    authors.add(new Author("J.K. Rowling", LocalDate.of(1965, 7, 31)));
    authors.add(new Author("Stephen King", LocalDate.of(1947, 9, 21)));
    authors.add(new Author("Dan Brown", LocalDate.of(1964, 6, 22)));
  }

  /**
   * Displays the main menu and handles user input.
   */
  private static void showMainMenu() {
    while (true) {
      System.out.println("\nLibrary System Menu:");
      System.out.println("1. Add a Book");
      System.out.println("2. Show All Books");
      System.out.println("3. Remove a Book");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1 -> handleAddBook();
        case 2 -> showAllBooks();
        case 3 -> handleRemoveBook();
        case 4 -> {
          System.out.println("Exiting the system. Goodbye!");
          return;
        }
        default -> System.out.println("Invalid choice, please try again.");
      }
    }
  }

  /**
   * Displays the author selection menu.
   * @return The selected Author object.
   */
  private static Author showAuthorsMenu() {
    System.out.println("\nSelect an author:");
    for (int i = 0; i < authors.size(); i++) {
      System.out.println((i + 1) + ". " + authors.get(i));
    }

    int choice;
    do {
      System.out.print("Enter the author number: ");
      choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline
    } while (choice < 1 || choice > authors.size());

    return authors.get(choice - 1);
  }

  /**
   * Collects book details from the user.
   * @return A new Book object.
   */
  public static Book showBookForm() {
    Author selectedAuthor = showAuthorsMenu();
    System.out.print("Enter book id: ");
    int id = Integer.parseInt(scanner.nextLine());
    System.out.print("Enter book title: ");
    String title = scanner.nextLine();
    System.out.print("Enter ISBN: ");
    String isbn = scanner.nextLine();
    System.out.print("Enter publisher: ");
    String publisher = scanner.nextLine();
    System.out.print("Enter publication date (YYYY-MM-DD): ");
    LocalDate publicationDate = LocalDate.parse(scanner.nextLine());
    System.out.print("Enter number of pages: ");
    int pages = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    return new Book(id, title, isbn, publisher, publicationDate, pages, selectedAuthor);
  }


  /**
   * Displays all books in the library.
   */
  private static void showAllBooks() {
    List<Book> books = bookRepository.getAll();
    if (books.isEmpty()) {
      System.out.println("No books available.");
      return;
    }

    System.out.println("\nBooks in Library:");
    for (Book book : books) {
      System.out.println(book);
    }
  }

  /**
   * Handles book removal process.
   */
  private static void handleRemoveBook() {

    if (bookRepository.isEmpty()) {
      System.out.println("No books available to remove.");
      return;
    }

    System.out.println("\nSelect a book to remove:");
    for (int i = 0; i < bookRepository.size(); i++) {
      System.out.println((i + 1) + ". " + bookRepository.get(i));
    }

    int choice;
    do {
      System.out.print("Enter book number to remove: ");
      choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline
    } while (choice < 1 || choice > bookRepository.size());

    removeBook(choice - 1);
    System.out.println("Book removed successfully!");
  }

  /**
   * Removes a book from the collection.
   * @param index The index of the book to remove.
   */
  private static void removeBook(int index) {
    bookRepository.remove(index);
  }
}

