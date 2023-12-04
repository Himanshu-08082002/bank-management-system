
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
        String pinnumber;
        JPasswordField pin, repin;  
        JButton back, change;
        
        
    PinChange(String pinnumber){       
        this.pinnumber = pinnumber;
        
        setLayout(null);        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD,  16));
        text.setBounds(220,220,200,30);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD,  14));
        pintext.setBounds(150,270,180,20);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(290,270,160,25);
        pin.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD,  14));
        repintext.setBounds(150,310,180,20);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(290,310,160,25);
        repin.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(350, 370, 100,25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(350, 400, 100,25);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(800,700);
        setLocation(250,5);
        setUndecorated(true);
        setVisible(true);
    }    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match!" );
                    return;
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN!" );
                    return;
                }
                
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN!" );
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber ='"+pinnumber+"'";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber ='"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed Successfully" );
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            } catch(Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new PinChange("");
    }
}
