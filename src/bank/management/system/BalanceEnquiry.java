
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton back;
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        Conn c = new Conn();
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }    
        }catch (Exception e){
            System.out.println(e);
        } 
        
        JLabel text = new JLabel("Your Current account Balance is Rs "+ balance );
        text.setForeground(Color.white);
        text.setBounds(150,230,300,25);
        image.add(text);
        
        back = new JButton("BACK");
        back.setBounds(350,390,90,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(800,700);
        setLocation(250,5);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
   
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
