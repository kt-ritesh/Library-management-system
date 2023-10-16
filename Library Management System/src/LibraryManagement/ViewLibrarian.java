package LibraryManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewLibrarian extends JFrame
{
    String x[]={"Id","Name","password","Email","Contact no","Address","City"};
    JButton bt;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    
    ViewLibrarian()
    {
        super("Librarian information");
        setSize(1000,400);
        setLocation(1,1);
        f=new Font("Arial",Font.BOLD,15);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="Select * from librarian";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("Lid");   
                y[i][j++]=rest.getString("name");   
                y[i][j++]=rest.getString("password");  
                y[i][j++]=rest.getString("email");  
                y[i][j++]=rest.getString("contact");
                y[i][j++]=rest.getString("address");
                y[i][j++]=rest.getString("city");
                i++;
                j=0;
            }
            t=new JTable(y,x);
            t.setFont(f);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        add(sp);
    }
    public static void main(String[] args) 
    {
        new ViewLibrarian().setVisible(true);
    }
}
