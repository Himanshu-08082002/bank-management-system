
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastCash, miniStatement, changePin, balanceEnquiry, back;
    String pinnumber;
    FastCash(String pinnumber){
        setLayout(null);
        
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(185, 220, 700, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(140,322,130,22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(326,322,130,22);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(140,350,130,22);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(326,350,130,22);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        changePin = new JButton("Rs 5000");
        changePin.setBounds(140,378,130,22);
        changePin.addActionListener(this);
        image.add(changePin);
        
        balanceEnquiry = new JButton("Rs 10000");
        balanceEnquiry.setBounds(326,378,130,22);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        back = new JButton("Back");
        back.setBounds(326,406,130,22);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800,700);
        setLocation(250,10);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); // Rs 100
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    
                    if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    Date date = new Date();
                    String query = "insert into bank values ('"+pinnumber+"','"+date+"', 'Withdrawl', '"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Sucessfully");
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]) {
       new FastCash("");
    }
}
