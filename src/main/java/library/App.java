package library;

import java.time.LocalDate;
import java.util.List;

import org.json.JSONObject;

public class App {
    public void main(String[] args) {

        User user1 = new User("1234", "Pitter");
        User user2 = new User("2345", "Parker");

        Librarian librarian1 = new Librarian("4567", "Luis");

        Book spiderman1 = new Book("Spiderman 1999", "Marvel", "Sci-fi");
        Book spiderman2 = new Book("Spiderman 2001", "Marvel", "Sci-fi");
        Book spiderman3 = new Book("The Amazing Spiderman", "Marvel", "Sci-fi");

        Library lib = new Library();

        lib.addUser(user1);
        lib.addUser(user2);
        lib.addUser(librarian1);

        librarian1.addBook(lib, spiderman1);
        librarian1.addBook(lib, spiderman2);
        librarian1.addBook(lib, spiderman3);

        user1.borrowBook(spiderman2);
        lib.displayBooksList();

        System.out.println(user1.printBooks());

        lib.notifyDueDate(user1);
    }
}
