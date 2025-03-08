package oop;

import java.util.ArrayList;  // เพิ่มการนำเข้า ArrayList

public class Test {
    public static void main(String[] args) {
        // สร้างรายการหนังสือ, บอร์ดเกม, และอุปกรณ์
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic"));
        books.add(new Book("1984", "George Orwell", "Dystopian"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction"));

        ArrayList<Boardgame> boardgames = new ArrayList<>();
        boardgames.add(new Boardgame("Catan", "Strategy", 3, "90 min"));
        boardgames.add(new Boardgame("Chess", "Abstract", 2, "30 min"));
        boardgames.add(new Boardgame("Monopoly", "Economic", 4, "120 min"));

        ArrayList<Gadget> gadgets = new ArrayList<>();
        gadgets.add(new Gadget("Kindle", "Amazon", "E-Reader"));
        gadgets.add(new Gadget("iPad", "Apple", "Tablet"));
        gadgets.add(new Gadget("Smart Watch", "Samsung", "Wearable"));

        // เรียกใช้ LoginUI พร้อมกับส่ง object ที่สร้างไว้
        new LoginUI(books, boardgames, gadgets).setVisible(true);
    }
}
