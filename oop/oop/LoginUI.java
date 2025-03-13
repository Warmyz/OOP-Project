package oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class LoginUI extends JFrame {
    private JTextField idField;
    private JPasswordField passwordField;
    private ArrayList<Book> books;
    private ArrayList<Boardgame> boardgames;
    private ArrayList<Gadget> gadgets;

    public LoginUI(ArrayList<Book> books, ArrayList<Boardgame> boardgames, ArrayList<Gadget> gadgets) {
        this.books = books;
        this.boardgames = boardgames;
        this.gadgets = gadgets;

        ImageIcon image = new ImageIcon("LibraryLogo.png");
        setIconImage(image.getImage());

        setTitle("Library Login");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // ระยะห่างรอบๆ
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // **Library Logo**
        ImageIcon logoIcon = new ImageIcon("LibraryLogo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(logoImage);

        JLabel logoLabel = new JLabel(scaledIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  
        gbc.anchor = GridBagConstraints.CENTER;
        add(logoLabel, gbc);

        // **Student ID**
        gbc.gridwidth = 1;
        gbc.weightx = 0; // ไม่ให้ Label ขยาย
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END; 
        add(new JLabel("Student ID:"), gbc);

        idField = new JTextField(20);
        gbc.gridx = 1;
        gbc.weightx = 1; 
        gbc.anchor = GridBagConstraints.LINE_START;
        add(idField, gbc);

        // **Password**
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0; 
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Password:"), gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(passwordField, gbc);

        // **Login Button**
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(120, 40));
        loginButton.addActionListener((ActionEvent e) -> {
            String userId = idField.getText();
            String password = new String(passwordField.getPassword());

            if (Member.authenticate(userId, password)) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                new LibraryUI(books, boardgames, gadgets).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid ID or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);
    }
}
