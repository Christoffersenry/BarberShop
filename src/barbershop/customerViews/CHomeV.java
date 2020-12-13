/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerViews;

import barbershop.customerControllers.CHomeC;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rcvb8
 */
public class CHomeV extends JFrame {
    
    CHomeC cHomeC;
    
    public CHomeV() {
        cHomeC = new CHomeC(this);
        
     setAttributes();
     components();
     validation();
    }
       
//    SET ATTRIBUTES AND DEFINE FRAME
    public void setAttributes() {
         this.setVisible(true);
        this.setSize(600, 400);
        this.setTitle("cuttco.com");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
//    ORGANISE AND BUILD COMPONENTS
    public void components() {
        BorderLayout bLay = new BorderLayout();
        this.setLayout(bLay);
        
        JPanel topPanel = new JPanel();
        this.add(topPanel, BorderLayout.NORTH);
        JLabel brand = new JLabel("Cutt Co.");
        topPanel.add(brand);
        
//        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        ImageIcon logOutIcon = new ImageIcon(getClass().getResource("/barbershop/images/logout.png"));
        Image logOutSize = logOutIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon logOutIconSized = new ImageIcon(logOutSize);
        JButton logOutB = new JButton(logOutIconSized);
        logOutB.addActionListener(cHomeC);
        logOutB.setActionCommand("Log Out");
        topPanel.add(logOutB);
        // CAN'T GET BUTTON TO FIT ICON SIZE
        
        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        
        JLabel welcome = new JLabel("Welcome, Customer!");
        Dimension d = new Dimension(450, 50);
        welcome.setPreferredSize(d);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        
//        ADD CODE TO GET FIRST NAME FROM DATABASE TO DISPLAY IN WELCOME
        centerPanel.add(welcome);
        
        ImageIcon findBarber = new ImageIcon(getClass().getResource("/barbershop/images/find_barber.png"));
        Image findBSize = findBarber.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon findBIconSized = new ImageIcon(findBSize);
        JButton findBLink = new JButton("Find a Barber"); 
        findBLink.setIcon(findBIconSized);
        findBLink.setHorizontalTextPosition(JButton.CENTER);
        findBLink.setVerticalTextPosition(JButton.BOTTOM);
        findBLink.setActionCommand("Find a Barber");
        findBLink.addActionListener(cHomeC);
        centerPanel.add(findBLink);
        
        ImageIcon bookings = new ImageIcon(getClass().getResource("/barbershop/images/view_bookings.png"));
        Image bookSize = bookings.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon bookIconSized = new ImageIcon(bookSize);
        JButton bookLink = new JButton("View Your Bookings"); 
        bookLink.setIcon(bookIconSized);
        bookLink.setHorizontalTextPosition(JButton.CENTER);
        bookLink.setVerticalTextPosition(JButton.BOTTOM);
        bookLink.setActionCommand("View Your Bookings");
        bookLink.addActionListener(cHomeC);
        centerPanel.add(bookLink);
        
        ImageIcon review = new ImageIcon(getClass().getResource("/barbershop/images/leave_review.png"));
        Image revSize = review.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon revIconSized = new ImageIcon(revSize);
        JButton revLink = new JButton("Leave a Review"); 
        revLink.setIcon(revIconSized);
        revLink.setHorizontalTextPosition(JButton.CENTER);
        revLink.setVerticalTextPosition(JButton.BOTTOM);
        revLink.setActionCommand("Leave a Review");
        revLink.addActionListener(cHomeC);
        centerPanel.add(revLink);
    }
        
//     VALIDATE AND REPAINT FRAME
    public void validation() {
        this.validate();
        this.repaint();
    }
        
    }
