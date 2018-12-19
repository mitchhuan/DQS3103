/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DQS.CoR;

import DQS.JFrame.Home;
import javax.swing.JLabel;

/**
 *
 * @author Kent
 */
public class CoR_Chairman implements Chain {
    
    private Chain nextInChain;


    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void login(User user) {
        
        if("chairman".equals(user.getUsername()) && "123".equals(user.getPassword())){
            Home home = new Home();
            home.setTitle("Chairman Dashboard");
            home.setVisible(true);
            System.out.println("Role - Chairman - Logged In");
        } else {
            nextInChain.login(user);
        }
    }
    
}
