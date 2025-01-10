package Sangeeta.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Program extends JFrame implements ActionListener {



    private JLabel imageLabel; // To update the image
    private int currentImageIndex = 0; // To track which image to show
    private String[] imagePaths = {
            "Sangeeta/University/Management/System/bbdCampusImg.jpeg",
            "Sangeeta/University/Management/System/bbduMainBuilding.jpg",
            "Sangeeta/University/Management/System/bbd_outer_view.jpg",
            "Sangeeta/University/Management/System/bbdufrontView.jpg"
    };

    public Program(){
        setSize(1400,880);

        imageLabel = new JLabel();
        add(imageLabel);

        updateImage();

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextImage();
            }
        });
        timer.start(); // Start the timer

        JMenuBar mb = new JMenuBar();
        //new information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(new Color(0, 51, 102));
        newInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
        mb.add(newInformation);


        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        //Details
        JMenu details = new JMenu("View Details");
        details.setForeground(new Color(0, 128, 128));
       details.setFont(new Font("Tahoma", Font.BOLD, 16));
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
       details.add(studentdetails);

       //Leave
        JMenu leave = new JMenu("Apply Leave");
       leave.setFont(new Font("Tahoma", Font.BOLD, 16));
        leave.setForeground(new Color(0, 51, 102));
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);

        //Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
        leaveDetails.setForeground(new Color(0, 128, 128));
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //Exams
        JMenu exam = new JMenu("Examination");
        exam.setFont(new Font("Tahoma", Font.BOLD, 16));
        exam.setForeground(new Color(0, 51, 102));
        mb.add(exam);

        JMenuItem examinationdetail = new JMenuItem("Examination Result");
        examinationdetail.setBackground(Color.WHITE);
       examinationdetail.addActionListener(this);
        exam.add(examinationdetail);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        //Update info
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
        updateInfo.setForeground(new Color(0, 128, 128));
        mb.add(updateInfo);

        JMenuItem updateFacultyDetails = new JMenuItem("Update Faculty Details");
        updateFacultyDetails.setBackground(Color.WHITE);
        updateFacultyDetails.addActionListener(this);
        updateInfo.add(updateFacultyDetails);

        JMenuItem updateStudentDetails = new JMenuItem("Update Student Details");
        updateStudentDetails.setBackground(Color.WHITE);
        updateStudentDetails.addActionListener(this);
        updateInfo.add(updateStudentDetails);

        //Fee info
        JMenu Fee = new JMenu("Fee Details");
        Fee.setFont(new Font("Tahoma", Font.BOLD, 16));
        Fee.setForeground(new Color(0, 51, 102));
        mb.add(Fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        Fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        Fee.add(feeform);

        //utility
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Tahoma", Font.BOLD, 16));
       utility.setForeground(new Color(0, 128, 128));
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        //About
        JMenu about = new JMenu("About");
        about.setFont(new Font("Tahoma", Font.BOLD, 16));
        about.setForeground(new Color(0, 51, 102));
        mb.add(about);

        JMenuItem ab = new JMenuItem("About Developer");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);

        //exit
        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("Tahoma", Font.BOLD, 16));
        exit.setForeground(new Color(0, 128, 128));
        mb.add(exit);

        JMenuItem et = new JMenuItem("Exit Application");
        et.setBackground(Color.WHITE);
        et.addActionListener(this);
        exit.add(et);


        setJMenuBar(mb);

        setVisible(true);
    }

    // Method to update the displayed image
    private void updateImage() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(imagePaths[currentImageIndex]));
        // Scale the image
        Image i2 = i1.getImage().getScaledInstance(1350, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        imageLabel.setIcon(i3);
    }

    // Method to switch to the next image
    private void nextImage() {
        // Move to the next image, loop back to 0 if we reach the end
        currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
        updateImage(); // Update the image display
    }


    public void actionPerformed(ActionEvent ae){
      String msg = ae.getActionCommand();

      if(msg.equals("Exit Application")){
          setVisible(false);
      }
      else if (msg.equals("Calculator")){
          try{
              Runtime.getRuntime().exec("calc.exe");
          }catch (Exception e){};
      }
      else if (msg.equals("Notepad")){
          try{
              Runtime.getRuntime().exec("notepad.exe");
          }catch (Exception e){};
      }
      else if(msg.equals("New Faculty Information")){
          new AddTeacher();
      }
      else if(msg.equals("New Student Information")){
          new AddStudent();
      }
      else if(msg.equals("View Faculty Details")){
          new TeacherDetails();
      }
      else if(msg.equals("View Student Details")){
          new StudentDetails();
      }
      else if(msg.equals("Faculty Leave")){
          new TeacherLeave();
      }
      else if(msg.equals("Student Leave")){
          new StudentLeave();
      }
      else if(msg.equals("Faculty Leave Details")){
          new TeacherLeaveDetails();
      }
      else if(msg.equals("Student Leave Details")){
          new StudentLeaveDetails();
      }
      else if(msg.equals("Update Faculty Details")){
          new UpdateTeacher();
      }
      else if(msg.equals("Update Student Details")){
          new UpdateStudent();
      }
      else if(msg.equals("Enter Marks")){
          new EnterMarks();
      }
      else if(msg.equals("Examination Result")){
          new ExaminationDetails();
      }
      else if(msg.equals("Fee Structure")){
          new FeeStructure();
      }
      else if(msg.equals("Student Fee Form")){
          new StudentFeeForm();
      }
      else if(msg.equals("About Developer")){
          new About();
      }
    }

    public static void main(String[] args) {

        Program P = new Program();
    }
}
