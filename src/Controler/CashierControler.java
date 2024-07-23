
package Controler;

import Controler.DBConnector;
import java.sql.Connection;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.SellsDetails;
import static Model.User.conn;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class CashierControler extends User{
     private final Connection conn;
    
    public CashierControler(int userId, String userName, String userPassword, String userRole, String userEmail) throws ClassNotFoundException {
        super(userId, userName, userPassword, userRole, userEmail);
        
        conn = (Connection) DBConnector.connect();
        
    }
    public boolean sellProduct(SellsDetails sells)   {
    
        try {
            
//            Connection conn = (Connection) DbControler.connect();
             conn.setAutoCommit(false);  // Start a transaction
  
        String checkQuantityQuery = "SELECT total_quantity FROM product_details WHERE product_id = ?";
        PreparedStatement checkQuantityStatement = conn.prepareStatement(checkQuantityQuery);
        checkQuantityStatement.setInt(1, sells.getProductId());
        ResultSet resultSet = checkQuantityStatement.executeQuery();
        
        if (resultSet.next()) {
            int availableQuantity = resultSet.getInt("total_quantity");
            if (availableQuantity < sells.getSellQuantity()) {
                conn.rollback(); // Rollback the transaction
                return false; // Insufficient quantity
                
            }
        }else {
            conn.rollback(); // Rollback the transaction
            return false; // Product not found
        }
            // Record the sale in the sales table
        String insertSaleQuery = "INSERT INTO sells_detailss (sells_id,product_id, product_name,sells_quantity, product_price) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement insertSaleStatement = conn.prepareStatement(insertSaleQuery);
        insertSaleStatement.setInt(1, sells.getSellsId());
        insertSaleStatement.setInt(2, sells.getProductId());
        insertSaleStatement.setString(3, sells.getProductName()); // Assuming productName is a parameter
        
        insertSaleStatement.setDouble(5, sells.getProductPrice());
        insertSaleStatement.setInt(4, sells.getSellQuantity());
       
        insertSaleStatement.executeUpdate();
        
        // Update the product quantity in product_details
        String updateQuantityQuery = "UPDATE product_details SET total_quantity = total_quantity - ? WHERE product_id = ?";
        PreparedStatement updateQuantityStatement = conn.prepareStatement(updateQuantityQuery);
        updateQuantityStatement.setInt(1, sells.getProductQuntity());
        updateQuantityStatement.setInt(2, sells.getProductId());
        updateQuantityStatement.executeUpdate();

        conn.commit(); // Commit the transaction
        conn.setAutoCommit(true); // Reset the auto-commit mode
        
        return true; // Sale recorded and quantity updated
     
     
       
 
      
           
       
    } catch (SQLException e) {
 
        return false; // Sale recording failed
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
        public void loadTableDataProduct(JTable jTable) {
        try {
            String sql = "SELECT product_id, product_name, category,  total_quantity , price FROM product_details ";
            PreparedStatement pps = conn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();
            jTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
    
}
