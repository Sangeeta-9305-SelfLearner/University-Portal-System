package Sangeeta.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login  extends JFrame implements ActionListener {
    JButton login,cancel;
    JTextField tfusername,tfpassword;
    public Login(){

        //set background color
       getContentPane().setBackground(Color.WHITE);
        setLayout(null); //remove default layout

       JLabel lblusername = new JLabel("Username");
       lblusername.setBounds(40,20,100,20);
       add(lblusername);

       tfusername = new JTextField();
       tfusername.setBounds(150,20,150,20);
       add(tfusername);

       JLabel lblpassword = new JLabel("Password");
       lblpassword.setBounds(40,70,150,20);
       add(lblpassword);

       tfpassword = new JPasswordField();
       tfpassword.setBounds(150,70,150,20);
       add(tfpassword);

       login = new JButton("Login");
       login.setBounds(40,140,120,30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       login.setFont(new Font("Tahoma",Font.BOLD,15));
        add(login);

       cancel = new JButton("Cancel");
       cancel.setBounds(180,140,120,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       cancel.setFont(new Font("Tahoma",Font.BOLD,15));
       add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Sangeeta/University/Management/System/login Img.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        System.out.println(ClassLoader.getSystemResource("bbd-log2.webp"));
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login){
           String username = tfusername.getText();
           String password = tfpassword.getText();

            //make my sql query
           String query = "select * from login where username = '"+ username + "' and password = '" + password + "'";
           //execute my sql query
            try{
                //create connection with my sql which is already happen in Connect class so make obj of it
                Connect c = new Connect();
                //execute query and store response
                ResultSet rs =c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Program();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password!");
                    setVisible(false);
                }

             //closing connection with my sql
            c.s.close();
            }catch(Exception e){
                e.printStackTrace();
            }


        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        Login l = new Login();
    }
}
