package Sangeeta.University.Management.System;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.sql.*;
import java.awt.event.*;


public class ExaminationDetails extends JFrame implements ActionListener{

    JTextField search;
    JButton result,cancel;
    JTable table;


    ExaminationDetails(){
        setSize(1000,700);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.decode("#E3F2FD"));


        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80,15,400,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(heading);

        search = new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma",Font.BOLD,15));
        add(search);

        result = new JButton("Result");
        result.setBounds(300,90,120,30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        result.setFont(new Font("Tahoma",Font.BOLD,15));
        add(result);

        cancel = new JButton("Back");
        cancel.setBounds(440,90,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);

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
        table.setFont(new Font("Tahoma",Font.PLAIN,16));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,700);
        add(jsp);

        try{
             Connect con = new Connect();
             ResultSet rs = con.s.executeQuery("select * from student");
             table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });




        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == result){
            setVisible(false);
           new Marks(search.getText());
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
