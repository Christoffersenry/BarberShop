/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberDAO;

import barbershop.barberModels.NewAdmin;
import barbershop.barberModels.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author rcvb8
 */
public class AdminDAOImpl {
    
   NewAdmin newAdmin;
    
//    INFO TO CONNECT TO DATABASE
    private String dbServer = "jdbc:mysql://apontejaj.com:3306/Rylee_2019145?useSSL=false";
    private String dbUser = "Rylee_2019145";
    private String dbPassword = "2019145";
    
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String query;    
    public boolean result;    
    
//    BOOLEAN METHOD TO LOGIN USER BASED ON USER INPUT MATCHING AN EXISTING USER IN DB
    public boolean login(Admin admin) 
    {
        result = false;
         try {
//             SQL QUERY TO SELECT USERS WITH MATCHING INFO TO USER INPUT
            query = "SELECT * FROM admin WHERE email = '"+ admin.getUE() + "' AND password = '" + admin.getHP() + "';";
            
//             CONNECT TO DATABASE
            conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

//             GET A STATEMENT FROM THE CONNECTION
            stmt = conn.createStatement();

//             EXECUTE THE QUERY
            rs = stmt.executeQuery(query);

//             CHECK TO SEE IF A RESULT APPEARED
            if (rs.next()) {
                result = true;
            }

//             CLOSE THE RESULT SET, STATEMENT AND CONNECTION
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

//             SQL EXCEPTIONS LOOP
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         
         return result;             
    }
    
//    BOOLEAN METHOD TO CHECK FOR EXISTING USER (BEFORE REGISTERING A NEW ONE)
    public boolean userNoExistCheck(NewAdmin newAdmin) {
       try {
//           SQL QUERY TO SELECT ALL ENTRIES FROM DB WITH MATCHING EMAIL TO USER INPUT
           String selectQuery = "SELECT count(*) AS exist FROM admin WHERE email='"+newAdmin.getEmail()+"';";
//            CONNECT TO DB
           conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);
//            STATEMENT FROM CONNECTION
            stmt = conn.createStatement();
           // EXECUTE THE QUERY
           rs = stmt.executeQuery(selectQuery);
           
//           IF STATEMENT TO DETERMINE IF RESULT PRODUCED AN EXISITING USER (1) OR NOT
           if (rs.next() == true) {
               if(rs.getInt(1)>0){
               result = false;              
               }
           else {
               result = true;                
               }
       }           
       } catch (SQLException e) {
           throw new RuntimeException(e);
       } catch (NullPointerException nE) {
           System.out.println(nE);
       }
       return result;
    }
    
//    METHOD TO INSERT USER INPUT INTO USER TABLE IN DB (REGISTER NEW ADMIN)
    public void regBarb (NewAdmin newAdmin) {
        
        try {
//          CONNECT TO DATABASE
           conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);
                  
//        STRING FOR SQL STATEMENT INSERTING REGISTRATION DETAILS
           String insertQuery = "INSERT INTO admin (email, password, f_name, l_name, phone, location) VALUES (?,?,?,?,?,?);";
           
//        PREPARE STATEMENT WITH NEW ADMIN INPUT 
           PreparedStatement pStmt = conn.prepareStatement(insertQuery);
           pStmt.setString(1, newAdmin.getEmail());
           pStmt.setString(2, newAdmin.getHashPass());
           pStmt.setString(3, newAdmin.getFName());
           pStmt.setString(4, newAdmin.getLName());
           pStmt.setString(5, newAdmin.getPhone());
           pStmt.setString(6, newAdmin.getLocation());
           
//        EXECUTE PREPARED STATEMENT AND CLOSE
           pStmt.execute();
           pStmt.close();            
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
}
