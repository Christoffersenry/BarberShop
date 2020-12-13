/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerControllers;

import barbershop.customerViews.CBarbAvailV;
import barbershop.customerViews.CBarbSearchV;
import barbershop.customerViews.CHomeV;
import barbershop.index.IndexCon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rcvb8
 */
public class CBarbAvailC implements ActionListener {
    
    CBarbAvailV cBarbAvailV;
    
//    CONSTRUCTOR CONNECTING CONTROLLER TO VIEW WHICH CREATED IT
    public CBarbAvailC(CBarbAvailV cBarbAvailV) {
        this.cBarbAvailV = cBarbAvailV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        if (e.getActionCommand().equals("Log Out")) {
            int l = JOptionPane.showConfirmDialog(this.cBarbAvailV, "Are you sure?");
            if (l == JOptionPane.YES_OPTION) {
            this.cBarbAvailV.dispose();
            new IndexCon();
            }
        }         
//        PREVIOUS BUTTON TO RETURN TO BARBER SEARCH
if (e.getActionCommand().equals("Previous")) {
            new CBarbSearchV();
            this.cBarbAvailV.dispose();
        }
//      BUTTON TO BOOK APPOINTMENT AND RETURN TO HOME SCREEN
if (e.getActionCommand().equals("Book Appointment")) {
    cBarbAvailV.getBookSuccessMess();
    this.cBarbAvailV.dispose();
    new CHomeV();
    }
    
}
}
