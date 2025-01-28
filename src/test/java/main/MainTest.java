package main;

import static org.junit.jupiter.api.Assertions.*;

import books.BookRepository;
import java.time.LocalDate;
import books.Author;
import books.Book;
import org.junit.jupiter.api.Test;

class MainTest {
  @Test
  void testCanSuccesfullyAddBook() {
    Book book = new Book("test", "test", "isbn", "jake", LocalDate.of(2025, 1,21), 200, new Author("test","tesst", LocalDate.of(1988,2,12)));
    BookRepository bookRepository = new BookRepository();
    int id = bookRepository.add(book);

    assertNotNull(bookRepository.get((int) id));
  }
}