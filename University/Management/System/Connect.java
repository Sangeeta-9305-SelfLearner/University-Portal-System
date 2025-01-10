package Sangeeta.University.Management.System;

import javax.swing.*;
import java.sql.*;

public class Connect extends JFrame{

    Connection  c;
    Statement s;
    public Connect(){
      try{
          //Register Driver class
          Class.forName("com.mysql.cj.jdbc.Driver");
          //Creating connection string
          c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sangeeta_university_management_system","root","@Sange199$");
          //creating the statement
          s=c.createStatement();
      }catch(Exception e){
          e.printStackTrace();
      }
    }
    public static void main(String[] args) {
      Connect co = new Connect();
    }
}
