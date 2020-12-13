/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerControllers;

import barbershop.customerViews.CBarbAvailV;
import barbershop.customerViews.CBarbSearchV;
import barbershop.customerViews.CHomeV;
import barbershop.customerViews.CLeaveRevV;
import barbershop.index.IndexCon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rcvb8
 */
public class CBarbSearchC implements ActionListener {
    
    CBarbSearchV cBarbSearchV;
    
//    CONSTRUCTOR CONNECTING CONTROLLER TO VIEW WHICH CREATED IT
    public CBarbSearchC(CBarbSearchV cBarbSearchV) {
        this.cBarbSearchV = cBarbSearchV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        if (e.getActionCommand().equals("Log Out")) {
            int l = JOptionPane.showConfirmDialog(this.cBarbSearchV, "Are you sure?");
            if (l == JOptionPane.YES_OPTION) {
            this.cBarbSearchV.dispose();
            new IndexCon();
            }
        }         
//        PREVIOUS BUTTON TO RETURN TO HOME SCREEN
if (e.getActionCommand().equals("Previous")) {
            new CHomeV();
            this.cBarbSearchV.dispose();
        }
//      SUBMIT BUTTON TO SAVE REVIEW IN DATABASE AND RETURN USER TO HOME SCREEN
if (e.getActionCommand().equals("Check Availability")) {
    this.cBarbSearchV.dispose();
    new CBarbAvailV();
    }
    
}
}
