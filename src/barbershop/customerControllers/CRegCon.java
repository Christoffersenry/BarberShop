/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerControllers;


import barbershop.customerModels.CRegMod;
import barbershop.customerModels.NewUser;
import barbershop.customerViews.CLogV;
import barbershop.customerViews.CRegV;
import barbershop.customerDAO.UserDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rcvb8
 */
public class CRegCon implements ActionListener {
    
    UserDAOImpl userDAOImpl;
    CRegV cRegV;
    CRegMod cRegMod;
    boolean userDAOResult;
    boolean modResult;
    
//    CONSTRUCTOR TO CONNECT REGISTRATION CONTROLLER TO REGISTRATION VIEW, MODEL AND DAO
    public CRegCon(CRegV cRegV)
    {
        this.cRegV = cRegV;
        this.cRegMod = new CRegMod(this);
        this.userDAOImpl = new UserDAOImpl();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//      PREVIOUS BUTTON TO RETURN TO LOG IN SCREEN  
        if(e.getActionCommand().equals("Previous")) {
            new CLogV();
            this.cRegV.dispose();
        }
        
//        ACTION LISTENER METHOD FOR WHEN REGISTER BUTTON IS CLICKED
        if (e.getActionCommand().equals("Register")) {
            String fName = cRegV.getFName();
            String lName = cRegV.getLName();
            String email = cRegV.getEmail();
            String password = cRegV.getPassword();
            String confPass = cRegV.getConfirmPass();
            String phone = cRegV.getPhone();
            
//            VALUES ABOVE PASSED INTO NEW USER OBJECT FROM NEWUSER CLASS
            NewUser newUser = new NewUser(fName, lName, email, password, confPass, phone);
//            SET RESULT FROM DAO BASED ON THE DAO CHECK FOR EXISTING USER BASED ON USER INPUT
            this.userDAOResult = userDAOImpl.userNoExistCheck(newUser);
            
//             MODEL VALIDATION
//            SET RESULT FROM THE REGISTRATION MODEL VALIDATING THE NEW USER
            this.modResult = cRegMod.validate(newUser);
            
//           SERIES OF IF STATEMENTS TO DISPLAY OR HIDE SPECIFIC ERROR MESSAGES TO THE USER
            if (!modResult)
            {
                if (!cRegMod.validFName)
                {
                    cRegV.getInvalMessFName();
                } else {cRegV.hideInvalMessFName();}
                
                if (!cRegMod.validLName)
                {
                    cRegV.getInvalMessLName();
                } else {cRegV.hideInvalMessLName();}
                
                if (!cRegMod.validEmail)
                {
                    cRegV.getInvalMessEmail();
                } else {cRegV.hideInvalMessEmail();}
                
                if (!cRegMod.userNoExist)
                {
                    cRegV.getUserExist();
                } else {cRegV.hideUserExist();}
                
                if (!cRegMod.validPassword)
                {
                    cRegV.getInvalMessPass();
                } else {cRegV.hideInvalMessPass();}
                
                if (!cRegMod.validConfPass)
                {
                    cRegV.getInvalMessConfPass();                    
                } else {cRegV.hideInvalMessConfPass();}
                
                if (!cRegMod.validPhone)
                {
                    cRegV.getInvalMessPhone();
                } else {cRegV.hideInvalMessPhone();}               
               
            }
            
//            DISPLAY POP UP FAIL MESSAGE OR REGISTER USER, CLOSE THIS WINDOW, AND REDIRECT TO CUSTOMER LOGIN SCREEN
             if (!modResult) {
                cRegV.showFailedReg();
             } 
//             MAKE SURE ALL INVALID MESSAGES ARE HIDDEN WHEN REGISTRATION IS SUCCESSFUL
             else {
                 cRegV.hideInvalMessFName();
                 cRegV.hideInvalMessLName();
                 cRegV.hideInvalMessEmail();
                 cRegV.hideUserExist();
                 cRegV.hideInvalMessPass();
                 cRegV.hideInvalMessConfPass();
                 cRegV.hideInvalMessPhone();
                cRegV.showSuccessReg();
                userDAOImpl.regCust(newUser);
                new CLogV();
                this.cRegV.dispose();   
            }
             
        }
    }
    
//    GETTER METHOD FOR THE MODEL TO OBTAIN DAO RESULT FROM CONTROLLER
    public boolean getUserDAOResult() {
        return userDAOResult;
    }
    
 }

   
