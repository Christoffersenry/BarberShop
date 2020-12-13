/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberViews;

import barbershop.barberControllers.BAvailC;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rcvb8
 */
public class BAvailV extends JFrame {
    
    BAvailC bAvailC;
    BBooleanTableV bBoolTabV;
    
    JTable availTable;
    JDateChooser availDay;
    
    public BAvailV() {
        this.bAvailC = new BAvailC(this);
        
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

//        PREVIOUS BUTTON TO RETURN TO HOME SCREEN
        ImageIcon prevIcon = new ImageIcon(getClass().getResource("/barbershop/images/previous.png"));
        Image prevSize = prevIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon prevIconSized = new ImageIcon(prevSize);
        JButton prevB = new JButton(prevIconSized);
        prevB.addActionListener(bAvailC);
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
        logOutB.addActionListener(bAvailC);
        logOutB.setActionCommand("Log Out");
        topPanel.add(logOutB);
        // CAN'T GET BUTTON TO FIT ICON SIZE

        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        JLabel bLogin = new JLabel("Availability");
        Dimension dBanner = new Dimension(450, 50);
        bLogin.setPreferredSize(dBanner);
        bLogin.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(bLogin); 
        
//        DATE SELECTOR TO SHOW TIME SLOTS FOR SPECIFIC DATE
        availDay = new JDateChooser();
        availDay.setDateFormatString("dd/MM/yyyy");
        Dimension availDayD = new Dimension(200, 40);
        availDay.setPreferredSize(availDayD);
        centerPanel.add(availDay);
        
        JButton showTimeSlotsBtn = new JButton("Show Time Slots");
        showTimeSlotsBtn.addActionListener(bAvailC);
        showTimeSlotsBtn.setActionCommand("Show Time Slots");
        centerPanel.add(showTimeSlotsBtn);
        
//       CREATE AVAILABILITY TABLE IN CENTER PANEL
       availTable = new JTable(new BBooleanTableV());       
       JScrollPane myScrollPane = new JScrollPane(availTable);  
       availTable.setVisible(false);
       centerPanel.add(myScrollPane);
        
//        SAVE BUTTON WITH ACTION LISTENER
       JPanel bottomPanel = new JPanel();
       this.add(bottomPanel, BorderLayout.SOUTH);
        JButton save = new JButton("Save");
        save.setPreferredSize(dBanner);
        save.addActionListener(bAvailC);
        save.setActionCommand("Save");
        bottomPanel.add(save);
    }
    
    // VALIDATE & REPAINT FRAME
    private void validation() {
        this.validate();
        this.repaint();
    }
    
//    METHOD TO RETRIEVE DATE SELECTED BY USER
    public Date getDateSelected() {
        Date dateSelected = availDay.getDate();
        return dateSelected;
    }
    
//    METHOD TO SHOW AVAILABILITY TABLE
    public void showAvailTable() {
        if (availDay.getDate() != null) {
        availTable.setVisible(true);
        } 
        else {
            showNoDateMess();
        };
    }
            
//    METHOD TO HIDE AVAILABILITY TABLE
    public void hideAvailTable() {
        availTable.setVisible(false);
    }
    
//    METHOD FOR CONTROLLER TO SHOW CHANGES SAVED MESSAGE POP UP
    public void getSaveConfMess() {
        JOptionPane.showMessageDialog(this, "Your changes have been saved.", "Changes Confirmed", PLAIN_MESSAGE);
    }
    
    //    METHOD FOR CONTROLLER TO SHOW DATE ISN'T SELECTED
    public void showNoDateMess() {
        JOptionPane.showMessageDialog(this, "No date has been choosen. Choose date before clicking button.", "Date Not Selected", WARNING_MESSAGE);
    }
    
}
