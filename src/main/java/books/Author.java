package books;

import java.time.LocalDate;

/**
 * Represents an author in the library system.
 */
public class Author {
  private final int id;
  private final String firstName;
  private final String lastName;
  private final LocalDate dateOfBirth;
  private static int count = 0;

  public Author(String firstName, String lastName, LocalDate dateOfBirth) {
    this.id = ++count;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
  }

  // Getters
  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }
}
