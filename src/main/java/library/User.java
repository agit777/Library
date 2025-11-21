package library;

import java.time.ZonedDateTime;
import java.time.LocalDate;
import org.json.JSONObject;

public class User {
    String id;
    String name;
    int numBooks;
    JSONObject books = new JSONObject(); // {Book's name: Date borrowed}

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void borrowBook(Book book) {

        if (!book.isAvailable) {
            throw new RuntimeException("The book " + book.title + " is not available for borrowing");
        }

        String key = book.title;
        LocalDate value = LocalDate.now();
        books.put(key, value);

        book.borrowBook(book);
    }

    public void returnBook(Book book) {

        String key = book.title;
        if (!books.has(key)) {
            throw new RuntimeException(this.name + " does not borrowed " + key + " thus he can not return it");
        }

        books.remove(key);
        book.returnBook(book);
    }

    public String printBooks() {
        return this.books.toString();
    }
}
