/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DQS.Observer;

import DB.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Kent
 */
public class Transactions {
    
    private String role,service, id_num, q_num;
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

//    public String getId_num() {
//        return id_num;
//    }
//
//    public void setId_num(String id_num) {
//        this.id_num = id_num;
//    }
//
//    public String getQ_num() {
//        return q_num;
//    }
//
//    public void setQ_num(String q_num) {
//        this.q_num = q_num;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String getService() {
//        return service;
//    }
//
//    public void setService(String service) {
//        this.service = service;
//    }
//
//    
    public Transactions(String id_num, String q_num, String role, String service){
        
        String sql="INSERT INTO complete(ID_Number,Role,Service,Queue_Number) VALUES (?,?,?,?)";
        try{
            conn=DBConn.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, id_num);
            pst.setString(2, role );
            pst.setString(3, service);
            pst.setString(4, q_num);
            pst.execute();
            System.out.println("Added to DB");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Transactions() {
    }
    
    
    
}
