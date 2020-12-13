/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerViews;

import barbershop.customerControllers.CBarbSearchC;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rcvb8
 */
public class CBarbSearchV extends JFrame {
    
    CBarbSearchC cBarbSearchC;
    
    public CBarbSearchV() {
        this.cBarbSearchC = new CBarbSearchC(this);
        
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
        prevB.addActionListener(cBarbSearchC);
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
        logOutB.addActionListener(cBarbSearchC);
        logOutB.setActionCommand("Log Out");
        topPanel.add(logOutB);
        // CAN'T GET BUTTON TO FIT ICON SIZE
        
        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        
        JLabel barbSearch = new JLabel("Barber Search");
        Dimension d = new Dimension(450, 50);
        barbSearch.setPreferredSize(d);
        barbSearch.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(barbSearch);
        
        JLabel byLoc = new JLabel("By location :");
        centerPanel.add(byLoc);
        
        JLabel byName = new JLabel("By name :");
        centerPanel.add(byName);
        
        String[] locations = {"-Select-","123 Random Ave.", "234 Something St.", "345 Idunno Pl."};
        JComboBox cBoxLoc = new JComboBox(locations);
        centerPanel.add(cBoxLoc);
        
        String[] barbNames = {"-Select-","John Doe", "Jonathan Dobe", "Johnny Doberman"};
        JComboBox cBoxNames = new JComboBox(barbNames);
        centerPanel.add(cBoxNames);        
        
        JButton checkAvail = new JButton("Check Availability");
        checkAvail.addActionListener(cBarbSearchC);
        checkAvail.setActionCommand("Check Availability");
        centerPanel.add(checkAvail);
    }
    
//    VALIDATE AND REPAINT FRAME
    public void validation() {
        this.validate();
        this.repaint();      
    }
    
}
