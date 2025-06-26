package Product;

public class EletronicsProduct extends  Product{

    private String brand;
    private int warrantyPeriod;


    public EletronicsProduct(String pid, String name, double price, int quantity, int threshold) {
        super(pid, name, price, quantity, threshold, ProductCategory.ELECTRONICS);
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
}
