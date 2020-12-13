/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerViews;

import barbershop.customerControllers.CBarbAvailC;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author rcvb8
 */
public class CBarbAvailV extends JFrame {
    
    CBarbAvailC cBarbAvailC;
    
    public CBarbAvailV() {
        this.cBarbAvailC = new CBarbAvailC(this);
        
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
        
//        PREVIOUS BUTTON TO RETURN TO BARBER SEARCH
        ImageIcon prevIcon = new ImageIcon(getClass().getResource("/barbershop/images/previous.png"));
        Image prevSize = prevIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon prevIconSized = new ImageIcon(prevSize);
        JButton prevB = new JButton(prevIconSized);
        prevB.addActionListener(cBarbAvailC);
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
        logOutB.addActionListener(cBarbAvailC);
        logOutB.setActionCommand("Log Out");
        topPanel.add(logOutB);
        // CAN'T GET BUTTON TO FIT ICON SIZE
        
        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        
        JLabel barbSearch = new JLabel("Barber Availability");
        Dimension d = new Dimension(450, 50);
        barbSearch.setPreferredSize(d);
        barbSearch.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(barbSearch);
        
        JCalendar bAvail = new JCalendar();
        Dimension cal = new Dimension(400, 150);
        bAvail.setPreferredSize(cal);
        centerPanel.add(bAvail);
        
        JRadioButton slot1 = new JRadioButton("6:00 AM");        
        slot1.setSelected(true);
        centerPanel.add(slot1);
        
        JRadioButton slot3 = new JRadioButton("8:00 AM");
        centerPanel.add(slot3);
        
        JRadioButton slot5 = new JRadioButton("10:00 AM"); 
        centerPanel.add(slot5);
        
        JRadioButton slot9 = new JRadioButton("2:00 PM");
        centerPanel.add(slot9);
        
        ButtonGroup timeSlot = new ButtonGroup();
        timeSlot.add(slot1);
        timeSlot.add(slot3);
        timeSlot.add(slot5);
        timeSlot.add(slot9);
        
        JButton bookAppt = new JButton("Book Appointment");
        bookAppt.addActionListener(cBarbAvailC);
        bookAppt.setActionCommand("Book Appointment");
        centerPanel.add(bookAppt);
        
        // ADD BOOKING SUCCESSFUL MESSAGE WITH TWO BUTTONS TO RETURN HOME OR VIEW BOOKINGS
        // RECORD BOOKING INFO IN DATABASE
    }
    
//    VALIDATION AND REPAINT
    public void validation() {
        this.validate();
        this.repaint();        
    }
    
    public void getBookSuccessMess() {
        JOptionPane.showMessageDialog(this, "Your booking was successful. See you soon!", "Booking Created", PLAIN_MESSAGE);
    }
    
}
