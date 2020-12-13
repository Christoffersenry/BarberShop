/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberControllers;

import barbershop.barberViews.BHomeV;
import barbershop.barberViews.BUpApptsV;
import barbershop.index.IndexCon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rcvb8
 */
public class BUpApptsC implements ActionListener{
  
    BUpApptsV bUpApptsV;
    
//    CONSTRUCTOR CONNECTING CONTROLLER TO VIEW WHICH CREATED IT
    public BUpApptsC(BUpApptsV bUpApptsV) {
        this.bUpApptsV = bUpApptsV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //        LOGOUT BUTTON TO RETURN USER TO INDEX PAGE
        if (e.getActionCommand().equals("Log Out")) {
            int l = JOptionPane.showConfirmDialog(this.bUpApptsV, "Are you sure?");
            if (l == JOptionPane.YES_OPTION) {
            this.bUpApptsV.dispose();
            new IndexCon();
            }
        }         
//        PREVIOUS BUTTON TO RETURN TO HOME SCREEN
if (e.getActionCommand().equals("Previous")) {
            new BHomeV();
            this.bUpApptsV.dispose();
        }
//      QUICK AND HIGHLY VISIBLE BUTTON TO RETURN USER TO HOME SCREEN
if (e.getActionCommand().equals("Return Home")) {
    this.bUpApptsV.dispose();
    new BHomeV();
    }
    
}
}
