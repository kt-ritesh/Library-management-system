package LibraryManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DeleteLibrarian extends JFrame implements ActionListener
{
    String x[]={"Id","Name","password","Email","Contact no","Address","City"};
    JButton bt,bt1;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    JLabel l1;
    JTextField tf1;
    JPanel p1;
    
    DeleteLibrarian()
    {
        super("Librarian information");
        setSize(1000,400);
        setLocation(1,1);
        f=new Font("Arial",Font.BOLD,15);
        f1=new Font("Arial",Font.BOLD,20);
        
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
        
        l1=new JLabel("Delete Librarian");
        tf1=new JTextField();
        bt1=new JButton("Delete");
        bt1.addActionListener(this);
        
        l1.setFont(f1);
        tf1.setFont(f1);
        bt1.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt1);
        
        setLayout(new BorderLayout(10,10));
        add(sp,"Center");
        add(p1,"South");
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int id=Integer.parseInt(tf1.getText());
            try
            {
                ConnectionClass obj1=new ConnectionClass();
                String q="delete from librarian where Lid='"+id+"'";
                int res=obj1.stm.executeUpdate(q);
                
                if(res==1)
                {
                    JOptionPane.showMessageDialog(null, "your data successfully Deleted");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "did't delete sorry !!!!");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
    }
    public static void main(String[] args) 
    {
        new DeleteLibrarian().setVisible(true);
    }
}