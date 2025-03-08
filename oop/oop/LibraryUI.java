package oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LibraryUI extends JFrame {
    private ArrayList<Book> books;
    private ArrayList<Boardgame> boardgames;
    private ArrayList<Gadget> gadgets;

    public LibraryUI(ArrayList<Book> books, ArrayList<Boardgame> boardgames, ArrayList<Gadget> gadgets) {
        this.books = books;
        this.boardgames = boardgames;
        this.gadgets = gadgets;

        setTitle("Library Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JButton bookButton = new JButton("Book");
        bookButton.addActionListener(e -> new BookUI(books).setVisible(true));

        JButton boardgameButton = new JButton("Boardgame");
        boardgameButton.addActionListener(e -> new BoardgameUI(boardgames).setVisible(true));

        JButton gadgetButton = new JButton("Gadget");
        gadgetButton.addActionListener(e -> new GadgetUI(gadgets).setVisible(true));

        JButton borrowedItemsButton = new JButton("Borrowed Items");
        borrowedItemsButton.addActionListener(e -> new BorrowItemsUI(books, boardgames, gadgets).setVisible(true));

        add(bookButton);
        add(boardgameButton);
        add(gadgetButton);
        add(borrowedItemsButton);
        
        setLocationRelativeTo(null);
    }
}
