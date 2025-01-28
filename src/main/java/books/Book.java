package books;

import java.time.LocalDate;

/**
 * Represents a book in the library system.
 */
public class Book {
  private final int id;
  private final String title;
  private final Author author;
  private final String isbn;
  private final String publisher;
  private final LocalDate publicationDate;
  private final int pages;
  private static int count = 0;

  public Book(String title, Author author, String isbn, String publisher, LocalDate publicationDate, int pages) {
    this.id = ++count;
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.publisher = publisher;
    this.publicationDate = publicationDate;
    this.pages = pages;
  }

  // Getters
  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Author getAuthor() {
    return author;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getPublisher() {
    return publisher;
  }

  public LocalDate getPublicationDate() {
    return publicationDate;
  }

  public int getPages() {
    return pages;
  }
}
