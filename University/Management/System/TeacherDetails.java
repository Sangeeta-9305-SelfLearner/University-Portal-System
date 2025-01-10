package Sangeeta.University.Management.System;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search, print, update, add, cancel;

    public TeacherDetails(){


        JLabel mainheading = new JLabel("Faculty Details");
        mainheading.setBounds(300,10,600,50);
        mainheading.setFont(new Font("serif",Font.BOLD,30));
        add(mainheading);

        getContentPane().setBackground(Color.decode("#EDE7F6"));
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20,80,150,20);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        cEmpId = new Choice();
        cEmpId.setBounds(180,80,150,20);
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

        table = new JTable(){
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);

                // Alternate row colors
                if (!isRowSelected(row)) {
                    c.setBackground(row % 2 == 0 ? Color.decode("#E8F5E9") : Color.decode("#FCE4EC"));
                } else {
                    c.setBackground(Color.decode("#FFCCBC")); // Highlighted row color
                }
                return c;
            }
        };
        try{
            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,180,900,600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20,130,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,130,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,130,80,20);
        update.addActionListener(this);
        add(update);

        add = new JButton("Add");
        add.setBounds(320,130,80,20);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,130,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            String query = "select * from teacher where Emp_Id = '"+cEmpId.getSelectedItem()+"'";
            try{
                Connect con = new Connect();
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == add){
            setVisible(false);
            new AddTeacher();
        }
        else if (ae.getSource() == update){
            setVisible(false);
             new UpdateTeacher();
        }
        else {
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new TeacherDetails();
    }
}

