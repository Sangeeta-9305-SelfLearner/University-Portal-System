package Sangeeta.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice crollno;
    JLabel labelname ,labelfname,labeltotal;
    JComboBox cbcourse,cbbranch,cbsemester;
    JButton update,pay,back;

    StudentFeeForm(){
        setSize(700,500);
        setLocation(300,100);
        setLayout(null);

        JLabel mainheading = new JLabel("Online Fee Submission ");
        mainheading.setBounds(200,10,600,50);
        mainheading.setFont(new Font("serif",Font.BOLD,30));
        add(mainheading);

        getContentPane().setBackground(Color.decode("#EDE7F6"));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Sangeeta/University/Management/System/large-removebg-preview.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,130,400,200);
        add(image);

        JLabel lblrollnumber = new JLabel("Search Roll No");
        lblrollnumber.setBounds(40,70,150,20);
        lblrollnumber.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200,70,150,20);
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


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,110,150,20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblname);

        labelname  = new JLabel();
        labelname .setBounds(200,110,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname );

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40,150,150,20);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfname);

        labelfname = new JLabel();
        labelfname .setBounds(200,150,150,20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelfname );

        try{
            Connect con = new Connect();
            String query = "select * from student where Roll_no ='"+crollno.getSelectedItem()+"'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("Name"));
                labelfname.setText(rs.getString("Father's_ name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Connect con = new Connect();
                    String query = "select * from student where Roll_no ='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = con.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("Name"));
                        labelfname.setText(rs.getString("Father's_ name"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        JLabel lblcourse= new JLabel("Course");
        lblcourse.setBounds(40,190,150,20);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcourse);

        String course[] = {"BA","BBA","BCA","B.Tech","Bsc","MCA","M.Tech","Msc","MA","MCom"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,190,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);


        JLabel lblbranch= new JLabel("Branch");
        lblbranch.setBounds(40,230,150,20);
        lblbranch.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblbranch);

        String branch[] = {"IT","Electronics","Mechanical","Civil","Computer Science"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200,230,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40,270,150,20);
        lblsemester.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblsemester);

        String semester[] = {"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,270,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lbltotal= new JLabel("Total Payable");
        lbltotal.setBounds(40,310,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(200,310,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeltotal);

        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma",Font.BOLD,15));
        add(pay);

        back = new JButton("Back");
        back .setBounds(270,380,100,25);
        back .setBackground(Color.BLACK);
        back .setForeground(Color.WHITE);
        back .addActionListener(this);
        back .setFont(new Font("Tahoma",Font.BOLD,15));
        add( back );

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==update){
              String course = (String) cbcourse.getSelectedItem();
              String semester=(String) cbsemester.getSelectedItem();
              try{
                  Connect con = new Connect();
                  ResultSet rs = con.s.executeQuery("select * from fee where Course='"+course+"'");
                  while(rs.next()){
                      labeltotal.setText(rs.getString(semester));
                  }
              }catch (Exception e){
                  e.printStackTrace();
              }
         }
         else if(ae.getSource()==pay){
             String rollno = crollno.getSelectedItem();
             String course = (String) cbcourse.getSelectedItem();
             String semester = (String) cbsemester.getSelectedItem();
             String branch = (String) cbbranch.getSelectedItem();
             String total = labeltotal.getText();
             try{
                 Connect con = new Connect();
                 String query = "insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"College Fee Submitted Successfully!");
                setVisible(false);
             }catch (Exception e){
                 e.printStackTrace();
             }
         }
         else{
             setVisible(false);
         }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
