/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberControllers;

import barbershop.barberViews.BAvailV;
import barbershop.barberViews.BHomeV;
import barbershop.index.IndexCon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rcvb8
 */
public class BAvailC implements ActionListener {
    
    BAvailV bAvailV;
    
    public BAvailC(BAvailV bAvailV) {
        this.bAvailV = bAvailV;
        
    }

//    METHOD TO SAVE AVAILABILITY CHANGES
    @Override
    public void actionPerformed(ActionEvent e) {
//        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        if (e.getActionCommand().equals("Log Out")) {
            int l = JOptionPane.showConfirmDialog(this.bAvailV, "Are you sure?");
            if (l == JOptionPane.YES_OPTION) {
            this.bAvailV.dispose();
            new IndexCon();
            }
        } 
        
//        SHOW CHANGES SAVED MESSAGE AND HIDES FINISHED AVAILABILITY TABLE
        if (e.getActionCommand().equals("Save")) {
            bAvailV.getSaveConfMess();
            bAvailV.hideAvailTable();
        }
//        SHOW AVAILABLE TIME SLOTS FOR THAT SPECIFIC DATE
        if (e.getActionCommand().equals("Show Time Slots")) {
            bAvailV.showAvailTable();
        }
//        RETURN USER TO HOME PAGE
        if(e.getActionCommand().equals("Previous")) {
            new BHomeV();
            this.bAvailV.dispose();
        }
    }
    
}
