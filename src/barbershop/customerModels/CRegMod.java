/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerModels;

import barbershop.customerControllers.CRegCon;
import barbershop.customerDAO.UserDAOImpl;
import java.util.regex.Pattern;

/**
 *
 * @author rcvb8
 */
public class CRegMod {
    
    User user;
    UserDAOImpl userDAOImpl;
    CRegCon cRegCon;
    
    public boolean validFName;
    public boolean validLName = false;
    public boolean validEmail = false;
    public boolean validPassword = false;
    public boolean validConfPass = false;
    public boolean validPhone = false;
    public boolean userNoExist = false;
    private boolean passPassed;
    
//     CONSTRUCTOR TO CONNECT REGISTRATION MODEL TO REGISTRATION CONTROLLER
    public CRegMod(CRegCon cRegCon) {
        this.cRegCon = cRegCon;
    }
    
//    METHOD TO VALIDATE USER INPUT MEETS CRITERIA
    public boolean validate (NewUser newUser) {
        
//        VALIDATE FIRST NAME IS A NAME AND NOT NULL
            if (isWord(newUser.getFName()) && notNullOrEmpty(newUser.getFName())){
                validFName = true;
            }
            
//            VALIDATE LAST NAME IS A NAME AND NOT NULL
            if (isWord(newUser.getLName()) && notNullOrEmpty(newUser.getLName())) {
                validLName = true;
            }
            
//            CHECK DAO TO SEE IF USER ALREADY EXISTS WITH THAT EMAIL OR NOT
            if(cRegCon.getUserDAOResult()== true) {
                userNoExist = true;
            }
            
//            VALIDATE EMAIL FOLLOWS EMAIL FORMAT AND IS NOT NULL
            if(newUser.getEmail().contains("@") && newUser.getEmail().contains(".com") || newUser.getEmail().contains(".net") || newUser.getEmail().contains(".edu") && notNullOrEmpty(newUser.getEmail())) 
            {
                validEmail = true;
            }
            
//            VALIDATE PASSWORD THROUGH CHECKPASS METHOD AND IS NOT NULL
            if (checkPass(newUser.getPassword()) && notNullOrEmpty(newUser.getPassword())) {
                validPassword = true;
            }
            
//            VALIDATE PASSWORD IS CONFIRMED
            if (newUser.getConfPass().matches(newUser.getPassword()) && notNullOrEmpty(newUser.getConfPass())) {
                validConfPass = true;
            }
            
//            VALIDATE PHONE NUMBER IS ONLY 10 DIGITS AND ONLY CONTAINS NUMBERS AND IS NOT NULL
            if (newUser.getPhone().length()==10 && isNum(newUser.getPhone()) && notNullOrEmpty(newUser.getPhone())) 
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
