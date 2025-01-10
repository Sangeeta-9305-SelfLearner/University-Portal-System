package Sangeeta.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class AddStudent extends JFrame implements ActionListener {
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JLabel labelrollno,heading;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;

  Timer timer;
  int x = 150;
  int direction = 1;

  Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000l)+1000l);

    AddStudent(){
      setSize(900,700);
      setLocation(300,50);
      setLayout(null);

      getContentPane().setBackground(Color.decode("#E3F2FD"));


       heading = new JLabel("Register New Student");
      heading.setBounds(310,40,500,50);
      heading.setFont(new Font("serif",Font.BOLD,30));
      add(heading);

      timer = new Timer(15, e -> moveHeading());
      timer.start();

      JLabel lblname = new JLabel("Name");
      lblname.setBounds(50,150,100,30);
      lblname.setFont(new Font("serif",Font.BOLD,20));
      add(lblname);

      tfname = new JTextField();
      tfname.setBounds(200,150,150,30);
      add(tfname);

      JLabel lblfname = new JLabel("Father's Name");
      lblfname.setBounds(400,150,200,30);
      lblfname.setFont(new Font("serif",Font.BOLD,20));
      add(lblfname);

      tffname = new JTextField();
      tffname.setBounds(600,150,150,30);
      add(tffname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelrollno = new JLabel("1230211"+first4);
        labelrollno.setBounds(200,200,150,30);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);

      JLabel dob = new JLabel("Date of Birth");
      dob.setBounds(400,200,200,30);
      dob.setFont(new Font("serif",Font.BOLD,20));
      add(dob);

      dcdob = new JDateChooser();
      dcdob.setBounds(600,200,150,30);
      add(dcdob);

        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

      JLabel lblemail= new JLabel("Email ID");
      lblemail.setBounds(50,300,200,30);
      lblemail.setFont(new Font("serif",Font.BOLD,20));
      add(lblemail);

      tfemail = new JTextField();
      tfemail.setBounds(200,300,150,30);
      add(tfemail);

      JLabel lblx = new JLabel("Class Xth (%)");
      lblx.setBounds(400,300,200,30);
      lblx.setFont(new Font("serif",Font.BOLD,20));
      add(lblx);

      tfx = new JTextField();
      tfx.setBounds(600,300,150,30);
      add(tfx);

      JLabel lblxii= new JLabel("Class XIIth (%)");
      lblxii.setBounds(50,350,200,30);
      lblxii.setFont(new Font("serif",Font.BOLD,20));
      add(lblxii);

      tfxii = new JTextField();
      tfxii.setBounds(200,350,150,30);
      add(tfxii);

      JLabel lblaadhar = new JLabel("Aadhar Number");
      lblaadhar.setBounds(400,350,200,30);
      lblaadhar.setFont(new Font("serif",Font.BOLD,20));
      add(lblaadhar);

      tfaadhar= new JTextField();
      tfaadhar.setBounds(600,350,150,30);
      add(tfaadhar);

      JLabel lblcourse= new JLabel("Course");
      lblcourse.setBounds(50,400,200,30);
      lblcourse.setFont(new Font("serif",Font.BOLD,20));
      add(lblcourse);

      String course[] = {"BA","BBA","BCA","B.Tech","Bsc","MCA","M.Tech","Msc","MA","MCom"};
      cbcourse = new JComboBox(course);
      cbcourse.setBounds(200,400,150,30);
      cbcourse.setBackground(Color.WHITE);
      add(cbcourse);


      JLabel lblbranch= new JLabel("Branch");
      lblbranch.setBounds(400,400,200,30);
      lblbranch.setFont(new Font("serif",Font.BOLD,20));
      add(lblbranch);

      String branch[] = {"IT","Electronics","Mechanical","Civil","Computer Science"};
      cbbranch = new JComboBox(branch);
      cbbranch.setBounds(600,400,150,30);
      cbbranch.setBackground(Color.WHITE);
      add(cbbranch);

      submit = new JButton("Submit");
      submit.setBounds(250,550,120,30);
      submit.setBackground(Color.BLACK);
      submit.setForeground(Color.WHITE);
      submit.addActionListener(this);
      submit.setFont(new Font("Tahoma",Font.BOLD,15));
      add(submit);

      cancel = new JButton("Cancel");
      cancel.setBounds(450,550,120,30);
      cancel.setBackground(Color.BLACK);
      cancel.setForeground(Color.WHITE);
      cancel.addActionListener(this);
      cancel.setFont(new Font("Tahoma",Font.BOLD,15));
      add(cancel);



      setVisible(true);

    }

  private void moveHeading() {

    int leftBoundary = 150;
    int rightBoundary = 750;

    x += direction;

    if (x <= leftBoundary || x >= rightBoundary - heading.getWidth()) {
      direction *= -1;
    }

    heading.setBounds(x, 40, 300, 30);
  }

    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == submit){
        String name = tfname.getText();
        String fname = tffname.getText();
        String rollno = labelrollno.getText();
        String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
        String address = tfaddress.getText();
        String phone  = tfphone.getText();
        String email = tfemail.getText();
        String x = tfx.getText();
        String xii = tfxii.getText();
        String aadhar = tfaadhar.getText();
        String course = (String) cbcourse.getSelectedItem();
        String branch = (String) cbbranch.getSelectedItem();

        try{
          SimpleDateFormat inputFormat = new SimpleDateFormat("d MMM yyyy");
          SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
          dob = outputFormat.format(inputFormat.parse(dob));

         String query1 = "insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"'," +
                 "'"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";

         Connect con = new Connect();
         con.s.executeUpdate(query1);

         JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully!");
         setVisible(false);
        }catch(Exception e){
          e.printStackTrace();
        }
      }
      else{
        setVisible(false);
      }

    }
    public static void main(String[] args) {
        new AddStudent();
    }
}
