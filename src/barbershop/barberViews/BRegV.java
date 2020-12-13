/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberViews;

import barbershop.barberControllers.BRegC;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rcvb8
 */
public class BRegV extends JFrame {
    
    BRegC bRegC;
    
    JTextField userFName;
    JTextField userLName;
    JTextField userEmail;
    JTextField userPass;
    JTextField userConf;
    JTextField userPhone;
    JTextField userLocation;
    JLabel invalidFName;
    JLabel invalidLName;
    JLabel invalidEmail;
    JLabel userExist;
    JLabel invalidPassword;
    JLabel invalidConfirmPass;
    JLabel invalidPhone;
    JLabel invalidLocation;
    
//    CONSTRUCTOR TO INSTANTIATE CONNECT REGISTRATON VIEW TO REGISTRATION CONTROLLER
    public BRegV() {        
        this.bRegC = new BRegC(this);
        
        setAttributes();
        components();
        validation();        
    }
    
//        SET ATTRIBUTES AND DEFINE FRAME
        private void setAttributes() {
        this.setVisible(true);
        this.setSize(1000, 800);
        this.setTitle("cuttco.com");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
        
//         ORGANISE AND BUILD COMPONENTS
    private void components() {
        BorderLayout bLay = new BorderLayout();
        this.setLayout(bLay);
//        BORDER LAYOUT ISN'T WORKING. SECTIONS OVERLAP. TEST WITH BACKGROUND COLOR.
        
        JPanel topPanel = new JPanel();
        this.add(topPanel, BorderLayout.NORTH);
        
//        PREVIOUS BUTTON TO RETURN TO LOG IN SCREEN
        ImageIcon prevIcon = new ImageIcon(getClass().getResource("/barbershop/images/previous.png"));
        Image prevSize = prevIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon prevIconSized = new ImageIcon(prevSize);
        JButton prevB = new JButton(prevIconSized);
        prevB.addActionListener(bRegC);
        prevB.setActionCommand("Previous");
        topPanel.add(prevB);
        // CAN'T GET BUTTON TO FIT ICON SIZE
        
        JLabel brand = new JLabel("Cutt Co.");
        topPanel.add(brand);
        
//        CREATE CENTER PANEL AND ORGANISE COMPONENTS IN GRID LAYOUT
        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        GridLayout gLay = new GridLayout(15, 1);
        centerPanel.setLayout(gLay);
        
        JPanel gridPanel1 = new JPanel();
        centerPanel.add(gridPanel1);
        JLabel bReg = new JLabel("Barber Registration");
        Dimension d = new Dimension(450, 50);
        bReg.setPreferredSize(d);
        bReg.setHorizontalAlignment(JLabel.CENTER);
        gridPanel1.add(bReg);
        
//        HIDDEN INVALID MESSAGE FOR FIRST NAME INPUT
        JPanel gridPanel2 = new JPanel();
        centerPanel.add(gridPanel2);
        invalidFName = new JLabel("Only upper and lowercase letters allowed or field was left blank.");
        invalidFName.setForeground(Color.red);
        invalidFName.setVisible(false);
        gridPanel2.add(invalidFName);
        
        JPanel gridPanel3 = new JPanel();
        centerPanel.add(gridPanel3);
        JLabel fName = new JLabel("First Name :");
        gridPanel3.add(fName);
        userFName = new JTextField(20);
        gridPanel3.add(userFName);
        
//        HIDDEN INVALID MESSAGE FOR LAST NAME INPUT
        JPanel gridPanel4 = new JPanel();
        centerPanel.add(gridPanel4);
        invalidLName = new JLabel("Only upper and lowercase letters allowed or field was left blank.");
        invalidLName.setForeground(Color.red);
        invalidLName.setVisible(false);
        gridPanel4.add(invalidLName);
         
         JPanel gridPanel5 = new JPanel();
        centerPanel.add(gridPanel5);
         JLabel lName = new JLabel("Last Name :");
        gridPanel5.add(lName);
        userLName = new JTextField(20);
        gridPanel5.add(userLName);
        
//        HIDDEN INVALID MESSAGES FOR EMAIL INPUT
        JPanel gridPanel6 = new JPanel();
        centerPanel.add(gridPanel6);
        invalidEmail = new JLabel("Input doesn't match email format (eg. johndoe@gmail.com) or field was left blank.");
        invalidEmail.setForeground(Color.red);
        invalidEmail.setVisible(false);
        userExist = new JLabel("A user already exists with this email. Choose another email.");
        userExist.setForeground(Color.red);
        userExist.setVisible(false);
        gridPanel6.add(invalidEmail);
        gridPanel6.add(userExist);
        
        JPanel gridPanel7 = new JPanel();
        centerPanel.add(gridPanel7);
        JLabel email = new JLabel("Email :");
        gridPanel7.add(email);
        userEmail = new JTextField(30);
        gridPanel7.add(userEmail);
        
//        HIDDEN INVALID MESSAGE FOR PASSWORD INPUT
        JPanel gridPanel8 = new JPanel();
        centerPanel.add(gridPanel8);
        invalidPassword = new JLabel("Password can't be blank and must include one capital letter,\n"
                +  " one lowercase letter, one number, and be minimum 8 characters and max 15.");
        invalidPassword.setForeground(Color.red);
        invalidPassword.setVisible(false);
        gridPanel8.add(invalidPassword);
        
        JPanel gridPanel9 = new JPanel();
        centerPanel.add(gridPanel9);
        JLabel password = new JLabel("Password :");
        gridPanel9.add(password);
        userPass = new JTextField(15);
        gridPanel9.add(userPass);
        
//        HIDDEN INVALID MESSAGE FOR CONFIRMING PASSWORD
        JPanel gridPanel10 = new JPanel();
        centerPanel.add(gridPanel10);
        invalidConfirmPass = new JLabel("Password doesn't match or field was left blank.");
        invalidConfirmPass.setForeground(Color.red);
        invalidConfirmPass.setVisible(false);
        gridPanel10.add(invalidConfirmPass); 
        
        JPanel gridPanel11 = new JPanel();
        centerPanel.add(gridPanel11);
        JLabel passConf = new JLabel("Confirm :");
        gridPanel11.add(passConf);
        userConf = new JTextField(15);
        gridPanel11.add(userConf);
        
//        HIDDEN INVALID MESSAGE FOR PHONE INPUT
        JPanel gridPanel12 = new JPanel();
        centerPanel.add(gridPanel12);
        invalidPhone = new JLabel("Only 10 digit numbers (0-9) accepted or field was left blank.");
        invalidPhone.setForeground(Color.red);
        invalidPhone.setVisible(false);
        gridPanel12.add(invalidPhone);
        
        JPanel gridPanel13 = new JPanel();
        centerPanel.add(gridPanel13);
        JLabel phone = new JLabel("Phone :");
        gridPanel13.add(phone);
        userPhone = new JTextField(10);
        gridPanel13.add(userPhone);
        
        JPanel gridPanel14 = new JPanel();
        centerPanel.add(gridPanel14);
        JLabel location = new JLabel("Location :");
        gridPanel14.add(location);
        userLocation = new JTextField(40);
        gridPanel14.add(userLocation);
        
//        REGISTER BUTTON WITH ACTION LISTENER
        JPanel gridPanel15 = new JPanel();
        centerPanel.add(gridPanel15);
        JButton register = new JButton("Register");
        gridPanel15.add(register);
        register.addActionListener(bRegC);
        register.setActionCommand("Register");
    }
        
//       VALIDATE & REPAINT FRAME
    private void validation() {
        this.validate();
        this.repaint();
    }
    
//    METHOD TO SHOW SUCCESSFUL REGISTRATION
    public void showSuccessReg() {
         JOptionPane.showMessageDialog(this, "Your registration was successful." , "Registration Complete", PLAIN_MESSAGE, null);
     }
    
//    METHOD TO SHOW REGISTRATION FAILED
    public void showFailedReg() {
         JOptionPane.showMessageDialog(this, "Your registration is incomplete. Some fields are not valid. Correct before proceeding." , "REGISTRATION INCOMPLETE", WARNING_MESSAGE, null);
     }
    
//    METHODS TO GET USER INPUT SO CONTROLLER CAN ACCESS THE INFO
    public String getFName() {
        return userFName.getText();
    }
    
    public String getLName() {
        return userLName.getText();
    }
    
    public String getEmail() {
        return userEmail.getText();
    }
    
    public String getPassword() {
        return userPass.getText();
    }
    
    public String getConfirmPass() {
        return userConf.getText();
    }
    
    public String getPhone() {
        return userPhone.getText();
    }
//    WATCH !!!!
    public String getLocation(BRegV bRegV) {
        return userLocation.getText();
    }
    
//    METHODS FOR THE CONTROLLER TO SHOW INVALID MESSAGES FOR EACH USER INPUT
    public void getInvalMessFName() {
        invalidFName.setVisible(true);
    }
    
    public void getInvalMessLName() {
        invalidLName.setVisible(true);
    }
    
    public void getInvalMessEmail() {
        invalidEmail.setVisible(true);
    }
    
    public void getUserExist() {
        userExist.setVisible(true);
    }
    
    public void getInvalMessPass() {
        invalidPassword.setVisible(true);
    }
    
    public void getInvalMessConfPass() {
        invalidConfirmPass.setVisible(true);
    }
    
    public void getInvalMessPhone() {
        invalidPhone.setVisible(true);
    }
    
//    METHODS FOR THE CONTROLLER TO HIDE INVALID MESSAGES FOR EACH USER INPUT
    public void hideInvalMessFName() {
        invalidFName.setVisible(false);
    }
    
    public void hideInvalMessLName() {
        invalidLName.setVisible(false);
    }
    
    public void hideInvalMessEmail() {
        invalidEmail.setVisible(false);
    }
    
    public void hideUserExist() {
        userExist.setVisible(false);
    }
    
    public void hideInvalMessPass() {
        invalidPassword.setVisible(false);
    }
    
    public void hideInvalMessConfPass() {
        invalidConfirmPass.setVisible(false);
    }
    
    public void hideInvalMessPhone() {
        invalidPhone.setVisible(false);
    }
    
}
