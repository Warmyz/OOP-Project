package oop;

public class Book extends LibraryItem {
    private String author;
    private String genre;

    public Book(String name, String author, String genre) {
        super(name);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

}
