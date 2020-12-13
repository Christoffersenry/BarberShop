/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberViews;

import barbershop.barberControllers.BHomeC;
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
public class BHomeV extends JFrame {
    
    BHomeC bHomeC;
    
    public BHomeV() {
        
        bHomeC = new BHomeC(this);
        
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
        logOutB.addActionListener(bHomeC);
        logOutB.setActionCommand("Log Out");
        topPanel.add(logOutB);
        // CAN'T GET BUTTON TO FIT ICON SIZE
        
        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        
        JLabel welcome = new JLabel("Welcome, Barber!");
        Dimension d = new Dimension(450, 50);
        welcome.setPreferredSize(d);
        welcome.setHorizontalAlignment(JLabel.CENTER);        
//        ADD CODE TO GET FIRST NAME FROM DATABASE TO DISPLAY IN WELCOME
        centerPanel.add(welcome);
        
        ImageIcon upAppts = new ImageIcon(getClass().getResource("/barbershop/images/appointments.jpg"));
        Image upApptsSize = upAppts.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon upApptsIconSized = new ImageIcon(upApptsSize);
        JButton upApptsLink = new JButton("Upcoming Appointments"); 
        upApptsLink.setIcon(upApptsIconSized);
        upApptsLink.setHorizontalTextPosition(JButton.CENTER);
        upApptsLink.setVerticalTextPosition(JButton.BOTTOM);
        upApptsLink.setActionCommand("Upcoming Appointments");
        upApptsLink.addActionListener(bHomeC);
        centerPanel.add(upApptsLink);
        
        ImageIcon manAvail = new ImageIcon(getClass().getResource("/barbershop/images/manage_availability.png"));
        Image manAvailSize = manAvail.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon manAvailIconSized = new ImageIcon(manAvailSize);
        JButton manAvailLink = new JButton("Manage Availability"); 
        manAvailLink.setIcon(manAvailIconSized);
        manAvailLink.setHorizontalTextPosition(JButton.CENTER);
        manAvailLink.setVerticalTextPosition(JButton.BOTTOM);
        manAvailLink.setActionCommand("Manage Availability");
        manAvailLink.addActionListener(bHomeC);
        centerPanel.add(manAvailLink);
        
        ImageIcon todAppts = new ImageIcon(getClass().getResource("/barbershop/images/today_appointments.png"));
        Image todApptsSize = todAppts.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon todApptsIconSized = new ImageIcon(todApptsSize);
        JButton todApptsLink = new JButton("Today's Appointments"); 
        todApptsLink.setIcon(todApptsIconSized);
        todApptsLink.setHorizontalTextPosition(JButton.CENTER);
        todApptsLink.setVerticalTextPosition(JButton.BOTTOM);
        todApptsLink.setActionCommand("Today's Appointments");
        todApptsLink.addActionListener(bHomeC);
        centerPanel.add(todApptsLink);
    }
        
//     VALIDATE AND REPAINT FRAME
    public void validation() {
        this.validate();
        this.repaint();
    }
        
}
