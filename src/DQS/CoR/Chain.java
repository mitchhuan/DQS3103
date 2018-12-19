/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DQS.CoR;

import javax.swing.JLabel;

/**
 *
 * @author Kent
 */
public interface Chain {
    
    public void setNextChain(Chain nextChain);
    public void login(User user);
    
}
