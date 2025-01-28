package books;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Controller for managing book-related operations.
 */
public class BookController {
  private final BookRepository bookRepository = new BookRepository();
  private final AuthorRepository authorRepository = new AuthorRepository();
  private final Scanner scanner = new Scanner(System.in);

  public void handleAddBook() {
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

    // Select an author
    if (authorRepository.getAll().isEmpty()) {
      System.out.println("No authors found! Please add an author first.");
      return;
    }

    System.out.println("Select an author by ID:");
    for (Author author : authorRepository.getAll()) {
      System.out.println(author.getId() + ". " + author.getFirstName() + " " + author.getLastName());
    }

    int authorId = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    Author author = authorRepository.get(authorId);

    if (author == null) {
      System.out.println("Invalid author ID.");
      return;
    }

    Book book = new Book(title, author, isbn, publisher, publicationDate, pages);
    bookRepository.add(book);
    System.out.println("Book added successfully.");
  }

  public void showAllBooks() {
    if (bookRepository.getAll().isEmpty()) {
      System.out.println("No books found.");
      return;
    }
    for (Book book : bookRepository.getAll()) {
      System.out.println(book.getId() + ". " + book.getTitle() + " by " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
    }
  }
}
