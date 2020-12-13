/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerControllers;

import barbershop.customerViews.CHomeV;
import barbershop.customerModels.User;
import barbershop.customerViews.CLogV;
import barbershop.customerViews.CRegV;
import barbershop.customerDAO.UserDAOImpl;
import barbershop.index.IndexCon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author rcvb8
 */
public class CLogCon implements ActionListener, MouseListener {
    
    CLogV cLogV;
    UserDAOImpl userDAOImpl;
    boolean result;
    
//     INSTANTIATION OF CUSTOMER LOGIN VIEW AND DAO CLASS
    public CLogCon(CLogV cLogV)
    {
        this.cLogV = cLogV;
        this.userDAOImpl = new UserDAOImpl();
    }
    
// LOGIN METHOD WHEN BUTTON IS CLICKED (RESULT TRUE = DIRECT TO HOME / RESULT FALSE = INVALID MESSAGE)
    @Override
    public void actionPerformed(ActionEvent e) {
//        PREVIOUS BUTTON TO RETURN TO INDEX SCREEN
        if(e.getActionCommand().equals("Previous")) {
            new IndexCon();
            this.cLogV.dispose();
        }
//         IDENTIFIES LOGIN BUTTON IN VIEW
        if (e.getActionCommand().equals("Login")) {
            
//            STORES USER INPUT IN STRINGS
            String uE = cLogV.getUserEmail();
            String pw = cLogV.getUserPassword(); 
            
//            PASSES USER INPUT INTO USER CLASS
            User user = new User(uE, pw);
            
//            STORES BOOLEAN RESULT FROM LOGIN METHOD IN DAO
            this.result = userDAOImpl.login(user);
            
//            CHANGES VIEW OR DISPLAYS INVALID MESSAGE BASED ON RESULT
            if (!result)
            {
               cLogV.getInvalidMessage();
            }            
            else {
                new CHomeV();
                this.cLogV.dispose();
            }
        }    
    }
    
//        METHOD TO TO TAKE USER TO REGISTRATION PAGE
    @Override
    public void mouseClicked(MouseEvent e) {
        new CRegV();
        this.cLogV.dispose();
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
