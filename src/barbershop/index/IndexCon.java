/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.index;

import barbershop.barberViews.BLogV;
import barbershop.customerViews.CLogV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rcvb8
 */
public class IndexCon implements ActionListener {
    
    IndexV indexV;
    
//    INSTANTIATE INDEX PAGE VIEW WITH INDEX CONTROLLER
    public IndexCon() {        
        this.indexV = new IndexV(this);
    }
    
//    ACTION LISTENER METHOD TO DIRECT USER TO CUSTOMER OR BARBER LOGIN PAGE
    @Override
    public void actionPerformed(ActionEvent e) {
        
//         DIRECTS USER TO CUSTOMER LOGIN PAGE AND CLOSES THIS PAGE
        if (e.getActionCommand().equals("Customer")) {
            new CLogV();
            this.indexV.dispose();
        }
        
//        DIRECTS USER TO BARBER LOGIN PAGE AND CLOSES THIS PAGE
        if (e.getActionCommand().equals("Barber")) {
            new BLogV();
            this.indexV.dispose();
        }
    }
    
}
