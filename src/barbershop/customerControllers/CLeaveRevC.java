/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerControllers;

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
public class CLeaveRevC implements ActionListener {
    
    CLeaveRevV cLeaveRevV;
    
//    CONSTRUCTOR CONNECTING CONTROLLER TO VIEW WHICH CREATED IT
    public CLeaveRevC(CLeaveRevV cLeaveRevV) {
        this.cLeaveRevV = cLeaveRevV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        if (e.getActionCommand().equals("Log Out")) {
            int l = JOptionPane.showConfirmDialog(this.cLeaveRevV, "Are you sure?");
            if (l == JOptionPane.YES_OPTION) {
            this.cLeaveRevV.dispose();
            new IndexCon();
            }
        }         
//        PREVIOUS BUTTON TO RETURN TO HOME SCREEN
if (e.getActionCommand().equals("Previous")) {
            new CHomeV();
            this.cLeaveRevV.dispose();
        }
//      SUBMIT BUTTON TO SAVE REVIEW IN DATABASE AND RETURN USER TO HOME SCREEN
if (e.getActionCommand().equals("Submit")) {
    cLeaveRevV.getSubSuccessMess();
    this.cLeaveRevV.dispose();
    new CHomeV();
    }
    
}
}
