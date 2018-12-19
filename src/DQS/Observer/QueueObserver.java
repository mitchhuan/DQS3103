/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DQS.Observer;

import java.util.ArrayList;

/**
 *
 * @author Kent
 */
public class QueueObserver implements Observer {
    
    private int idNum;
    private String service,role;
    
    private Queue queue;
    
    public QueueObserver(Queue queue){
        this.queue = queue;
        queue.register(this);
    }

    QueueObserver() {
    }
    
    @Override
    public void update(int idNum, String role, String service) {
        this.idNum = idNum;
        this.role = role;
        this.service = service;
        
        System.out.println("ID Number: " + idNum + "\nRole: " + role + "\nService: "+ service +"\n");
    }
    
}

