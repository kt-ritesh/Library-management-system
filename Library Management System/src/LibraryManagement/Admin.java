package LibraryManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JButton  bt1,bt2;
    JPanel p1,p2,p3;
    Font f,f1;
    JPasswordField pf;
    JTextField tf;
    
    Admin()
    {
        super("Admin Login Page");
        setLocation(450,400);
        setSize(500,200);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        l1=new JLabel("Admin Login");
        l2=new JLabel("Name");
        l3=new JLabel("Password");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);
        
        tf=new JTextField();
        pf=new JPasswordField();
        
        bt1=new JButton("Login");
        bt2=new JButton("Cancel");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        bt1.setFont(f1);
        bt2.setFont(f1);
        tf.setFont(f1);
        pf.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(3,2,10,10));
        p1.add(l2);
        p1.add(tf);
        p1.add(l3);
        p1.add(pf);
        p1.add(bt1);
        p1.add(bt2);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l1);
        p2.setBackground(Color.BLUE);
        
        setLayout(new BorderLayout(10,10));
        
        add(p1,"Center");
        add(p2,"North");
    }
    public void actionPerformed(ActionEvent e)
    {
        String name=tf.getText();
        String pass=pf.getText();
        
        if(e.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String s="select * from admin where username='"+name+"' and password='"+pass+"'";
                ResultSet rest=obj.stm.executeQuery(s);
                if(rest.next())
                {
                    new AdminSection().setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "your name or password are wrong");
                    this.setVisible(false);
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
        }            
    }
    public static void main(String[] args) 
    {
        new Admin().setVisible(true);
    }
}
