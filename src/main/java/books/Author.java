package books;

import java.time.LocalDate;

/**
 * Represents an author in the library system.
 */
public record Author(String name, LocalDate birthDate) {

  /**
   * Constructor for the Author class.
   *
   * @param name      The name of the author.
   * @param birthDate The birthdate of the author.
   */
  public Author {
    // TODO document why this constructor is empty
  }

  /**
   * Gets the author's name.
   *
   * @return The author's name.
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * Gets the author's birthdate.
   *
   * @return The author's birthdate.
   */
  @Override
  public LocalDate birthDate() {
    return birthDate;
  }
}
