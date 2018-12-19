/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Kent
 */
public class DBConn {
    
    public static Connection getConnection(){
    Connection con = null;
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/queue_system","root","");
    } catch (Exception e){
        System.out.println(e);
    }
    return con;
    }
    
    public static boolean loginUser(String username, String password){
        boolean valid = false;
        try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");
 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/queue_system","root","");
         PreparedStatement ps =con.prepareStatement
                             ("select * from users where username=? and password=?");
         ps.setString(1, username);
         ps.setString(2, password);
         ResultSet rs =ps.executeQuery();
         valid = rs.next();
      }catch(Exception e)
      {
          e.printStackTrace();
      }
        return valid;
    }
    
    
}
