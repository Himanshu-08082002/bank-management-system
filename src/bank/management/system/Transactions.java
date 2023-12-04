
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastCash, miniStatement, changePin, balanceEnquiry, exit;
    String pinnumber;
    Transactions(String pinnumber){
        setLayout(null);
        
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(185, 220, 700, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(140,322,130,22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(326,322,130,22);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(140,350,130,22);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(326,350,130,22);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        changePin = new JButton("Change PIN");
        changePin.setBounds(140,378,130,22);
        changePin.addActionListener(this);
        image.add(changePin);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(326,378,130,22);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(326,406,130,22);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(800,700);
        setLocation(250,10);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource() == changePin){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource() == miniStatement){
//            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }      
    }
    public static void main(String args[]) {
       new Transactions("");
    }
}
