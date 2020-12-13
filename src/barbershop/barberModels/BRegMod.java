/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberModels;

import barbershop.barberControllers.BRegC;
import barbershop.customerControllers.CRegCon;
import barbershop.barberDAO.AdminDAOImpl;
import java.util.regex.Pattern;

/**
 *
 * @author rcvb8
 */
public class BRegMod {
  
    Admin admin;
    AdminDAOImpl adminDAOImpl;
    BRegC bRegC;
    
    public boolean validFName;
    public boolean validLName = false;
    public boolean validEmail = false;
    public boolean validPassword = false;
    public boolean validConfPass = false;
    public boolean validPhone = false;
    public boolean userNoExist = false;
    private boolean passPassed;
    
//     CONSTRUCTOR TO CONNECT REGISTRATION MODEL TO REGISTRATION CONTROLLER
    public BRegMod(BRegC bRegC) {
        this.bRegC = bRegC;
    }
    
//    METHOD TO VALIDATE USER INPUT MEETS CRITERIA
    public boolean validate (NewAdmin newAdmin) {
        
//        VALIDATE FIRST NAME IS A NAME AND NOT NULL
            if (isWord(newAdmin.getFName()) && notNullOrEmpty(newAdmin.getFName())){
                validFName = true;
            }
            
//            VALIDATE LAST NAME IS A NAME AND NOT NULL
            if (isWord(newAdmin.getLName()) && notNullOrEmpty(newAdmin.getLName())) {
                validLName = true;
            }
            
//            CHECK DAO TO SEE IF USER ALREADY EXISTS WITH THAT EMAIL OR NOT
            if(bRegC.getAdminDAOResult()== true) {
                userNoExist = true;
            }
            
//            VALIDATE EMAIL FOLLOWS EMAIL FORMAT AND IS NOT NULL
            if(newAdmin.getEmail().contains("@") && newAdmin.getEmail().contains(".com") || newAdmin.getEmail().contains(".net") || newAdmin.getEmail().contains(".edu") && notNullOrEmpty(newAdmin.getEmail())) 
            {
                validEmail = true;
            }
            
//            VALIDATE PASSWORD THROUGH CHECKPASS METHOD AND IS NOT NULL
            if (checkPass(newAdmin.getPassword()) && notNullOrEmpty(newAdmin.getPassword())) {
                validPassword = true;
            }
            
//            VALIDATE PASSWORD IS CONFIRMED
            if (newAdmin.getConfPass().matches(newAdmin.getPassword()) && notNullOrEmpty(newAdmin.getConfPass())) {
                validConfPass = true;
            }
            
//            VALIDATE PHONE NUMBER IS ONLY 10 DIGITS AND ONLY CONTAINS NUMBERS AND IS NOT NULL
            if (newAdmin.getPhone().length()==10 && isNum(newAdmin.getPhone()) && notNullOrEmpty(newAdmin.getPhone())) 
            {
                validPhone = true;
            }
            
//            MAKES SURE ALL VALIDATIONS ARE PASSED ELSE USER INPUT IS NOT VALID
            if (validFName && validLName && validEmail && userNoExist && validPassword && validPhone == true)
            {
                return true;
            }
            else
            {
                return false;
            }      
    }
    
//    VALIDATE STRING ONLY CONTAINS LETTERS
     public boolean isWord(String name)
    {
        return Pattern.matches("[a-zA-Z]+", name);
    }
     
//     VALIDATE STRING ONLY CONTAINS NUMBERS
     public boolean isNum(String num)
    {
        return Pattern.matches("[0-9]+", num);
    }
    
//     VALIDATE PASSWORD HAS AT LEAST ONE CAPITAL LETTER, LOWER CASE LETTER, NUMBER AND IS AT LEAST 8 CHARACTERS LONG AND NO MORE THAN 15
     public boolean checkPass(String password)
     { 
         passPassed = false;
         boolean hasNum = false;
         boolean hasCap = false;
         boolean hasLow = false;
         char c;
         
//         VERIFIES LENTGH OF PASSWORD
         if (password.length() > 7 && password.length() < 16) {
             
//             CHECKS WHOLE STRING TO INDENTIFY NUMBERS, CAPITAL LETTERS AND LOWER CASE LETTERS
         for (int i = 0; i < password.length(); i++) {
             c = password.charAt(i);
             if (Character.isDigit(c))
             {
                 hasNum = true;
             }
             else if (Character.isUpperCase(c))
             {
                 hasCap = true;
             }
             else if (Character.isLowerCase(c))
             {
                 hasLow = true;
             }
//             MAKES SURE ALL PASSWORD CRITERIA ARE MET BEFORE PASSING INITIAL VALIDATION CHECK
             if (hasNum && hasCap && hasLow == true)
             {
               passPassed = true;  
             }                 
             }           
         }
         return passPassed;   
     }     
     
//     METHOD TO CHECK IF TEXT FIELD WAS LEFT BLANK
     public boolean notNullOrEmpty(String str) {
        if(str == null || str.isEmpty()) {
            return false ;
        }
        return true;
     }     
     
}
