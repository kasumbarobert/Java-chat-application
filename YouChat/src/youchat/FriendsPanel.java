/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youchat;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author kasumba
 */
public class FriendsPanel extends JPanel {
    public JFrame parent;
    private MyFriends online,offline;
    private Connector theConnector;
    private String currentUser;
    public FriendsPanel(JFrame parent)
    {
        theConnector = new Connector();
        this.parent = parent;
        currentUser = ((YouChatMain)this.parent).verified.username;
        online = new MyFriends(this.parent,getOnlineFriends(),1);
         offline= new MyFriends(this.parent,getOfflineFriends(),0);
         online.setPreferredSize(new Dimension(420,342));
        this.setPreferredSize(new Dimension(863,342));
        this.setLayout(new GridLayout(1,2,3,0));
        add(online);
        add(offline);
        
        

        
        TimerTask updater = new UpdateLists();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(updater,2000, 3000);
    }
    
    private String []getOnlineFriends()
    {
        String sql = "SELECT name,username FROM user WHERE login_status=1 AND username NOT LIKE '"+this.currentUser+"'";
        String sql1 = "SELECT COUNT(*) FROM user WHERE login_status=1 AND username NOT LIKE '"+this.currentUser+"'";
       // System.out.println(sql);
        String [] friends;
        try {
             synchronized(theConnector){
            ResultSet rs1= theConnector.getStatement().executeQuery(sql1);
            rs1.next();
            friends = new String[rs1.getInt(1)];
            ResultSet rs= theConnector.getStatement().executeQuery(sql);
            int i=0;
            while(rs.next())
            {
                friends[i++] = rs.getString(1)+ " : "+rs.getString(2);
            }
            return friends;
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()+" genevive");
            return null;
        }
        
    }
    private String []getOfflineFriends()
    {
        String sql = "SELECT name,username FROM user WHERE login_status=0  AND username NOT LIKE '"+this.currentUser+"'";
        String sql1 = "SELECT COUNT(*) FROM user WHERE login_status=0  AND username NOT LIKE '"+this.currentUser+"'";
        String [] offLine;
        try {
            synchronized(theConnector){
            ResultSet rs1= theConnector.getStatement().executeQuery(sql1);
            rs1.next();
            offLine = new String[rs1.getInt(1)];
            ResultSet rs= theConnector.getStatement().executeQuery(sql);
            int i=0;
            while(rs.next())
            {
                offLine[i++] = rs.getString(1)+ " : "+rs.getString(2);
            }
            return offLine;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public String [] getAllFriends()
    {
        String sql = "SELECT name,username FROM user WHERE username NOT LIKE '"+this.currentUser+"' ";
        String sql1 = "SELECT COUNT(*) FROM user WHERE username NOT LIKE '"+this.currentUser+"' ";
        String [] offLine;
        String [] usernames;
        try {
            synchronized(theConnector){
            ResultSet rs1= theConnector.getStatement().executeQuery(sql1);
            rs1.next();
            offLine = new String[rs1.getInt(1)];
            usernames= new String[rs1.getInt(1)];
            ResultSet rs= theConnector.getStatement().executeQuery(sql);
            int i=0;
            while(rs.next())
            {
                offLine[i] = rs.getString(1)+ " : "+rs.getString(2);
                usernames[i]=rs.getString(2);
                i++;
            }
            i=0;
            for(;i<usernames.length; i++)
            {
                sql1 = "SELECT COUNT(*) FROM messages WHERE receiver  LIKE '"+this.currentUser+"' AND read_status ='0' AND sender ='"+usernames[i]+"'";
                rs = theConnector.getStatement().executeQuery(sql1);
                rs.next();
                if(rs.getInt(1)>0){
                    offLine[i]=offLine[i]+" ("+rs.getInt(1)+")";
                }
            }
            return offLine;
            }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        catch(NullPointerException ex)
        {
            System.out.println(ex.getCause());
            return null;
        }
        
    }
    public void close()
    {
        try {
            theConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(FriendsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    class UpdateLists extends TimerTask
    {

        @Override
        public void run() {
            synchronized(FriendsPanel.this.online)
            {
                FriendsPanel.this.online.list.setListData(FriendsPanel.this.getOnlineFriends());
            }
             synchronized( FriendsPanel.this.offline){
                     FriendsPanel.this.offline.list.setListData(FriendsPanel.this.getOfflineFriends());
             }
        }
        
    }
}
