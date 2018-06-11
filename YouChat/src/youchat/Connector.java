/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youchat;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kasumba
 */
public class Connector {
    Connection con ;
    Statement stmt;
    public Connector()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                 con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/youchat","root","");
                 stmt = (Statement) con.createStatement();
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()+ "");
               System.exit(0);
            }
    }catch(ClassNotFoundException ex)
        {
            System.out.println("Cannot connect to the db");
        }
    }
        public void close() throws SQLException
        {
            con.close();
        }
        
        public Statement getStatement()
        {
            return stmt;
        }
}
