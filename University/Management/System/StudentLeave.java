package Sangeeta.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class StudentLeave extends JFrame implements ActionListener {

    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;

    JLabel heading;
    Timer timer;
    int x = 50;
    int direction = 1;

    StudentLeave(){


        setSize(500,550);
        setLocation(550,100);

        getContentPane().setBackground(Color.decode("#E3F2FD"));
        setLayout(null);


         heading = new JLabel("Student Leave Portal");
        heading.setBounds(60,20,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        timer = new Timer(15, e -> moveHeading());
        timer.start();

        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60,80,200,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(60,110,200,25);
        add(crollno);

        try{
            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("Roll_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,160,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60,190,200,25);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,240,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60,270,200,25);
        ctime.add("Half Day");
        ctime.add("Full Day");
        ctime.add("2 Day");
        ctime.add("3 Day");
        ctime.add("4 Day");
        ctime.add("5 Day");
        ctime.add("1 Week");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60,330,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,330,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);

        setVisible(true);
    }

    private void moveHeading() {

        int leftBoundary = 50;
        int rightBoundary = 450;

        x += direction;

        // Reverse direction if it hits the boundaries
        if (x <= leftBoundary || x >= rightBoundary - heading.getWidth()) {
            direction *= -1;
        }

        // Set the new position of the heading
        heading.setBounds(x, 20, 300, 30);
    }

    public void  actionPerformed(ActionEvent ae){
      if(ae.getSource()==submit){
          String rollno = crollno.getSelectedItem();
          String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
          String duration = ctime.getSelectedItem();
          String query = "insert into student_leave values ('"+rollno+"','"+date+"','"+duration+"')";
          try{
            Connect con = new Connect();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Leave Successfully Submitted!!");
            setVisible(false);
          } catch (Exception e){
              e.printStackTrace();
          }
      }
      else{
          setVisible(false);
      }
    }
    public static void main(String[] args) {
      new StudentLeave();
    }
}
