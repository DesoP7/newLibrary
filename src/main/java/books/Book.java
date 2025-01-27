package books;

import java.time.LocalDate;

/**
 * Represents a book in the library system.
 */
public record Book(int id, String title, String isbn, String publisher, LocalDate publicationDate,
                   int pages, Author author) {

  /**
   * Constructor for the Book class.
   *
   * @param title           The title of the book.
   * @param isbn            The ISBN of the book.
   * @param publisher       The publisher of the book.
   * @param publicationDate The publication date of the book.
   * @param pages           The number of pages in the book.
   * @param author          The author of the book.
   */
  public Book {

  }

  /**
   * Gets the book's ID.
   *
   * @return The book's unique ID.
   */
  @Override
  public int id() {
    return id;
  }

  /**
   * Gets the book's title.
   *
   * @return The book's title.
   */
  @Override
  public String title() {
    return title;
  }

  /**
   * Gets the book's isbn.
   *
   * @return The book's isbn.
   */
  @Override
  public String isbn() {
    return isbn;
  }

  /**
   * Gets the book's publisher.
   *
   * @return The book's publisher.
   */
  @Override
  public String publisher() {
    return publisher;
  }

  /**
   * Gets the book's publication date.
   *
   * @return The book's publication date.
   */
  @Override
  public LocalDate publicationDate() {
    return publicationDate;
  }

  /**
   * Gets the book's pages.
   *
   * @return The book's pages.
   */
  @Override
  public int pages() {
    return pages;
  }

  /**
   * Gets the book's author.
   *
   * @return The book's author.
   */
  @Override
  public Author author() {
    return author;
  }
}
