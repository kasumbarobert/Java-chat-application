/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youchat;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author kasumba
 */
public class MessagesPanel extends JPanel{
    public JFrame parent;
    private JList friendslist;
    private Font style ;
    private YouChatMain owner;
    private String current_user;
    public MessagesPanel(JFrame parent)
    {
        style= new Font("Times New Roman",Font.PLAIN,16);
        this.parent = parent;
        this.setLayout(new BorderLayout()); 
        this.setFriendsList();
        this.add(new JScrollPane(this.friendslist), BorderLayout.WEST);
        owner = (YouChatMain)parent;
        String first = null;
        try {
            Connector theCon = new Connector();
            ResultSet rs = theCon.getStatement().executeQuery("SELECT * FROM user ORDER BY name");
            if(rs.next())
            {
                first = rs.getString("username");
            }
            theCon.close();
            this.add(new DisplayMessages(this,owner.verified.username,first),BorderLayout.CENTER);
                    } catch (SQLException ex) {
            Logger.getLogger(MessagesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }     
       this.setPreferredSize(new Dimension(863,342));
       TimerTask task = new UpdateMessagesList();
       Timer timer = new Timer(true);
       timer.scheduleAtFixedRate(task, 5000, 5000);
       
    }
    
    private void setFriendsList()
    {
        FriendsPanel x = new FriendsPanel(this.parent);
        friendslist = new JList(x.getAllFriends());
        friendslist.setFont(this.style);
        friendslist.addListSelectionListener(new ChangeMessageThread() );
    }
    
    private class ChangeMessageThread implements ListSelectionListener{
        
        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                String receiver;
                synchronized(MessagesPanel.this.friendslist){
                receiver = (String)MessagesPanel.this.friendslist.getSelectedValue();
                if(receiver != null){
                String []conts = receiver.split(":");
                conts[1] = conts[1].trim();
                String []temp = conts[1].split(" ");
                receiver = temp[0];
                MessagesPanel.this.current_user=receiver;
                MessagesPanel.this.getComponent(1).setVisible(false);
                YouChatMain y = (YouChatMain)MessagesPanel.this.parent;
                String user = y.verified.username;
                MessagesPanel.this.add(new DisplayMessages(MessagesPanel.this,user,receiver),1 );
                Connector x = new Connector();
                Statement stmt = (x).getStatement();
                stmt.execute("UPDATE messages SET read_status='1' WHERE sender='"+receiver+"' AND receiver='"+user+"'");
                x.close();}
                }
                
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
            }
            
        }
        
    }
    
    class UpdateMessagesList extends TimerTask{
        FriendsPanel x = new FriendsPanel(MessagesPanel.this.parent);
        @Override
        public void run() {
             synchronized(MessagesPanel.this.friendslist){
                 String [] people = x.getAllFriends();
                 if(people!=null){
                    MessagesPanel.this.friendslist.setListData(people);
                 }
             }
             
             Connector con = new Connector();
             YouChatMain y = (YouChatMain)MessagesPanel.this.parent;
                   String user = y.verified.username;
            try {
                ResultSet rs = con.getStatement().executeQuery("SELECT COUNT(*) FROM messages WHERE sender like '"+MessagesPanel.this.current_user+"' AND read_status ='0' AND receiver='"+user+"'");
                rs.next();
                if(rs.getInt(1)>0)
                {
                   MessagesPanel.this.getComponent(1).setVisible(false);
                   
                   MessagesPanel.this.add(new DisplayMessages(MessagesPanel.this,user,MessagesPanel.this.current_user),1 ); 
                   con.getStatement().execute("UPDATE messages SET read_status='1' WHERE sender='"+MessagesPanel.this.current_user+"' AND receiver='"+user+"'");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
             
             
        }
        
    }
               
      

        

   
}
