package books;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
  private final List<Book> books = new ArrayList<>();

  public int add(Book book) {
    books.add(book);
    return 0;
  }

  public List<Book> getAll() {
    return new ArrayList<>(books);
  }

  public Book get(int id) {
    return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
  }
}
