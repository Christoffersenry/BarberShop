/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberControllers;

import barbershop.barberModels.BRegMod;
import barbershop.barberModels.NewAdmin;
import barbershop.barberViews.BLogV;
import barbershop.barberViews.BRegV;
import barbershop.barberDAO.AdminDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rcvb8
 */
public class BRegC implements ActionListener {
    
    AdminDAOImpl adminDAOImpl;
    BRegV bRegV;
    BRegMod bRegMod;
    boolean adminDAOResult;
    boolean modResult;
    
//    CONSTRUCTOR TO CONNECT REGISTRATION CONTROLLER TO REGISTRATION VIEW, MODEL AND DAO
    public BRegC(BRegV bRegV)
    {
        this.bRegV = bRegV;
        this.bRegMod = new BRegMod(this);
        this.adminDAOImpl = new AdminDAOImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        PREVIOUS BUTTON TO RETURN TO LOG IN SCREEN
        if(e.getActionCommand().equals("Previous")) {
            new BLogV();
            this.bRegV.dispose();
        }
        
//        ACTION LISTENER METHOD FOR WHEN REGISTER BUTTON IS CLICKED
        if (e.getActionCommand().equals("Register")) {
            String fName = bRegV.getFName();
            String lName = bRegV.getLName();
            String email = bRegV.getEmail();
            String password = bRegV.getPassword();
            String confPass = bRegV.getConfirmPass();
            String phone = bRegV.getPhone();
            String location = bRegV.getLocation(bRegV);
            
//            VALUES ABOVE PASSED INTO NEW ADMIN OBJECT FROM NEWADMIN CLASS
            NewAdmin newAdmin = new NewAdmin(fName, lName, email, password, confPass, phone, location);
//            SET RESULT FROM DAO BASED ON THE DAO CHECK FOR EXISTING USER BASED ON USER INPUT
            this.adminDAOResult = adminDAOImpl.userNoExistCheck(newAdmin);
            
//             MODEL VALIDATION
//            SET RESULT FROM THE REGISTRATION MODEL VALIDATING THE NEW ADMIN
            this.modResult = bRegMod.validate(newAdmin);
            
//           SERIES OF IF STATEMENTS TO DISPLAY OR HIDE SPECIFIC ERROR MESSAGES TO THE USER
            if (!modResult)
            {
                if (!bRegMod.validFName)
                {
                    bRegV.getInvalMessFName();
                } else {bRegV.hideInvalMessFName();}
                
                if (!bRegMod.validLName)
                {
                    bRegV.getInvalMessLName();
                } else {bRegV.hideInvalMessLName();}
                
                if (!bRegMod.validEmail)
                {
                    bRegV.getInvalMessEmail();
                } else {bRegV.hideInvalMessEmail();}
                
                if (!bRegMod.userNoExist)
                {
                    bRegV.getUserExist();
                } else {bRegV.hideUserExist();}
                
                if (!bRegMod.validPassword)
                {
                    bRegV.getInvalMessPass();
                } else {bRegV.hideInvalMessPass();}
                
                if (!bRegMod.validConfPass)
                {
                    bRegV.getInvalMessConfPass();                    
                } else {bRegV.hideInvalMessConfPass();}
                
                if (!bRegMod.validPhone)
                {
                    bRegV.getInvalMessPhone();
                } else {bRegV.hideInvalMessPhone();}               
               
            }
            
//            DISPLAY POP UP FAIL MESSAGE OR REGISTER USER, CLOSE THIS WINDOW, AND REDIRECT TO BARBER LOGIN SCREEN
             if (!modResult) {
                bRegV.showFailedReg();
             } 
//             MAKE SURE ALL INVALID MESSAGES ARE HIDDEN WHEN REGISTRATION IS SUCCESSFUL
             else {
                 bRegV.hideInvalMessFName();
                 bRegV.hideInvalMessLName();
                 bRegV.hideInvalMessEmail();
                 bRegV.hideUserExist();
                 bRegV.hideInvalMessPass();
                 bRegV.hideInvalMessConfPass();
                 bRegV.hideInvalMessPhone();
                bRegV.showSuccessReg();
                adminDAOImpl.regBarb(newAdmin);
                new BLogV();
                this.bRegV.dispose();   
            }             
        }
    }
    
//    GETTER METHOD FOR THE MODEL TO OBTAIN DAO RESULT FROM CONTROLLER
    public boolean getAdminDAOResult() {
        return adminDAOResult;
    }
    
}
