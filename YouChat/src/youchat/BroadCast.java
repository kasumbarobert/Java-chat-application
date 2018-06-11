/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youchat;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author sol1ema
 */
public class BroadCast {
    private String message, user;
    private int count;
    public BroadCast(String sender,String msg)
    {
         this.message = msg;
        this.user = sender;
    }
    
    public int getCount()
    {
        return this.count;
    }
    public boolean sendMessage()
    {
        String msg =this.message;
        String sender = this.user;
        String users[] = null;
    try{
            Class.forName("com.mysql.jdbc.Driver");
            
            
                com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/youchat","root","");
                com.mysql.jdbc.Statement stmt = (com.mysql.jdbc.Statement) con.createStatement();
       
               try {
            String sql2="SELECT username FROM user WHERE username !='"+user+"'";
            //
            ResultSet rs = stmt.executeQuery(sql2);
             String rec;
            String idBase;
            String sql,recepient;        
            ArrayList ar = new ArrayList();
            Object[] names = null;
            while(rs.next())
            {
                recepient = rs.getString("username");
                ar.add(recepient);
                
            }
                names = ar.toArray();
                this.count = names.length;
                for (int i=0;i<names.length;i++)
                {
                    rec = (String) names[i];
                    idBase = user+"?"+rec+"_";
                    sql ="INSERT INTO messages(msg_id, sender, receiver, msg,timestamp) VALUES(?,?,?,?,?) ";
               
                      PreparedStatement inserter = con.prepareStatement(sql);
                       ResultSet counter = stmt.executeQuery("SELECT COUNT(*) FROM messages WHERE msg_id like '"+idBase+"%'");
                
                if(counter.next())
                {
                    idBase+=(1+counter.getInt(1));
                }
                
                Calendar now = new GregorianCalendar();
                long timeStamp = now.getTimeInMillis();
                
                inserter.setString(1, idBase);
                inserter.setString(2, user);
                inserter.setString(3,rec);
                inserter.setString(4, msg);
                inserter.setLong(5, timeStamp);
                inserter.execute();
               // System.out.println(sender+" , "+rec+" , "+msg);
                }
                con.close();
                return true;
            
               }
               
                catch(SQLException e)
                    {
                        System.out.println(e.getMessage());
                        return false;
                    }
    }
    catch(SQLException e)
    {
        System.out.println(e.getMessage());
                        return false;
    }
    catch(ClassNotFoundException ex)
    {
      System.out.println(ex.getMessage());
      return false;  
    }
    
    }
     
    
}
