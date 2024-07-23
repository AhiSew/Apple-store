
package Controler;



import Model.User;
import Model.ProductDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;




public class ManagerControler extends  User{
    
    public ManagerControler(int userId, String userName, String userPassword, String userRole, String userEmail) throws ClassNotFoundException {
        super(userId, userName, userPassword, userRole, userEmail);
        conn = DBConnector.connect();
    }
     public void addProduct(ProductDetails product){
     
         try {
             String qry = "SELECT product_id FROM product_details WHERE product_name = ? ";
             PreparedStatement ps = conn.prepareStatement(qry);
             ps.setString(1, product.getProductName());
             ResultSet rs  = ps.executeQuery();
             
             if(rs.next()){
             
             JOptionPane.showMessageDialog(null, product.getProductName()+"  Is Allready In The Store!!!!");
             }
             else{
             
             String qry1 = "INSERT INTO  product_details (product_id,product_name,category,total_quantity,price) VALUES (?,?,?,?,?)";
             PreparedStatement ps1 = conn.prepareStatement(qry1);
             ps1.setInt(1, product.getProductId());
             ps1.setString(2, product.getProductName());
             ps1.setString(3, product.getProductcategory());
             ps1.setInt(4, product.getProductQuntity());
             ps1.setDouble(5, product.getProductPrice());
             ps1.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "add complite");
             
             }
             
         } catch (SQLException e) {
             
             e.fillInStackTrace();
         }
     
     }
     public void updateProduct(ProductDetails product){
     
         try {
             String qry = "UPDATE product_details SET product_name = ?,category = ? , total_quantity = ?, price = ? WHERE product_id = ?";
             PreparedStatement ps = conn.prepareStatement(qry);
         
             ps.setString(1, product.getProductName());
             ps.setString(2, product.getProductcategory());
             ps.setInt(3, product.getProductQuntity());
             ps.setDouble(4, product.getProductPrice());
             ps.setInt(5, product.getProductId());
             ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "updated!!!");
         } catch (SQLException e) {
             e.fillInStackTrace();
         }
     }
     public void removeProduct(ProductDetails product){
         try {
             String qry = "DELETE FROM product_details WHERE product_id= ?";
             PreparedStatement ps = conn.prepareStatement(qry);
             ps.setInt(1, product.getProductId());
             ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "removed!!!");
             
         } catch (Exception e) {
         }
     
     
     
     }
      public void loadTableData(JTable jTable) {
        try {
            String sql = "SELECT product_id, product_name, category , price,total_quantity FROM product_details";
            PreparedStatement pps = conn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();
            jTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
      
      public boolean createUsreAccount(String userName,String password,String userRole,String email){
      
      
      try {
            // Check if the username is available
            String checkQuery = "SELECT COUNT(*) FROM users_details WHERE user_name = ?";
            PreparedStatement checkStatement = conn.prepareStatement(checkQuery);
            checkStatement.setString(1, userName);
            ResultSet rs = checkStatement.executeQuery();
            rs.next();
            int userNameCount = rs.getInt(1);
            
            if (userNameCount > 0) {
                // Username available
                System.out.println("Username is  available. Please choose a different username.");
                return false;
            } else {
                //  create the new account
                String insertQuery = "INSERT INTO users_details (user_name, user_password, user_role, user_email) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
                insertStatement.setString(1, userName);
                insertStatement.setString(2, password);
                insertStatement.setString(3, userRole);
                insertStatement.setString(4, email);
                insertStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
 
      }
       public boolean  updateUserAccount(String userName,String password,String userRole,String email,int userId){
   
     try {
            String query = "UPDATE  users_details SET  user_name = ?, user_password = ?,user_role = ?,user_email = ? WHERE user = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,userName );
            ps.setString(2, password);
            ps.setString(3, userRole);
            ps.setString(4, email);  
            ps.setInt(5, userId); 
           
            ps.executeUpdate();
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
     }
       
       public boolean removeUserAccount(int userId){
      
      
       try {
            String query = "DELETE FROM users_details  WHERE user= ?";
            PreparedStatement  preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            return true;
            
        } catch (SQLException e) {
             e.printStackTrace();
             return false;
        }
      
     
      }
       
         public void tableLoardSell(JTable jTable){
        
         try {
             String sql = "SELECT  sells_id, product_id,product_name ,sells_quantity ,product_price FROM sells_detailss";
             PreparedStatement pps = conn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();
            jTable.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (Exception e) {
             
         }
         
     }
       
       public void loadTableDataUsers(JTable jTable) {
        try {
            String sql = "SELECT user,user_name , user_password,user_role, user_email FROM users_details ";
            PreparedStatement pps = conn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();
            jTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
       
}
