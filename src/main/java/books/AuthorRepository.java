package books;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
  private final List<Author> authors = new ArrayList<>();

  public void add(Author author) {
    authors.add(author);
  }

  public List<Author> getAll() {
    return new ArrayList<>(authors);
  }

  public Author get(int id) {
    return authors.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
  }
}
