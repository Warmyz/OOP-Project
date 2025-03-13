package oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BookUI extends JFrame {
    private JList<String> bookList;
    private DefaultListModel<String> listModel;
    private ArrayList<Book> books;

    public BookUI(ArrayList<Book> books, ArrayList<Boardgame> boardgames, ArrayList<Gadget> gadgets) {
        this.books = books;
        
        
        setTitle("Book Menu");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        ImageIcon image = new ImageIcon("LibraryLogo.png");
        setIconImage(image.getImage());

        listModel = new DefaultListModel<>();
        bookList = new JList<>(listModel);
        updateBookList();

        bookList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = bookList.getSelectedIndex();
                    if (index != -1) {
                        showBookDetails(books.get(index));
                    }
                }
            }
        });

        add(new JScrollPane(bookList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton borrowButton = new JButton("Borrow");
        JButton returnButton = new JButton("Return");
        JButton backButton = new JButton("Back");

        borrowButton.addActionListener(e -> borrowBook());
        returnButton.addActionListener(e -> returnBook());
        backButton.addActionListener(e -> {dispose(); new LibraryUI(books, boardgames, gadgets).setVisible(true);});

        buttonPanel.add(backButton);
        buttonPanel.add(borrowButton);
        buttonPanel.add(returnButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
    }

    private void updateBookList() {
        listModel.clear();
        for (Book book : books) {
            listModel.addElement(book.getName() + " " + book.getStatus());
        }
    }

    private void showBookDetails(Book book) {
        JOptionPane.showMessageDialog(this,
                book.getName() + " " + book.getStatus() + "\n" +
                        "Author: " + book.getAuthor() + "\n" +
                        "Genre: " + book.getGenre(),
                "Book Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private void borrowBook() {
        int index = bookList.getSelectedIndex();
        if (index != -1) {
            Book book = books.get(index);
            if (!book.isBorrowed()) {
                book.borrowItem();
                updateBookList();
            } else {
                JOptionPane.showMessageDialog(this, "This book is already borrowed!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void returnBook() {
        int index = bookList.getSelectedIndex();
        if (index != -1) {
            Book book = books.get(index);
            if (book.isBorrowed()) {
                book.returnItem();
                updateBookList();
            } else {
                JOptionPane.showMessageDialog(this, "This book is already available!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
