package library;

import org.json.JSONObject;

public class Librarian extends User {
    String id;
    String name;

    public Librarian(String id, String name) {
        super(id, name);
    }

    public void addBook(Library library, Book book) {

        library.addBook(book);
        book.isAvailable = true;

    }

    public void removeBook(Library library, Book book) {

        library.removeBook(book);
        book.isAvailable = false;

    }
}
