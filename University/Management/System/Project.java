package Sangeeta.University.Management.System;

import javax.swing.*;
import java.awt.*;

public class Project extends JFrame implements Runnable{

    Thread t;
    public Project() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Sangeeta/University/Management/System/bbduMainBuilding.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1020, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start(); //it will call run method

        setVisible(true);

        int x =1;
        for(int i=2; i<=610; i+=4,x+=1){
            setLocation(610-((i+x)/2),370-(i/2));
            setSize(i+3*x,i+x/2);

            //for opening image slowly
        try {
            Thread.sleep(10);
                 } catch (Exception e) {}
        }

   }

    //for implement Runnable , i have to override run method which is already present in Runnable class (for understanding)
    public void run(){
        //code for remove frame after 7 sec
      try{
          Thread.sleep(7000);
          setVisible(false);
          //next Frame (login)
          Login l = new Login();
      }catch (Exception e){

      }
    }

    public static void main(String [] args) {
        Project p = new Project();

    }
}
