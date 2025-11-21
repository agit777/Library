package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Library {

    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();
    static final int DAYS_DUE_DATE = 120;

    public Library() {

    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public void notifyDueDate(User user) {

        for (String key : user.books.keySet()) {

            LocalDate dateBookTakenInJson = (LocalDate) user.books.get(key);
            LocalDate dateBookTaken = LocalDate.of(dateBookTakenInJson.getYear(),
                    dateBookTakenInJson.getMonthValue(),
                    dateBookTakenInJson.getDayOfMonth());
            LocalDate today = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(),
                    LocalDate.now().getDayOfMonth());

            long days = ChronoUnit.DAYS.between(dateBookTaken, today);

            if (days >= DAYS_DUE_DATE) {
                System.out.println("Please note that the due date has passed for the book: " + "\"" + key + "\"");
            }
        }

    }

    public void displayBooksList() {
        int bookIndex = 0;
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).isAvailable) {
                bookIndex = i + 1;
                System.out.println(bookIndex + ". Book: \"" + books.get(i).title + "\"");
                System.out.println("   Author: " + books.get(i).author);
                System.out.println();
            }

        }
    }

    public static void main() {

    }
}