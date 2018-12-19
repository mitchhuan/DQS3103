/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DQS.CoR;

import DQS.JFrame.*;

/**
 *
 * @author Kent
 */
public class CoR_Teacher implements Chain {
    
    private Chain nextInChain;


    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void login(User user) {
        
        if("teacher".equals(user.getUsername()) && "123".equals(user.getPassword())){
            Fac_Home home = new Fac_Home();
            home.setTitle("Teacher Dashboard");
            home.setVisible(true);
            System.out.println("Role - Teacher - Logged In ");   
        } else {
            nextInChain.login(user);
        }
    }
    
    
}
