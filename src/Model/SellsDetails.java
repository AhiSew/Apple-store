
package Model;

import Model.ProductDetails;
public class SellsDetails extends ProductDetails{

  
   private int sellsId;
    private int sellQuantity;

   
  
    public SellsDetails(int productId, String productName, double productPrice, int productQuntity, String productcategory,int sellQuantity,int sellsId) {
        super(productId, productName, productPrice, productQuntity, productcategory);
        this.sellQuantity = sellQuantity;
      
        this.sellsId = sellsId;
    }
    
    public int getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(int sellQuantity) {
        this.sellQuantity = sellQuantity;
    }
      public int getSellsId() {
        return sellsId;
    }

    public void setSellsId(int sellsId) {
        this.sellsId = sellsId;
    }
   
}
