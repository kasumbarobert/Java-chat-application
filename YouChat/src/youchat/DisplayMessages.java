package youchat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DisplayMessages extends JPanel{
    Connector conn;
    Statement stmt;
    private final JTextArea message ;
    private final JButton send;
    private JPanel parent;
    private String sender,receiver;
    private JLabel file;
    private JButton chose_file,file_remove;
    private String uploaded_file_path;
    private final String default_text = "Enter the new message here";
    public DisplayMessages(JPanel x,String user1,String user2) throws SQLException
    {
       sender = user1;
       receiver = user2;
       this.parent =x;
       conn =  new Connector();
       stmt= conn.getStatement();
       message = new JTextArea();
       message.setLineWrap(true);
       Color bg =new Color(200,200,150);
        this.file_remove = new JButton(new ImageIcon("icons/remove.png"));
        this.file_remove.setPreferredSize(new Dimension(20,27));
        String first = user1+"?"+user2;
        String second = user2+"?"+user1;
       file = new JLabel();
       Box panel = new Box(BoxLayout.Y_AXIS);
       this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
      JPanel bottom = new JPanel(new GridLayout(1,3));
     JLabel title = new JLabel("Your Messages with "+receiver);
     title.setHorizontalAlignment(SwingConstants.LEFT);
     title.setFont(new Font("SansSerif",Font.BOLD,18));
     this.add(title);
      JPanel text = new JPanel();
    
      text.setLayout(new BoxLayout(text,BoxLayout.Y_AXIS));
      String sql = "Select * FROM messages WHERE msg_id LIKE '"+first+"%' OR msg_id LIKE '"+second+"%' ORDER BY timestamp ASC ";
      Font style = new Font("Times New Roman",Font.PLAIN, 16);
     
       ResultSet rs = stmt.executeQuery(sql);
       int i=0;
       while(rs.next())
       {
           String msg = rs.getString("msg");
           JTextArea sms = new JTextArea(msg);
          
           sms.setEditable(false);
           
          
           JPanel space = new JPanel();
           space.setBackground(bg);
           
           sms.setFont(style);
           sms.setWrapStyleWord(true);
           sms.setLineWrap(true);
          // sms.setPreferredSize(new Dimension(400,100));
           if(rs.getString("sender").equals(user1))
           {
               sms.setForeground(Color.BLUE);
               sms.setBackground(bg);
               sms.setAlignmentX(LEFT_ALIGNMENT);
               //sms.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
               sms.setMargin(new Insets(0,80,0,0));
           }
           else
           {
              sms.setForeground(Color.RED);
               sms.setBackground(bg);
               sms.setAlignmentX(RIGHT_ALIGNMENT);
               //sms.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
               sms.setMargin(new Insets(0,20,60,0));
               
           }
           //sms.setAlignmentX(LEFT_ALIGNMENT);
          text.add(sms);
          //panel.add(sms);
          //this.add(sms);
          
          
           ///panel.add(space);
           text.add(space);
           
           i++;
       }
       this.chose_file = new JButton("Attach .txt file...");
      JPanel sendmsgpanel = new JPanel();
      sendmsgpanel.setLayout(new BoxLayout(sendmsgpanel,BoxLayout.Y_AXIS));
       message.setBackground(new Color(246,246,246));
       message.setFont(style);
       message.setAutoscrolls(true);
       message.setForeground(Color.ORANGE);
       this.send = new JButton("Send Message");
       send.addActionListener(new sendMessage());
       message.setMinimumSize(new Dimension(400,100));
      
      sendmsgpanel.add(message);
      bottom.add(this.chose_file);
      JPanel file_p = new JPanel();
       file_p.add(file);
       file_p.add(this.file_remove);
       this.file_remove.setVisible(false);
       bottom.add( file_p);
      bottom.add(this.send);
      message.setText(default_text);
      message.addFocusListener(new FocusListener(){
           @Override
           public void focusGained(FocusEvent e) {
               DisplayMessages.this.message.setText("");
           }

           @Override
           public void focusLost(FocusEvent e) {
              String content = DisplayMessages.this.message.getText();
              if(content.isEmpty())
              {
                DisplayMessages.this.message.setText(default_text);
              }
              else{
                  DisplayMessages.this.send.setText("Send Message");
              }
           }
      });
       this.chose_file.addActionListener(new AttachFile());
       sendmsgpanel.add(bottom);
       
       text.setBackground(bg);
       panel.setPreferredSize(new Dimension(400,340));
       panel.setMaximumSize(new Dimension(400,340));
       
       
       this.setBackground(bg);
       this.setVisible(true);
      
       
       
      JScrollPane msgs = new JScrollPane(text);
       msgs.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       this.add(msgs);
       this.add(sendmsgpanel);
      
       conn.close();
       
  this.file_remove.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               DisplayMessages.this.file.setText("");
               if(DisplayMessages.this.uploaded_file_path != null)
        {
            File x = new File(DisplayMessages.this.uploaded_file_path );

            x.delete();
        }
               DisplayMessages.this.file_remove.setVisible(false);
               DisplayMessages.this.send.setText("Send Message");
           }
      
  });
    }
    
   private class AttachFile implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             if(DisplayMessages.this.uploaded_file_path != null)
        {
            File x = new File(DisplayMessages.this.uploaded_file_path );

            x.delete();
        }

        JFileChooser getPhoto = new JFileChooser(new File("/uploaded_files"));
        FileNameExtensionFilter imgfilter = new FileNameExtensionFilter("Text files only","txt");
        
        getPhoto.setFileFilter(imgfilter);
        getPhoto.setDialogTitle("Choose your profile photo");
        if(getPhoto.showOpenDialog(DisplayMessages.this) == JFileChooser.APPROVE_OPTION){

            File uploadedPhoto = getPhoto.getSelectedFile();
            
            DisplayMessages.this.uploaded_file_path  = "uploaded_files/"+uploadedPhoto.getName();
            File userImage = new File(DisplayMessages.this.uploaded_file_path);
            try {
                FileOutputStream dest = new FileOutputStream(userImage);
                FileInputStream source = new FileInputStream(uploadedPhoto);
                byte []b = new byte[1024];
                try {

                    int i=0;
                    while((i=source.read(b))>=0)
                    {
                        dest.write(b,0,i);
                    }
                    dest.close();
                    source.close();
                    DisplayMessages.this.file.setText(uploadedPhoto.getName());
                    DisplayMessages.this.file_remove.setVisible(true);
                    if(DisplayMessages.this.message.getText().equals(default_text))
                    {
                        DisplayMessages.this.send.setText("Send File");
                    }
                    else{
                        DisplayMessages.this.send.setText("Send Message");
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        }
        }
       
   } 
    private class sendMessage implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            send(DisplayMessages.this.message.getText());
            if(!DisplayMessages.this.file.getText().isEmpty())
            {
                Date now = new Date();
                String message = DisplayMessages.this.sender+" sent a file "
                        + ""+DisplayMessages.this.file.getText()+" to "
                        + ""+DisplayMessages.this.receiver+" at "+now.toString();
                sendFile(message,"uploaded_files/"+DisplayMessages.this.file.getText());         
            }
            
        
    }
        
        public void send(String message)
        {
            String msg = message;
            Calendar now = new GregorianCalendar();
            long timeStamp = now.getTimeInMillis();
            String idBase = DisplayMessages.this.sender+"?"+DisplayMessages.this.receiver+"_";
            if(!msg.isEmpty() && !msg.equals("Enter the new message here"))
            {
                try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/youchat","root","");
                com.mysql.jdbc.Statement stmt = (com.mysql.jdbc.Statement) con.createStatement();
                String sql ="INSERT INTO messages(msg_id, sender, receiver, msg,timestamp) VALUES(?,?,?,?,?) ";
                PreparedStatement inserter = con.prepareStatement(sql);
                //count messages from this sender to the reciever
                ResultSet counter = stmt.executeQuery("SELECT COUNT(*) FROM messages WHERE msg_id like '"+idBase+"%'");
                
                if(counter.next())
                {
                    idBase+=(1+counter.getInt(1));
                }
                //store the message to the database
               
                inserter.setString(1, idBase);
                inserter.setString(2, DisplayMessages.this.sender);
                inserter.setString(3,receiver);
                inserter.setString(4, msg);
                inserter.setLong(5, timeStamp);
                inserter.execute();
               JOptionPane.showMessageDialog(parent,"Message sent");
               DisplayMessages.this.parent.getComponent(1).setVisible(false);
               DisplayMessages x =new DisplayMessages(DisplayMessages.this.parent,DisplayMessages.this.sender,DisplayMessages.this.receiver);
               DisplayMessages.this.parent.add(x,1);
               con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()+ "");
               System.exit(0);
            }
            
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage() + "");
                
               // this.parent.dispose();
            }
        }
        }
        public void sendFile(String message, String filepath)
        {
            String msg = message;
            Calendar now = new GregorianCalendar();
            long timeStamp = now.getTimeInMillis();
            String idBase = DisplayMessages.this.sender+"?"+DisplayMessages.this.receiver+"_";
            if(!msg.isEmpty())
            {
                try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/youchat","root","");
                com.mysql.jdbc.Statement stmt = (com.mysql.jdbc.Statement) con.createStatement();
                String sql ="INSERT INTO messages(msg_id, sender, receiver, msg,timestamp,file) VALUES(?,?,?,?,?,?) ";
                PreparedStatement inserter = con.prepareStatement(sql);
                //count messages from this sender to the reciever
                ResultSet counter = stmt.executeQuery("SELECT COUNT(*) FROM messages WHERE msg_id like '"+idBase+"%'");
                
                if(counter.next())
                {
                    idBase+=(1+counter.getInt(1));
                }
                //store the message to the database
               
                inserter.setString(1, idBase);
                inserter.setString(2, DisplayMessages.this.sender);
                inserter.setString(3,receiver);
                inserter.setString(4, msg);
                inserter.setLong(5, timeStamp);
                inserter.setString(6, filepath);
                inserter.execute();
               JOptionPane.showMessageDialog(parent,"File sent");
               DisplayMessages.this.parent.getComponent(1).setVisible(false);
               DisplayMessages x =new DisplayMessages(DisplayMessages.this.parent,DisplayMessages.this.sender,DisplayMessages.this.receiver);
               DisplayMessages.this.parent.add(x,1);
               con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()+ "");
               System.exit(0);
            }
            
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage() + "");
                
               // this.parent.dispose();
            }
        }
        }
}
}
