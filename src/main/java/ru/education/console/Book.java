package ru.education.console;

public class Book {
    final private String bookName;
    private boolean available = true;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setAvailable(boolean taken) {
        this.available = taken;
    }

    public boolean isAvailable() {
        return available;
    }
}