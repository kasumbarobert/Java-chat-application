/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youchat;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kasumba
 */
public class LoginVerifier {
    public static boolean loggedin = false;
    public static String username;
    public static String name;
    public LoginVerifier(String username, String password)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/youchat","root","");
                Statement stmt = (Statement) con.createStatement();
                String query =""
                        + "SELECT * FROM user WHERE username ='"+username+"' AND password='"+password+"'";
                //System.out.println(query);
                ResultSet rs = stmt.executeQuery(query);
                
                if(rs.next())
                {
                    this.username = username;
                    this.name = rs.getString("name");
                    loggedin = true;
                    stmt.executeUpdate("UPDATE user SET login_status = 1 WHERE username ='"+username+"'");
                }
                
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()+ "");
               System.exit(0);
            }
            
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage() + "");
            System.exit(0); 
            
        }
    }
    
    public int getLoginStatus()
    {
      if(loggedin)
      {
          return 1;
      }
      else{
          return 0;
      }
    }
}
