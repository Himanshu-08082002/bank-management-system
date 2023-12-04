
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,300,30);
        add(l1);
        
        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,120,250,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.white);
        r1.setBounds(100, 160, 180, 30);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.white);
        r2.setBounds(380, 160, 180, 30);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.white);
        r3.setBounds(100, 200, 200, 30);
        add(r3);
        
        r4 = new JRadioButton("Reccuring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.white);
        r4.setBounds(380, 200, 250, 30);
        add(r4);
        
        ButtonGroup grouptype = new ButtonGroup();
        grouptype.add(r1);
        grouptype.add(r2);
        grouptype.add(r3);
        grouptype.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100,245,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-2020");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(380,245,300,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16-Digits Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 10));
        carddetail.setBounds(100,268,170,20);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,295,200,30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pnumber.setBounds(380,295,200,30);
        add(pnumber);
        
        JLabel pindetail = new JLabel("Your 4-Digits Password");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 10));
        pindetail.setBounds(100,318,170,20);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100,345,200,30);
        add(services);
        
        c1 = new JCheckBox("ATM");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        c1.setBounds(100,380,150,25);
        add(c1);
        
        c2 = new JCheckBox("Net Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        c2.setBounds(380,380,150,25);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        c3.setBounds(100,405,150,25);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        c4.setBounds(380,405,170,25);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        c5.setBounds(100,430,150,25);
        add(c5);
        
        c6 = new JCheckBox("E Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 14));
        c6.setBounds(380,430,150,25);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to yhe best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 10));
        c7.setBounds(100,490,450,20);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raelway", Font.BOLD,14));
        submit.setBounds(250,540,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raelway", Font.BOLD,14));
        cancel.setBounds(400,540,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
                
        getContentPane().setBackground(Color.white);
        setSize(800,650);
        setLocation(220, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit) {
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType = "Current account";
            }else if(r4.isSelected()){
                accountType = "Reccuring Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber = "" +Math.abs((random.nextLong() % 90000000L) + 5089506000000000L);
            String pinnumber = "" +Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM";
            }else if(c2.isSelected()){
                facility = facility +" Net Banking";
            }else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility + " Email & SMS Alerts";
            }else if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }else if(c6.isSelected()){
                facility = facility + " E Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+ cardnumber + "\n Pin: "+ pinnumber);
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            } catch(Exception e){
                System.out.println(e);
            }
            
        }else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new SignupThree("");
    }
}
