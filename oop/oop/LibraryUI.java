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
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // ตั้งค่าพื้นหลังเป็นรูป Library.png
        setContentPane(new JLabel(new ImageIcon("LibraryBG.png")));
        setLayout(new GridBagLayout()); // ใช้ GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        ImageIcon image = new ImageIcon("LibraryLogo.png");
        setIconImage(image.getImage());

        gbc.gridx = 1; // อยู่ที่คอลัมน์กลาง
        gbc.gridwidth = 1; // กว้างแค่คอลัมน์เดียว
        gbc.fill = GridBagConstraints.HORIZONTAL; // ทำให้ปุ่มขยายเต็มคอลัมน์กลาง
        gbc.insets = new Insets(10, 0, 10, 0); // กำหนดระยะห่างระหว่างปุ่ม

        Dimension buttonSize = new Dimension(200, 60); // ขนาดปุ่มใหญ่ขึ้น

        JButton bookButton = new JButton("Book");
        bookButton.setFont(new Font("Peace Sans", Font.BOLD, 18));
        bookButton.setPreferredSize(buttonSize);
        bookButton.addActionListener(e -> {new BookUI(books, boardgames, gadgets).setVisible(true); dispose();});
        dispose();

        JButton boardgameButton = new JButton("Boardgame");
        boardgameButton.setFont(new Font("Peace Sans", Font.BOLD, 18));
        boardgameButton.setPreferredSize(buttonSize);
        boardgameButton.addActionListener(e -> {new BoardgameUI(books, boardgames, gadgets).setVisible(true); dispose();});

        JButton gadgetButton = new JButton("Gadget");
        gadgetButton.setFont(new Font("Peace Sans", Font.BOLD, 18));
        gadgetButton.setPreferredSize(buttonSize);
        gadgetButton.addActionListener(e -> {new GadgetUI(books, boardgames, gadgets).setVisible(true); dispose();});

        JButton borrowedItemsButton = new JButton("Borrowed Items");
        borrowedItemsButton.setFont(new Font("Peace Sans", Font.BOLD, 18));
        borrowedItemsButton.setPreferredSize(buttonSize);
        borrowedItemsButton.addActionListener(e -> {new BorrowItemsUI(books, boardgames, gadgets).setVisible(true); dispose();});

        gbc.gridy = 0;
        add(bookButton, gbc);
        gbc.gridy = 1;
        add(boardgameButton, gbc);
        gbc.gridy = 2;
        add(gadgetButton, gbc);
        gbc.gridy = 3;
        add(borrowedItemsButton, gbc);

        setLocationRelativeTo(null); // ทำให้หน้าต่างอยู่กลางจอ
    }
}
