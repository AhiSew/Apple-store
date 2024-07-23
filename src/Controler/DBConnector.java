
package Controler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    public static  Connection connect() throws ClassNotFoundException{
    
    Connection conn =null;
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/applestore","root","");
            return conn;
        
        } catch (SQLException e) {
             e.printStackTrace();
            return null;
        }
    
    
    
    
    
    
    
    
    
    
    }
}
