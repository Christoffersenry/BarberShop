/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerControllers;

import barbershop.customerViews.CBookingsV;
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
public class CBookingsC implements ActionListener{
    
    CBookingsV cBookingsV;
    
//    CONSTRUCTOR CONNECTING CONTROLLER TO VIEW WHICH CREATED IT
    public CBookingsC(CBookingsV cBookingsV) {
        this.cBookingsV = cBookingsV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        if (e.getActionCommand().equals("Log Out")) {
            int l = JOptionPane.showConfirmDialog(this.cBookingsV, "Are you sure?");
            if (l == JOptionPane.YES_OPTION) {
            this.cBookingsV.dispose();
            new IndexCon();
            }
        }         
//        PREVIOUS BUTTON TO RETURN TO HOME SCREEN
if (e.getActionCommand().equals("Previous")) {
            new CHomeV();
            this.cBookingsV.dispose();
        }
//      QUICK AND HIGHLY VISIBLE BUTTON TO RETURN USER TO HOME SCREEN
if (e.getActionCommand().equals("Return Home")) {
    this.cBookingsV.dispose();
    new CHomeV();
    }
    
}
}
