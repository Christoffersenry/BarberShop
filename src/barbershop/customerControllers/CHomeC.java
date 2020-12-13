/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerControllers;

import barbershop.customerViews.CBarbSearchV;
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
public class CHomeC implements ActionListener {
    
    CHomeV cHomeV;
    
//    CONSTRUCTOR CONNECTING CONTROLLER TO HOME VIEW IN WHICH IT WAS CREATED BY
    public CHomeC(CHomeV cHomeV) {
        this. cHomeV = cHomeV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        if (e.getActionCommand().equals("Log Out")) {
            int l = JOptionPane.showConfirmDialog(this.cHomeV, "Are you sure?");
            if (l == JOptionPane.YES_OPTION) {
            this.cHomeV.dispose();
            new IndexCon();
            }
        }        
        //        DIRECTS USER TO BARBER SEARCH VIEW AND CLOSES THIS VIEW
        if (e.getActionCommand().equals("Find a Barber")) {
            new CBarbSearchV();
            this.cHomeV.dispose();
        }
        //        DIRECTS USER TO vIEW THEIR BOOKINGS VIEW AND CLOSES THIS VIEW
        if (e.getActionCommand().equals("View Your Bookings")) {
            new CBookingsV();
            this.cHomeV.dispose();
        }
        //        DIRECTS USER TO REVIEW FORM VIEW AND CLOSES THIS VIEW
        if (e.getActionCommand().equals("Leave a Review")) {
            new CLeaveRevV();
            this.cHomeV.dispose();
        }
    }

    
}
