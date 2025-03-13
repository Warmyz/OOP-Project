package oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BoardgameUI extends JFrame {
    private JList<String> boardgameList;
    private DefaultListModel<String> listModel;
    private ArrayList<Boardgame> boardgames;

    public BoardgameUI(ArrayList<Book> books, ArrayList<Boardgame> boardgames, ArrayList<Gadget> gadgets) {
        this.boardgames = boardgames;

        setTitle("Boardgame Menu");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        ImageIcon image = new ImageIcon("LibraryLogo.png");
        setIconImage(image.getImage());

        listModel = new DefaultListModel<>();
        boardgameList = new JList<>(listModel);
        updateBoardgameList();

        boardgameList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = boardgameList.getSelectedIndex();
                    if (index != -1) {
                        showBoardgameDetails(boardgames.get(index));
                    }
                }
            }
        });

        add(new JScrollPane(boardgameList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton borrowButton = new JButton("Borrow");
        JButton returnButton = new JButton("Return");
        JButton backButton = new JButton("Back");

        borrowButton.addActionListener(e -> borrowBoardgame());
        returnButton.addActionListener(e -> returnBoardgame());
        backButton.addActionListener(e -> {dispose(); new LibraryUI(books, boardgames, gadgets).setVisible(true);});

        buttonPanel.add(backButton);
        buttonPanel.add(borrowButton);
        buttonPanel.add(returnButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
    }

    private void updateBoardgameList() {
        listModel.clear();
        for (Boardgame boardgame : boardgames) {
            listModel.addElement(boardgame.getName() + " " + boardgame.getStatus());
        }
    }

    private void showBoardgameDetails(Boardgame boardgame) {
        JOptionPane.showMessageDialog(this,
                boardgame.getName() + " " + boardgame.getStatus() + "\n" +
                        "Type: " + boardgame.getType() + "\n" +
                        "Player: " + boardgame.getPlayer() + "\n" +
                        "Playtime: " + boardgame.getPlaytime(),
                "Boardgame Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private void borrowBoardgame() {
        int index = boardgameList.getSelectedIndex();
        if (index != -1) {
            Boardgame boardgame = boardgames.get(index);
            if (!boardgame.isBorrowed()) {
                boardgame.borrowItem();
                updateBoardgameList();
            } else {
                JOptionPane.showMessageDialog(this, "This boardgame is already borrowed!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void returnBoardgame() {
        int index = boardgameList.getSelectedIndex();
        if (index != -1) {
            Boardgame boardgame = boardgames.get(index);
            if (boardgame.isBorrowed()) {
                boardgame.returnItem();
                updateBoardgameList();
            } else {
                JOptionPane.showMessageDialog(this, "This boardgame is already available!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}