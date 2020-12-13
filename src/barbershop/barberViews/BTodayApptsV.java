/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberViews;

import barbershop.barberControllers.BTodayApptsC;
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
public class BTodayApptsV extends JFrame {
    
    BTodayApptsC bTodayApptsC;
    
    public BTodayApptsV() {
        this.bTodayApptsC = new BTodayApptsC(this);
     
        setAttributes();
        components();
        validation();
    }
    
//    SET ATTRIBUTES AND DEFINE FRAME
    public void setAttributes() {
        this.setVisible(true);
        this.setSize(500, 500);
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
        prevB.addActionListener(bTodayApptsC);
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
        logOutB.addActionListener(bTodayApptsC);
        logOutB.setActionCommand("Log Out");
        topPanel.add(logOutB);
        // CAN'T GET BUTTON TO FIT ICON SIZE
        
        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        
        JLabel yourBookings = new JLabel("Today's Appointments");
        Dimension d = new Dimension(450, 50);
        yourBookings.setPreferredSize(d);
        yourBookings.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(yourBookings);
        
        // TEMP IMAGE OF TABLE UNTIL I CAN DISPLAY FROM DATABASE
        ImageIcon bookingsIcon = new ImageIcon(getClass().getResource("/barbershop/images/today_appt.jpg"));
        Image bookingsSize = bookingsIcon.getImage().getScaledInstance(400, 150, Image.SCALE_SMOOTH);
        ImageIcon bookingsIconSized = new ImageIcon(bookingsSize);
        JLabel bookingsTable = new JLabel(bookingsIconSized);
        centerPanel.add(bookingsTable);
        
//        QUICK AND HIGHLY VISIBLE BUTTON TO RETURN USER TO HOME SCREEN
        JButton retHomeB = new JButton("Return Home");
        retHomeB.addActionListener(bTodayApptsC);
        retHomeB.setActionCommand("Return Home");
        centerPanel.add(retHomeB); 
    }
     
//    VALIDATE AND REPAINT FRAME
    public void validation() {
        this.validate();
        this.repaint();     
    }
        
}
