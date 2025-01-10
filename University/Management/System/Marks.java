package Sangeeta.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Marks extends JFrame implements ActionListener {

    String rollno;
    JButton cancel;

    Marks(String rollno){
       this.rollno=rollno;

       setSize(500,600);
       setLocation(500,100);
        setLayout(null);

        getContentPane().setBackground(Color.decode("#E3F2FD"));

        JLabel heading = new JLabel("Babu Banarasi Das University");
        heading.setBounds(100,10,500,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination -- 2024");
        subheading.setBounds(100,50,500,20);
        subheading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number  --->   "+rollno);
        lblrollno.setBounds(60,100,500,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblrollno);

        JLabel lblsemester= new JLabel("");
        lblsemester.setBounds(60,130,500,20);
        lblsemester.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsemester);

        JLabel sub1= new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub1);

        JLabel sub2= new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub2);

        JLabel sub3= new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub3);

        JLabel sub4= new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub4);

        JLabel sub5= new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub5);

        JLabel sub6= new JLabel();
        sub6.setBounds(100,350,500,20);
        sub6.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub6);

        JLabel marks1= new JLabel();
        marks1.setBounds(300,200,500,20);
        marks1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(marks1);

        JLabel marks2= new JLabel();
        marks2.setBounds(300,230,500,20);
        marks2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(marks2);

        JLabel marks3= new JLabel();
        marks3.setBounds(300,260,500,20);
        marks3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(marks3);

        JLabel marks4= new JLabel();
        marks4.setBounds(300,290,500,20);
        marks4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(marks4);

        JLabel marks5= new JLabel();
        marks5.setBounds(300,320,500,20);
        marks5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(marks5);

        JLabel marks6= new JLabel();
        marks6.setBounds(300,350,500,20);
        marks6.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(marks6);


        try{
         Connect con = new Connect();
            ResultSet rs1 = con.s.executeQuery("select * from subject where Roll_no ='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("Subject1"));
                sub2.setText(rs1.getString("Subject2"));
                sub3.setText(rs1.getString("Subject3"));
                sub4.setText(rs1.getString("Subject4"));
                sub5.setText(rs1.getString("Subject5"));
                sub6.setText(rs1.getString("Subject6"));
            }

            ResultSet rs2 = con.s.executeQuery("select * from marks where Roll_no ='"+rollno+"'");
            while(rs2.next()){
                marks1.setText(rs2.getString("Marks1"));
                marks2.setText(rs2.getString("Marks2"));
                marks3.setText(rs2.getString("Marks3"));
                marks4.setText(rs2.getString("Marks4"));
                marks5.setText(rs2.getString("Marks5"));
                marks6.setText(rs2.getString("Marks6"));

                lblsemester.setText("Semester   --->    "+rs2.getString("Semester"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Back");
        cancel.setBounds(200,500,120,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);





       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
         setVisible(false);
    }
    public static void main(String[] args) {
        new Marks("");
    }
}
