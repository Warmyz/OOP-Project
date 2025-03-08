package oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GadgetUI extends JFrame {
    private JList<String> gadgetList;
    private DefaultListModel<String> gadgetModel;
    private ArrayList<Gadget> gadgets;

    public GadgetUI(ArrayList<Gadget> gadgets) {
        this.gadgets = gadgets;

        setTitle("Gadgets Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        gadgetModel = new DefaultListModel<>();
        gadgetList = new JList<>(gadgetModel);
        updateGadgetList();

        gadgetList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = gadgetList.getSelectedIndex();
                    if (index != -1) {
                        showGadgetDetails(gadgets.get(index));
                    }
                }
            }
        });

        add(new JScrollPane(gadgetList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton borrowButton = new JButton("Borrow");
        JButton returnButton = new JButton("Return");
        JButton backButton = new JButton("Back");

        borrowButton.addActionListener(e -> borrowGadget());
        returnButton.addActionListener(e -> returnGadget());
        backButton.addActionListener(e -> dispose());

        buttonPanel.add(backButton);
        buttonPanel.add(borrowButton);
        buttonPanel.add(returnButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
    }

    private void updateGadgetList() {
        gadgetModel.clear();
        for (Gadget gadget : gadgets) {
            gadgetModel.addElement(gadget.getName() + " " + gadget.getStatus());
        }
    }

    private void showGadgetDetails(Gadget gadget) {
        JOptionPane.showMessageDialog(this,
                gadget.getName() + " " + gadget.getStatus() + "\n" +
                        "Brand: " + gadget.getBrand() + "\n" +
                        "Spec: " + gadget.getSpec(),
                "Gadget Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private void borrowGadget() {
        int index = gadgetList.getSelectedIndex();
        if (index != -1) {
            Gadget gadget = gadgets.get(index);
            if (!gadget.isBorrowed()) {
                gadget.borrowItem();
                updateGadgetList();
            } else {
                JOptionPane.showMessageDialog(this, "This gadget is already borrowed!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void returnGadget() {
        int index = gadgetList.getSelectedIndex();
        if (index != -1) {
            Gadget gadget = gadgets.get(index);
            if (gadget.isBorrowed()) {
                gadget.returnItem();
                updateGadgetList();
            } else {
                JOptionPane.showMessageDialog(this, "This gadget is already available!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
