
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField, aadharTextField; 
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, education, occupation, income;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle ("NEW ACCOUNT APPLICATION FORM - PAGE 2:");
        
   
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raelway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 55, 300, 30);
        add(additionalDetails);
        
        JLabel lReligion = new JLabel("Religion:");
        lReligion.setFont(new Font("Raelway", Font.BOLD, 20));
        lReligion.setBounds(100, 110, 100, 30);
        add(lReligion);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 110, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel lCategory = new JLabel("Category:");
        lCategory.setFont(new Font("Raelway", Font.BOLD, 20));
        lCategory.setBounds(100, 150, 200, 30);
        add(lCategory);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 150, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel lIncome = new JLabel("Income:");
        lIncome.setFont(new Font("Raelway", Font.BOLD, 20));
        lIncome.setBounds(100, 190, 200, 30);
        add(lIncome);
        
        String incomeCategory[] = {"Null", "< 2,50,000", "< 5,50,000", "< 10,00,000", "upto 20,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 190, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel lEducation = new JLabel("Educational");
        lEducation.setFont(new Font("Raelway", Font.BOLD, 20));
        lEducation.setBounds(100, 230, 200, 30);
        add(lEducation);
        
        JLabel lOualification = new JLabel("Qualification:");
        lOualification.setFont(new Font("Raelway", Font.BOLD, 20));
        lOualification.setBounds(100, 255, 200, 30);
        add(lOualification);
        
        String educationValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 245, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel lOccupation = new JLabel("Occupation:");
        lOccupation.setFont(new Font("Raelway", Font.BOLD, 20));
        lOccupation.setBounds(100, 310, 200, 30);
        add(lOccupation);
        
        String occupationValues[] = {"Salaried", "Self-Employe", "Bussiness", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 310, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raelway", Font.BOLD, 20));
        pan.setBounds(100, 350, 200, 30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 350, 400, 30);
        add(panTextField);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raelway", Font.BOLD, 20));
        aadhar.setBounds(100, 390, 200, 30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 390, 400, 30);
        add(aadharTextField);
        
        JLabel lSeniorCitizen = new JLabel("Senior Citizen:");
        lSeniorCitizen.setFont(new Font("Raelway", Font.BOLD, 20));
        lSeniorCitizen.setBounds(100, 430, 200, 30);
        add(lSeniorCitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 430, 60,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 430, 120,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sCitizen = new ButtonGroup();
        sCitizen.add(syes);
        sCitizen.add(sno);
        
        
        JLabel lExistingAccount = new JLabel("Existing Account:");
        lExistingAccount.setFont(new Font("Raelway", Font.BOLD, 20));
        lExistingAccount.setBounds(100, 470, 200, 30);
        add(lExistingAccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 470, 60,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 470, 120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup eAccount = new ButtonGroup();
        eAccount.add(eyes);
        eAccount.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 510, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 650);
        setLocation(220, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String existedaccount = null;
        if(eyes.isSelected()){
            existedaccount = "Yes";
        }else if(eno.isSelected()){
            existedaccount = "No";
        }
        
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        
        
        try{
           
            
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+existedaccount+"','"+span+"','"+saadhar+"')";
            c.s.executeUpdate(query); 
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
            
        }catch(Exception e){
            System.out.println(e);
        }

    }
    
    public static void main(String args[]) {
       new SignupTwo("");
    }
}
