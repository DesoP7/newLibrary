package main;

import books.AuthorRepository;
import books.BookController;
import books.AuthorController;

import java.util.Scanner;

/**
 * Main class to start the application.
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    AuthorRepository authorRepository = new AuthorRepository();
    BookController bookController = new BookController(authorRepository);
    AuthorController authorController = new AuthorController(authorRepository);

    while (true) {
      System.out.println("\n--- Library System Menu ---");
      System.out.println("1. Add Author");
      System.out.println("2. Add Book");
      System.out.println("3. View All Authors");
      System.out.println("4. View All Books");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          authorController.handleAddAuthor();
          break;
        case 2:
          bookController.handleAddBook();
          break;
        case 3:
          authorController.showAllAuthors();
          break;
        case 4:
          bookController.showAllBooks();
          break;
        case 5:
          System.out.println("Exiting program...");
          return;
        default:
          System.out.println("Invalid choice, please try again.");
      }
    }
  }
}
