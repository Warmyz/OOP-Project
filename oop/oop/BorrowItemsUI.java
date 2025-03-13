package oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BorrowItemsUI extends JFrame {
    private JList<String> borrowedList;
    private DefaultListModel<String> borrowedModel;

    public BorrowItemsUI(ArrayList<Book> books, ArrayList<Boardgame> boardgames, ArrayList<Gadget> gadgets) {
        setTitle("Borrowed Items");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        ImageIcon image = new ImageIcon("LibraryLogo.png");
        setIconImage(image.getImage());

        borrowedModel = new DefaultListModel<>();
        borrowedList = new JList<>(borrowedModel);
        add(new JScrollPane(borrowedList), BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {dispose(); new LibraryUI(books, boardgames, gadgets).setVisible(true);});
        add(backButton, BorderLayout.SOUTH);

        loadBorrowedItems(books, boardgames, gadgets);
        
        setLocationRelativeTo(null);
    }

    private void loadBorrowedItems(ArrayList<Book> books, ArrayList<Boardgame> boardgames, ArrayList<Gadget> gadgets) {
        borrowedModel.clear();
        for (Book book : books) {
            if (book.isBorrowed()) {
                borrowedModel.addElement(book.getName() + " (Borrowed)");
            }
        }
        for (Boardgame boardgame : boardgames) {
            if (boardgame.isBorrowed()) {
                borrowedModel.addElement(boardgame.getName() + " (Borrowed)");
            }
        }
        for (Gadget gadget : gadgets) {
            if (gadget.isBorrowed()) {
                borrowedModel.addElement(gadget.getName() + " (Borrowed)");
            }
        }
    }
}