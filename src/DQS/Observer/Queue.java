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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kent
 */
public class Queue implements Subject {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    private int idNum;
    private String role, service;
    
    private ArrayList<Observer> observers;
    

    public Queue() {
        observers = new ArrayList<Observer>();
    }
    

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public void register(Observer queue) {
        observers.add(queue);
        String sql="INSERT INTO queue(ID_Number,Role,Service) VALUES (?,?,?)";
        try{
            conn=DBConn.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, this.getIdNum());
            pst.setString(2, this.getRole() );
            pst.setString(3, this.getService());
            pst.execute();
            System.out.println("Added to DB");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        notifyObserver();
    }

    @Override
    public void unregister(Observer queue) {
        observers.remove(queue);
    }

    @Override
    public void notifyObserver() {
        for(Observer ob : observers) {
                     ob.update(idNum, role, service);
                     
              }

    }
    
    
    
    
}
