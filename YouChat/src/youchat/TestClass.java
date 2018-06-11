/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youchat;

import java.awt.Dimension;
import java.awt.Point;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author kasumba
 */
public class TestClass extends JFrame {
    
    public TestClass()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // MessageSender x = new MessageSender(this,"andi_13","kasumbarobert");
       //x.show();
       //add( new FriendsPanel(this));
        //try {        
            add(new MessagesPanel(this));
            
            //add(new DisplayMessages(null,"andi_13","kasumbarobert"));
       // } catch (SQLException ex) {
          //  Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        //}
        
        this.setSize(new Dimension(600,539));
        this.setLocation(new Point(300,75));
        this.setVisible(true);
        //this.setResizable(false);
    }
    
    public static void main(String []args)
    {
        TestClass x =new TestClass();
        //new FriendsPanel(x);
    }
}
