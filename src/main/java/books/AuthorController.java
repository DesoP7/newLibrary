package books;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Controller for managing authors.
 */
public class AuthorController {
  private final AuthorRepository authorRepository;
  private final Scanner scanner = new Scanner(System.in);

  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public void handleAddAuthor() {
    System.out.print("Enter first name: ");
    String firstName = scanner.nextLine();
    System.out.print("Enter last name: ");
    String lastName = scanner.nextLine();
    System.out.print("Enter date of birth (YYYY-MM-DD): ");
    LocalDate dob = LocalDate.parse(scanner.nextLine());

    Author author = new Author(firstName, lastName, dob);
    authorRepository.add(author);
    System.out.println("Author added successfully.");
  }

  public void showAllAuthors() {
    if (authorRepository.getAll().isEmpty()) {
      System.out.println("No authors found.");
      return;
    }
    for (Author author : authorRepository.getAll()) {
      System.out.println(author.getId() + ". " + author.getFirstName() + " " + author.getLastName() + " (Born: " + author.getDateOfBirth() + ")");
    }
  }

  /**
   * Working on date validation
   */
  public static LocalDate getValidDateOfBirth(Scanner scanner) {
    LocalDate number;
    while (true) {
      System.out.print("Enter a valid Date: ");
      if (scanner.hasNextInt()) {
        number = LocalDate.ofEpochDay(scanner.nextInt());
        break; // Valid date, exit the loop
      } else {
        System.out.println("Invalid date of birth. Please enter a valid date.");
        scanner.next(); // Clear the invalid input
      }
    }
    return number;
  }
}
