/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberViews;

import barbershop.barberControllers.BLogC;
import barbershop.index.IndexCon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author rcvb8
 */
public class BLogV extends JFrame {
    
    JTextField userEmail;
    JTextField userPass;
    JLabel invalid;
    JLabel register;

    BLogC bLogC;
    IndexCon indexCon;

//    CONSTRUCTOR TO INSTANTION AND CONNECT LOGIN VIEW TO THE LOGIN CONTROLLER
    public BLogV() {        
        this.bLogC = new BLogC(this);

        setAttributes();
        components();
        validation();
    }

//    SET ATTRIBUTES AND DEFINE FRAME
    private void setAttributes() {
        this.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("cuttco.com");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//     ORGANISE AND BUILD COMPONENTS
    private void components() {
        BorderLayout bLay = new BorderLayout();
        this.setLayout(bLay);

        JPanel topPanel = new JPanel();
        this.add(topPanel, BorderLayout.NORTH);

//        PREVIOUS BUTTON TO RETURN TO INDEX SCREEN
        ImageIcon prevIcon = new ImageIcon(getClass().getResource("/barbershop/images/previous.png"));
        Image prevSize = prevIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon prevIconSized = new ImageIcon(prevSize);
        JButton prevB = new JButton(prevIconSized);
        prevB.addActionListener(bLogC);
        prevB.setActionCommand("Previous");
        topPanel.add(prevB);
        // CAN'T GET BUTTON TO FIT ICON SIZE

        JLabel brand = new JLabel("Cutt Co.");
        topPanel.add(brand);

        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        JLabel bLogin = new JLabel("Barber Login");
        Dimension dBanner = new Dimension(450, 50);
        bLogin.setPreferredSize(dBanner);
        bLogin.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(bLogin);        
        
//        HIDDEN INVALID MESSAGE FOR INVALID CREDENTIALS
        invalid = new JLabel("Credentials are invalid. Try again or register below.");
        Dimension dInvalid = new Dimension(450, 50);
        invalid.setPreferredSize(dInvalid);
        invalid.setForeground(Color.red);
        invalid.setVisible(false);
        centerPanel.add(invalid);

        // FIX SPACING ON EMAIL 
        JLabel email = new JLabel("         Email :");
        Dimension dLabel = new Dimension(450, 20);
        email.setPreferredSize(dLabel);
        centerPanel.add(email);

        userEmail = new JTextField(30);
        Dimension dTextField = new Dimension(300, 40);
        userEmail.setPreferredSize(dTextField);
        centerPanel.add(userEmail);

        JLabel password = new JLabel("Password :");
        password.setPreferredSize(dLabel);
        centerPanel.add(password);

        userPass = new JTextField(15);
        userPass.setPreferredSize(dTextField);
        centerPanel.add(userPass);
        
//         LOG IN BUTTON WITH ACTION LISTENER
        JButton login = new JButton("Login");
        login.setPreferredSize(dBanner);
        login.addActionListener(bLogC);
        login.setActionCommand("Login");
        centerPanel.add(login);
        
//         ADDS LINK TO CUSTOMER REGISTRATION PAGE
        register = new JLabel("Register Here");
        register.setForeground(Color.BLUE);
        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        register.setPreferredSize(dBanner);
        register.addMouseListener(bLogC);
        centerPanel.add(register);
    }

    // VALIDATE & REPAINT FRAME
    private void validation() {
        this.validate();
        this.repaint();
    }

//    METHODS FOR LOGIN CONTROLLER TO ACCESS USER INPUT
    public String getUserEmail() {
        return userEmail.getText();
    }

    public String getUserPassword() {
        return userPass.getText();
    }
    
//    METHOD FOR LOGIN CONTROLLER TO SHOW INVALID MESSAGE TO USER
    public void getInvalidMessage() {
        invalid.setVisible(true);
    }
    
//    METHOD FOR LOGIN CONTROLLER TO SHOW SUCCESSFUL LOGIN
    public void showConfirmation() {
         JOptionPane.showMessageDialog(this, "Welcome!" , "Login Successful", PLAIN_MESSAGE, null);
     }

}
