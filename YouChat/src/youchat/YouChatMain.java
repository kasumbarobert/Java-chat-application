/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youchat;

import com.sun.glass.ui.Cursor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author kasumba
 */
public class YouChatMain extends JFrame {
    
    private JPanel northPanel;
    private JPanel leftPanel,unreadPanel;
    public JPanel centerPanel;
    private JPanel southPanel,logPanel;
    private JButton home;
    private JButton friends;
    private JButton inbox,broadCast,logout,files;
    private JTextArea loggedinas;
    private JButton unread;
    private JTextArea files_count;
    public static LoginVerifier verified = null;
    
    public YouChatMain()
    {
        super("YouChat Join the fun!");
        this.initializeLeftPanel();
        //this.initializeNorthPanel();
        northPanel = new JPanel();
        northPanel.add(new Header());
        centerPanel = new JPanel();
        centerPanel.add(new Login(this));
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(northPanel, BorderLayout.NORTH); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000,539));
        this.setLocation(new Point(300,75));
        this.setVisible(true);
       this.setResizable(false);
       
        if(!verified.loggedin)
        {
       //    loggedinas.setVisible(false);
           this.home.setEnabled(false);
           this.inbox.setEnabled(false);
           this.friends.setEnabled(false); 
           this.home.setVisible(false);
           this.inbox.setVisible(false);
           this.friends.setVisible(false);
           this.broadCast.setVisible(false);  
        }
       
    }
    public void initializeLeftPanel()
    {
        leftPanel = new JPanel(new GridLayout(5, 1));  
        leftPanel.setPreferredSize(new Dimension(75,225));
        home = new JButton(new ImageIcon("icons/homeeee.jpg"));
        friends = new JButton(new ImageIcon("icons/friends.jpg"));
        inbox = new JButton(new ImageIcon("icons/inboxx.png"));
        broadCast = new JButton(new ImageIcon("icons/broadcast.png"));
        files = new JButton(new ImageIcon("icons/files.jpg"));
        leftPanel.add(home);
        leftPanel.add(friends);
        leftPanel.add(inbox);
        leftPanel.add(broadCast);
        leftPanel.add(files);
    }
    public void initializeNorthPanel(){
        loggedinas = new JTextArea();
        loggedinas.setEditable(false);
        loggedinas.setLineWrap(true);
        loggedinas.setBackground(this.getBackground());
        unread = new JButton();
        unread.setForeground(Color.red);
        unread.setVisible(false);
        unread.setIcon(new ImageIcon("icons/msg.png"));
        //unread.setBackground(Color.WHITE);
        unread.setMargin(new Insets(0,0,0,0));
        logout = new JButton(new ImageIcon("icons/logout.jpg"));
        logout.setBorderPainted(false);
       logout.setBackground(Color.BLACK);
        logout.setFont(new Font("TimesNewRoman",Font.PLAIN,30));
        logout.setVisible(false);
        logPanel = new JPanel();
        logPanel.setPreferredSize(new Dimension(150,100));
        //logPanel.setLayout(new BoxLayout(logPanel, BoxLayout.Y_AXIS));
        logPanel.setLayout(new GridLayout(2,1));
        logPanel.add(loggedinas);
        logPanel.add(logout);
        northPanel.add(logPanel);
        unreadPanel = new JPanel(new GridLayout(2,1));
        unread.setVerticalTextPosition(SwingConstants.CENTER);
        files_count= new JTextArea();
        files_count.setLineWrap(true);
        files_count.setWrapStyleWord(true);
        files_count.setEditable(false);
        files_count.setFont(new Font("SansSerif",Font.BOLD,17));
        unreadPanel.add(unread);
        unreadPanel.add(files_count);
        unreadPanel.setPreferredSize(new Dimension(215,100));
        northPanel.add(unreadPanel);
    }
    public void addEvents()
    {
        this.friends.addActionListener(new ShowFriends(this));
        this.inbox.addActionListener(new ShowMessages(this));
         this.addWindowListener(new Logout() );
         this.broadCast.addActionListener(new BroadCaster());
         this.logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Logout y = new Logout();
                try {
                    y.logOut();
                    YouChatMain.this.setVisible(false);
                    YouChatMain.this.dispose();
                    new YouChatMain();
                } catch (SQLException ex) {
                    System.out.println("Lost Connection....");
                    
                }
            }
             
         });
         this.home.addActionListener( new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    YouChatMain.this.centerPanel.getComponent(0).setVisible(false);
                    Connector theConnector = new Connector();
                    String username = YouChatMain.this.verified.username;
                    String name = YouChatMain.this.verified.name;
                    String pp = "icons/default.jpg";
                    ResultSet rs = theConnector.getStatement().executeQuery("SELECT profile_photo FROM user WHERE username='"+username+"'");
                    if(rs.next())
                    {
                        pp = rs.getString(1);
                    }
                    if(pp.isEmpty())
                    {
                        pp = "icons/default.jpg";
                    }
                    
                    theConnector.close();
                    UserProfile prof = new UserProfile(name,username,pp,1);
                    YouChatMain.this.centerPanel.add(prof,0);
                } catch (SQLException ex) {
                    Logger.getLogger(YouChatMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             
         }
         );
       this.unread.addActionListener(new ShowMessages(this));
       this.files.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                YouChatMain.this.centerPanel.getComponent(0).setVisible(false);
                YouChatMain.this.centerPanel.add(new FilePanel(YouChatMain.this),0);
            }
       });
    }
   
    public void unlockMenu()
    {
            this.initializeNorthPanel();
            this.addEvents();
          this.add(leftPanel, BorderLayout.WEST);
            this.home.setEnabled(true);
           this.inbox.setEnabled(true);
           this.friends.setEnabled(true);
           this.loggedinas.setText("Logged in as "+this.verified.name);
           unread.setVisible(true);
           unread.setText(this.getUnreadMessages()+" unread messages");
           this.loggedinas.setVisible(true);
           this.logout.setVisible(true);
           this.home.setVisible(true);
           this.inbox.setVisible(true);
           this.friends.setVisible(true);
           this.broadCast.setVisible(true);
           JLabel foot = new JLabel("Copyrights reserved for YouChat Inc.");
           foot.setHorizontalAlignment(SwingConstants.CENTER);
           this.add(foot, BorderLayout.SOUTH);
           TimerTask task = new UpdateUnReadMessages(this.verified.username);     
           Timer timer = new Timer(true);
           timer.scheduleAtFixedRate(task, 0, 3000);     
    } 
    
    
    
    public int getUnreadMessages()
    {
        Connector con = new Connector();
        String query = "SELECT COUNT(*) FROM messages WHERE receiver='"+this.verified.username+"' AND read_status = '0'";
        try {
            ResultSet rs=con.getStatement().executeQuery(query);
            rs.next();
            
            int n =rs.getInt(1);
            con.close();
            return n;
        } catch (SQLException ex) {
           System.out.println("Error in connecting to database...application closed: "+ex.getMessage());
           System.exit(0);
        }
        
        return -1;
    }
    
    public int []getFileCounts()
    {
        Connector con = new Connector();
        String query1 = "SELECT COUNT(*) FROM messages WHERE receiver='"+this.verified.username+"'AND file != ''";
        String query2 = "SELECT COUNT(*) FROM messages WHERE sender='"+this.verified.username+"' AND file != ''";
        try {
            ResultSet receive=con.getStatement().executeQuery(query1);
            receive.next();
            
            int n =receive.getInt(1);
            
            ResultSet sent=con.getStatement().executeQuery(query2);
            sent.next();
            
            int m =sent.getInt(1);
            int []files = {n,m};
            con.close();
            return files;
        } catch (SQLException ex) {
           System.out.println("Error in connecting to database...application closed: "+ex.getMessage());
           System.exit(0);
        }
        
        return null;
    }
    public static void main(String args[])
    {
        new YouChatMain();
    }
    
    class ShowFriends implements ActionListener{
        JFrame parent;
        public ShowFriends(JFrame parent)
        {
            this.parent = parent;
        }
         @Override
        public void actionPerformed(ActionEvent e) {
            YouChatMain x = (YouChatMain)parent;
           //x.centerPanel.getComponent(0)
            x.centerPanel.getComponent(0).setVisible(false);
             x.centerPanel.add(new FriendsPanel(parent),0);
        }
        
    }
    
    class Logout implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowClosing(WindowEvent e) {
            try {
                logOut();
            } catch (SQLException ex) {
                System.out.println("Problem: "+ex);
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {
           try {
                logOut();
            } catch (SQLException ex) {
                System.out.println("Problem: "+ex);
            }
        }

        @Override
        public void windowIconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowActivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        public void logOut() throws SQLException
        {
            String username = YouChatMain.this.verified.username;
            
            if(username != null)
            {
                Connector con = new Connector();
                Statement stmt = con.getStatement();
                stmt.execute("UPDATE user SET login_status = 0 WHERE username='"+username+"'");
                con.close();
            }
            
        }        
    }
    class ShowMessages implements ActionListener{
        JFrame parent;
        public ShowMessages(JFrame parent)
        {
            this.parent = parent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            YouChatMain x = (YouChatMain)parent;  
            x.centerPanel.getComponent(0).setVisible(false);
            x.centerPanel.add(new MessagesPanel(parent),0);
        }
        
}
    
    class UpdateUnReadMessages extends TimerTask{
        private Statement stmt;
        private String user;
        public UpdateUnReadMessages(String currentUser)
        {
            this.user = currentUser;
           
        }
        
        public void run()
        {
            int n = YouChatMain.this.getUnreadMessages();
            if(n==1)
            {
                YouChatMain.this.unread.setText(n +" unread message");
            }
            else{
                YouChatMain.this.unread.setText(n +" unread messages");
            }
            int []files = YouChatMain.this.getFileCounts();
            
            YouChatMain.this.files_count.setText(" Sent Files: "+files[1]+"\n Received Files: "+files[0]);
            
            
        }
    }
    
    class BroadCaster implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
           YouChatMain.this.centerPanel.getComponent(0).setVisible(false);
           YouChatMain.this.centerPanel.add(new SendBroadcastMsg(YouChatMain.this),0);
        }
    
    }
}
