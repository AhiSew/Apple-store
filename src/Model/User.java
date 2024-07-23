
package Model;
import Controler.DBConnector;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class User {
    
       private int userId;
     private String userName;
     private String userPassword;
     private String userRole;
     private String userEmail;
     public static Connection conn ;
    public User(int userId, String userName, String userPassword, String userRole, String userEmail) throws ClassNotFoundException {
        
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.userEmail = userEmail;
        conn=DBConnector.connect();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

  

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
   public boolean authentication(String user_name,String user_password){
   
   
       try {
           String qry = " SELECT user FROM users_details WHERE user_name = ? AND user_password = ?";
           PreparedStatement ps = conn.prepareStatement(qry);
           ps.setString(1,user_name);
           ps.setString(2, user_password);
           ResultSet  rs = ps.executeQuery();
           return rs.next();
           
       } catch (SQLException e) {
           e.printStackTrace();
           return  false;
       }
  
}
     public String getUserRole() throws SQLException {
        String qry = "SELECT user_role FROM users_details WHERE user_name = ?";
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
        
        return rs.getString("user_role");
        
        }
        return  null;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
