package library;

public class Book {
    String title;
    String author;
    String genre;
    Boolean isAvailable = true;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public void borrowBook(Book book) {
        this.isAvailable = false;
    }

    public void returnBook(Book book) {
        this.isAvailable = true;
    }

}
