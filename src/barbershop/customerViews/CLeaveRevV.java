/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerViews;

import barbershop.customerControllers.CLeaveRevC;
import com.placeholder.PlaceHolder;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author rcvb8
 */
public class CLeaveRevV extends JFrame {
    
    CLeaveRevC cLeaveRevC;
    
    PlaceHolder placeHolder;
    JTextArea custRev;
    JDateChooser apptChooser;
    JTextField location;
    JTextField userEmail;
    JTextField barbName;
    JTextField userFullName;
    
    
    public CLeaveRevV() {
        this.cLeaveRevC = new CLeaveRevC(this);
        
        setAttributes();
        components();
        validation();
    }
    
//    SET ATTRIBUTES AND DEFINE FRAME
    public void setAttributes() {
        this.setVisible(true);
        this.setSize(580, 450);
        this.setTitle("cuttco.com");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
     
//    ORGANISE AND BUILD COMPONENTS
    public void components() {
        BorderLayout bLay = new BorderLayout();
        this.setLayout(bLay);
        
        JPanel topPanel = new JPanel();
        this.add(topPanel, BorderLayout.NORTH);
        
        
//        PREVIOUS BUTTON TO RETURN TO HOME SCREEN
        ImageIcon prevIcon = new ImageIcon(getClass().getResource("/barbershop/images/previous.png"));
        Image prevSize = prevIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon prevIconSized = new ImageIcon(prevSize);
        JButton prevB = new JButton(prevIconSized);
        prevB.addActionListener(cLeaveRevC);
        prevB.setActionCommand("Previous");
        topPanel.add(prevB);
        // CAN'T GET BUTTON TO FIT ICON SIZE
        
        JLabel brand = new JLabel("Cutt Co.");
        topPanel.add(brand);
        
//        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        ImageIcon logOutIcon = new ImageIcon(getClass().getResource("/barbershop/images/logout.png"));
        Image logOutSize = logOutIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon logOutIconSized = new ImageIcon(logOutSize);
        JButton logOutB = new JButton(logOutIconSized);
        logOutB.addActionListener(cLeaveRevC);
        logOutB.setActionCommand("Log Out");
        topPanel.add(logOutB);
        // CAN'T GET BUTTON TO FIT ICON SIZE
        
        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        GridLayout gLay = new GridLayout(3, 1);
        centerPanel.setLayout(gLay);
        
        JPanel gP1 = new JPanel();
        centerPanel.add(gP1);
        JLabel leaveRev = new JLabel("Feedback Form");
        Dimension d = new Dimension(450, 50);
        leaveRev.setPreferredSize(d);
        leaveRev.setHorizontalAlignment(JLabel.CENTER);
        gP1.add(leaveRev);
        
        JPanel gP2 = new JPanel(); 
        centerPanel.add(gP2);
         userFullName = new JTextField(25);
         placeHolder = new PlaceHolder(userFullName, "Your Full Name");
         gP2.add(userFullName); 
         
         barbName = new JTextField(25);
         placeHolder = new PlaceHolder(barbName, "Barber Name");
         gP2.add(barbName);
         
        centerPanel.add(gP2);
         userEmail = new JTextField(25);
         placeHolder = new PlaceHolder(userEmail, "Your Email");
         gP2.add(userEmail);
        
        location = new JTextField(25);
        placeHolder = new PlaceHolder(location, "Barber Location");
         gP2.add(location);
         
         centerPanel.add(gP2);
         JLabel satisfied = new JLabel("Satisfied?");
        gP2.add(satisfied);
        JRadioButton yes = new JRadioButton("Y");
        yes.setSelected(false);
        gP2.add(yes);
        JRadioButton no = new JRadioButton("N");
        yes.setSelected(false);
        gP2.add(no);
        ButtonGroup satGroup = new ButtonGroup();
        satGroup.add(yes);
        satGroup.add(no);
        
        JLabel apptDate = new JLabel("Appt. Date");
        gP2.add(apptDate); 
        apptChooser = new JDateChooser();
        gP2.add(apptChooser);
        
        JPanel gP3 = new JPanel();
        custRev = new JTextArea(5, 50);
        custRev.setWrapStyleWord(true);
        custRev.setLineWrap(true);
        placeHolder = new PlaceHolder(custRev, "Tell us why...");
        gP3.add(custRev);
        JScrollPane custRevScroll = new JScrollPane(gP3);
        centerPanel.add(custRevScroll);
        
         JPanel bottomPanel = new JPanel();
         this.add(bottomPanel, BorderLayout.SOUTH);
        JButton revSubmit = new JButton("Submit");
        bottomPanel.add(revSubmit);
        revSubmit.setActionCommand("Submit");
        revSubmit.addActionListener(cLeaveRevC);
    }
       
//    VALIDATE AND REPAINT FRAME
     public void validation() {   
        this.validate();
        this.repaint();
     }
     
//     JTextField location;
//    JTextField userEmail;
//    JTextField barbName;
//    JTextField userFullName;
     
     
     public String getUserFullName(String userFName) {
         userFName = userFullName.getText();
         return userFName;
     }
     
     public String getBarberName(String bName) {
         bName = barbName.getText();
         return bName;
     }
     
     public String getUserEmail(String email) {
         email = userEmail.getText();
         return email;
     }
     
     public String getUserLoc(String loc) {
         loc = location.getText();
         return loc;
     }     
     
     // CHECK WHAT DATA TYPE IS STORED FOR RADIO BUTTON
//     CAN YOU RETRIVE VALUES FROM RADIO GROUP???
     public void getUserSatResult() {
         
     }     
     
     public Date getApptDate(Date apptDate) {
         apptDate = apptChooser.getDate();
         return apptDate;
     }
     
     public String getComment(String comment) {
         comment = custRev.getText();
         return comment;
     }
     
     public void getSubSuccessMess() {
         JOptionPane.showMessageDialog(this, "We truly appreciate your feedback. Thank you for your time!", "Submission Recorded", PLAIN_MESSAGE);
     }
     
     public void getSubFailMess() {
         JOptionPane.showMessageDialog(this, "It appears some fields were left blank or the input doesn't match the criteria. Please correct and try again.", "Form Incomplete", WARNING_MESSAGE);
     }
          
    }
