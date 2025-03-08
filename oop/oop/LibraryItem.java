package oop;

public class LibraryItem {
    protected String name;
    protected boolean isBorrowed;

    public LibraryItem(String name) {
        this.name = name;
        this.isBorrowed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowItem() {
        isBorrowed = true;
    }

    public void returnItem() {
        isBorrowed = false;
    }

    public String getStatus() {
        return isBorrowed ? "(Borrowed)" : "(Available)";
    }
}
