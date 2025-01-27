package books;

import static main.Main.bookRepository;
import static main.Main.showBookForm;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

  private final List<Book> books = new ArrayList<>();

  public long add(Book book) {
    books.add(book);
    return book.id();
  }

  /**
   * Handles adding a book to the repository.
   */
  public static void handleAddBook() {
    Book newBook = showBookForm(); // Collect book details from the user
    long bookId = bookRepository.add(newBook); // Add the book to the repository
    System.out.println("Book added successfully with ID: " + bookId);
  }

  public Book get(long id) {
    return books.stream().filter(book -> book.id() == id).findFirst().orElse(null);
  }

  public List<Book> getAll() {
    return new ArrayList<>(books);
  }

  /**
   * Removes a book from the repository by its ID.
   * @param id The ID of the book to remove.
   */
  public void remove(long id) {
    Book bookToRemove = get(id);
    if (bookToRemove != null) {
      books.remove(bookToRemove);
    }
  }

  /**
   * Checks if the repository contains no books.
   * @return true if the repository is empty, false otherwise.
   */
  public boolean isEmpty() {
    return books.isEmpty();
  }

  /**
   * Gets the number of books in the repository.
   * @return the size of the repository.
   */
  public int size() {
    return books.size();
  }
}
