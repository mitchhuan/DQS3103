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
public class QueueNumber {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public QueueNumber(){
        conn=DBConn.getConnection();
    }

    public void getqNum() {
        
        String sql="SELECT Queue_Number FROM queue ORDER BY Queue_Number DESC LIMIT 1";
        try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            rs=pst.executeQuery();
            if(rs.next()){
                int qNum = rs.getInt("Queue_Number");
                JOptionPane.showMessageDialog(null, "Queue Number : " + qNum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
