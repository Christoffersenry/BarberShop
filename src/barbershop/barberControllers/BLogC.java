/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberControllers;

import barbershop.barberViews.BHomeV;
import barbershop.barberModels.Admin;
import barbershop.barberViews.BLogV;
import barbershop.barberViews.BRegV;
import barbershop.barberDAO.AdminDAOImpl;
import barbershop.index.IndexCon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author rcvb8
 */
public class BLogC implements ActionListener, MouseListener {
    
    BLogV bLogV;
    AdminDAOImpl adminDAOImpl;
    boolean result;
    
//     INSTANTIATION OF BARBER LOGIN VIEW AND DAO CLASS
    public BLogC(BLogV bLogV)
    {
        this.bLogV = bLogV;
        this.adminDAOImpl = new AdminDAOImpl();
    }
    
// LOGIN METHOD WHEN BUTTON IS CLICKED (RESULT TRUE = DIRECT TO HOME / RESULT FALSE = INVALID MESSAGE)
    @Override
    public void actionPerformed(ActionEvent e) {
//        PREVIOUS BUTTON TO RETURN TO INDEX SCREEN
        if(e.getActionCommand().equals("Previous")) {
            new IndexCon();
            this.bLogV.dispose();
        }
//         IDENTIFIES LOGIN BUTTON IN VIEW
        if (e.getActionCommand().equals("Login")) {
            
//            STORES USER INPUT IN STRINGS
            String uE = bLogV.getUserEmail();
            String pw = bLogV.getUserPassword(); 
            
//            PASSES USER INPUT INTO ADMIN CLASS
            Admin admin = new Admin(uE, pw);
            
//            STORES BOOLEAN RESULT FROM LOGIN METHOD IN DAO
            this.result = adminDAOImpl.login(admin);
            
//            CHANGES VIEW OR DISPLAYS INVALID MESSAGE BASED ON RESULT
            if (!result)
            {
               bLogV.getInvalidMessage();
            }            
            else {
                new BHomeV();
                this.bLogV.dispose();
            }
        }    
    }
    
//        METHOD TO TO TAKE USER TO REGISTRATION PAGE
    @Override
    public void mouseClicked(MouseEvent e) {
        new BRegV();
        this.bLogV.dispose();
    }
    
//        UNUSED METHODS, BUT NEEDED IN ORDER TO USE MOUSE LISTENER
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
