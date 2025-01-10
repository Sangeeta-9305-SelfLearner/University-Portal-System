package Sangeeta.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class About extends JFrame {
    About() {
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.decode("#EDE7F6"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Sangeeta/University/Management/System/bbdImgForAbout.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 160, 300, 200);

        add(image);

        JLabel heading = new JLabel("<html>University<br/>Management System</html>", SwingConstants.CENTER);
        heading.setBounds(70, 20, 550, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                heading.setForeground(Color.BLUE);
                heading.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                heading.setForeground(Color.BLACK);
            }
        });
        heading.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                int newSize = heading.getWidth() / 10; // Adjusting font size dynamically
                heading.setFont(new Font("Tahoma", Font.BOLD, newSize > 30 ? 30 : newSize));
            }
        });
        add(heading);

        JLabel name = new JLabel("Developed By: Sangeeta Yadav");
        name.setBounds(70, 200, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(name);

        JLabel section = new JLabel("Student of BCA23");
        section.setBounds(70, 240, 550, 40);
        section.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(section);

        JLabel contact = new JLabel("Contact: sangeetayadav6826@gmail.com");
        contact.setBounds(70, 280, 550, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 10));
        contact.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                contact.setForeground(Color.BLUE);
                contact.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                contact.setForeground(Color.BLACK);
            }
        });
        add(contact);

        // Contact Developer Button
        JButton contactButton = new JButton("Contact Developer");
        contactButton.setBounds(70, 340, 200, 30);
        contactButton.setBackground(Color.decode("#7E57C2"));
        contactButton.setForeground(Color.WHITE);
        contactButton.setFocusPainted(false);
        contactButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().mail(new URI("mailto:sangeetayadav6826@gmail.com"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Unable to open mail client.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(contactButton);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(300, 400, 100, 30);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> dispose());
        add(exitButton);


        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
