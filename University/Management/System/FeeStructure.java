package Sangeeta.University.Management.System;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame{
    FeeStructure(){
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(360,10,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        getContentPane().setBackground(Color.decode("#EDE7F6"));

        JTable table = new JTable(){
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
         ResultSet rs = con.s.executeQuery("select * from fee");
         table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
         e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,60,1000,700);
        add(jsp);


        setVisible(true);
    }
    public static void main(String[] args) {
        new FeeStructure();
    }
}
