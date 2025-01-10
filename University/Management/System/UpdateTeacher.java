package Sangeeta.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.*;

public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField tfqualified,tfdepartment,tfaddress,tfphone,tfemail;
    JLabel labelname,labelfname,labeldob,labelEmpId,labelx,labelxii,labelaadhar,heading;
    JButton update,cancel;
    Choice cEmpId;

    Timer timer;
    int x = 200;
    int direction = 1;

    UpdateTeacher(){
        setSize(900,650);
        setLocation(300,50);
        setLayout(null);

        getContentPane().setBackground(Color.decode("#EDE7F6"));

        heading = new JLabel("Update Faculty Profile");
        heading.setBounds(50,10,600,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        timer = new Timer(15, e -> moveHeading());
        timer.start();

        JLabel lblrollnumber = new JLabel("Search Employee Id");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollnumber);

        cEmpId = new Choice();
        cEmpId.setBounds(250,100,200,20);
        add(cEmpId);

        try{
            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpId.add(rs.getString("Emp_Id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        labelname  = new JLabel();
        labelname .setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname );

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        labelfname = new JLabel();
        labelfname .setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname );

        JLabel lblEmpId = new JLabel("Employee Id");
        lblEmpId.setBounds(50,200,200,30);
        lblEmpId.setFont(new Font("serif",Font.BOLD,20));
        add(lblEmpId);

        labelEmpId = new JLabel();
        labelEmpId.setBounds(200,200,150,30);
        labelEmpId.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelEmpId);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(600,200,150,30);
        labeldob.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeldob);

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

        labelx = new JLabel();
        labelx.setBounds(600,300,150,30);
        labelx.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelx);

        JLabel lblxii= new JLabel("Class XIIth (%)");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        labelxii = new JLabel();
        labelxii.setBounds(200,350,150,30);
        labelxii.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelxii);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);

        labelaadhar= new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelaadhar);

        JLabel lblqualified= new JLabel("Qualification");
        lblqualified.setBounds(50,400,200,30);
        lblqualified.setFont(new Font("serif",Font.BOLD,20));
        add(lblqualified);

        tfqualified = new JTextField();
        tfqualified.setBounds(200,400,150,30);
        add(tfqualified);


        JLabel lbldepartment= new JLabel("Department");
        lbldepartment.setBounds(400,400,200,30);
        lbldepartment.setFont(new Font("serif",Font.BOLD,20));
        add(lbldepartment);

        tfdepartment = new JTextField();
        tfdepartment.setBounds(600,400,150,30);
        add( tfdepartment);

        try{
            Connect con = new Connect();
            String query = "select * from teacher where Emp_Id ='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("Name"));
                labelfname.setText(rs.getString("Father's_Name"));
                labeldob.setText(rs.getString("Date_of_birth"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email_Id"));
                labelx.setText(rs.getString("Class_X th"));
                labelxii.setText(rs.getString("Class_XII th"));
                labelaadhar.setText(rs.getString("Aadhar_No"));
                labelEmpId.setText(rs.getString("Emp_Id"));
                tfqualified.setText(rs.getString("Qualification"));
                tfdepartment.setText(rs.getString("Department"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        cEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Connect con = new Connect();
                    String query = "select * from teacher where Emp_Id ='"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = con.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("Name"));
                        labelfname.setText(rs.getString("Father's_Name"));
                        labeldob.setText(rs.getString("Date_of_birth"));
                        tfaddress.setText(rs.getString("Address"));
                        tfphone.setText(rs.getString("Phone"));
                        tfemail.setText(rs.getString("Email_Id"));
                        labelx.setText(rs.getString("Class_X th"));
                        labelxii.setText(rs.getString("Class_XII th"));
                        labelaadhar.setText(rs.getString("Aadhar_No"));
                        labelEmpId.setText(rs.getString("Emp_Id"));
                        tfqualified.setText(rs.getString("Qualification"));
                        tfdepartment.setText(rs.getString("Department"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });


        update = new JButton("Update");
        update.setBounds(250,500,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);



        setVisible(true);

    }

    private void moveHeading() {

        int leftBoundary = 200;
        int rightBoundary = 700;

        x += direction;

        if (x <= leftBoundary || x >= rightBoundary - heading.getWidth()) {
            direction *= -1;
        }

        heading.setBounds(x, 20, 300, 30);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String empId = labelEmpId.getText();
            String address = tfaddress.getText();
            String phone  = tfphone.getText();
            String email = tfemail.getText();
            String qualified = tfqualified.getText();
            String department = tfdepartment.getText();

            try{
                String query1 = "update teacher set Address ='"+address+"',Phone ='"+phone+"'," +
                        "Email_Id = '"+email+"', Qualification='"+qualified+"',Department='"+department+"'where Emp_Id ='"+empId+"'";
                Connect con = new Connect();
                con.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null,"Faculty Details Updated Successfully!");
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

        new UpdateTeacher();
    }
}


