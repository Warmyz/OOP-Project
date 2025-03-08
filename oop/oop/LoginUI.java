package oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        setTitle("Library Login");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // ทำให้หน้าต่างอยู่กลางจอ
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));  // ใช้ BoxLayout แนวตั้ง

        // สร้าง JPanel สำหรับกรอกข้อมูล ID
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));  // FlowLayout ชิดซ้าย
        JLabel idLabel = new JLabel("Student ID:");
        idField = new JTextField(15);  // ตั้งจำนวนคอลัมน์ของ JTextField
        idField.setPreferredSize(new Dimension(200, 30));  // ขนาดที่ต้องการสำหรับช่องกรอก
        idPanel.add(idLabel);
        idPanel.add(idField);

        // สร้าง JPanel สำหรับกรอกข้อมูล Password
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));  // FlowLayout ชิดซ้าย
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);  // ตั้งจำนวนคอลัมน์ของ JPasswordField
        passwordField.setPreferredSize(new Dimension(200, 30));  // ขนาดที่ต้องการสำหรับช่องกรอก
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        // สร้าง JPanel สำหรับปุ่ม Login
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // จัดปุ่ม Login ให้อยู่ตรงกลาง
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = idField.getText();
                String password = new String(passwordField.getPassword());

                // เรียกใช้งาน authenticate จาก Member
                if (Member.authenticate(userId, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    new LibraryUI(books, boardgames, gadgets).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid ID or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(loginButton);

        // จัดระเบียบหน้าต่างโดยใช้ BoxLayout
        add(idPanel);  // ใส่ panel สำหรับกรอก Student ID
        add(Box.createVerticalStrut(10));  // ระยะห่างระหว่างบรรทัดแรกกับบรรทัดสอง
        add(passwordPanel);  // ใส่ panel สำหรับกรอก Password
        add(Box.createVerticalStrut(10));  // ระยะห่างระหว่างบรรทัดสองกับบรรทัดสาม
        add(buttonPanel);  // ใส่ปุ่ม Login
    }
}
