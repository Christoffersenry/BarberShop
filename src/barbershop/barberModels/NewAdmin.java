/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberModels;

import barbershop.customerModels.NewUser;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rcvb8
 */
public class NewAdmin {
    
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String confPass;
    private String phone;
    private String location;
    private String hashPass;
    
//    CONSTRUCTOR REQUIRING STRINGS MATCHING REGISTRATION FORM
    public NewAdmin(String fName, String lName, String email, String password, String confPass, String phone, String location) {
        this.fName = fName;
        this. lName = lName;
        this.email = email;
        this.password = password;
        this.confPass = confPass;
        this.phone = phone;
        this.location = location;
    }
    
//    GETTER METHODS TO PASS THE USER INPUT FROM THE CONTROLLER TO THE MODEL
    public String getFName() {
        return fName;
    }
    
    public String getLName() {
        return lName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getConfPass() {
        return confPass;
    }
    
    public String getPhone() {
        return phone;
    }    
    
    public String getLocation() {
        return location;
    } 
    
//    METHOD TO HASH NEW USER PASSWORD TO PREPARE FOR DATABASE SUBMISSION
    public String getHashPass() {
        
        try {
            
            String hash = "35454B055CC325EA1AF2126E27707052";
            String password = getPassword() + "LoveIsLife";
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, digest); 
  
            // Convert message digest into hex value 
            hashPass = no.toString(16);
                        
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashPass;
    }
    
}
