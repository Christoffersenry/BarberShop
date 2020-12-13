/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberControllers;

import barbershop.barberViews.BAvailV;
import barbershop.barberViews.BHomeV;
import barbershop.barberViews.BTodayApptsV;
import barbershop.barberViews.BUpApptsV;
import barbershop.index.IndexCon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rcvb8
 */
public class BHomeC implements ActionListener {
    
    BHomeV bHomeV;
    
    //    CONSTRUCTOR CONNECTING CONTROLLER TO HOME VIEW IN WHICH IT WAS CREATED BY
    public BHomeC(BHomeV bHomeV) {
        this. bHomeV = bHomeV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        if (e.getActionCommand().equals("Log Out")) {
            int l = JOptionPane.showConfirmDialog(this.bHomeV, "Are you sure?");
            if (l == JOptionPane.YES_OPTION) {
            this.bHomeV.dispose();
            new IndexCon();
            }
        }
//        DIRECTS ADMIN TO UPCOMING APPOINTMENTS VIEW AND CLOSES THIS VIEW
        if (e.getActionCommand().equals("Upcoming Appointments")) {
            new BUpApptsV();
            this.bHomeV.dispose();
        }
        //        DIRECTS ADMIN TO AVAILABILITY VIEW AND CLOSES THIS VIEW
        if (e.getActionCommand().equals("Manage Availability")) {
            new BAvailV();
            this.bHomeV.dispose();
        }
        //        DIRECTS ADMIN TO TODAY'S APPOINTMENTS VIEW AND CLOSES THIS VIEW
        if (e.getActionCommand().equals("Today's Appointments")) {
            new BTodayApptsV();
            this.bHomeV.dispose();
        }
    }
    
}
