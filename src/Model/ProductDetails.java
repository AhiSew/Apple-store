
package Model;

public abstract  class ProductDetails {
    private int productId;
    private String productName;
    private double productPrice;
    private int productQuntity;
    private String productcategory;

    public ProductDetails(int productId, String productName, double productPrice, int productQuntity, String productcategory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuntity = productQuntity;
        this.productcategory = productcategory;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuntity() {
        return productQuntity;
    }

    public void setProductQuntity(int productQuntity) {
        this.productQuntity = productQuntity;
    }

    public String getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }
    
}
