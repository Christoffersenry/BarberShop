/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.customerModels;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rcvb8
 */
public class User {
    
    private String uE;
    private String pw;
    private String hP;
    
//    CONSTRUCTOR REQUIRING TWO STRING INPUTS : USER EMAIL AND PASSWORD
    public User(String uE, String pw){
        this.uE = uE;
        this.pw = pw;
    }

//    GETTER METHODS FOR PASSING USER INPUT THAT CONTROLLER COLLECTS FROM VIEW, TO THE MODEL
    public String getUE() {
        return uE;
    }

    public String getPw() {
        return pw;
    }
    
//    METHOD TO HASH USER PASSWORD AND RETURN VALUE
    public String getHP() {
        
        try {
            
            String password = getPw() + "LoveIsLife";
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, digest); 
  
            // Convert message digest into hex value 
            hP= no.toString(16); 
                        
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hP;
    }
    
}
