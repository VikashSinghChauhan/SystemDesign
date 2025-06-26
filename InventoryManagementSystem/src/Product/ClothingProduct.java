package Product;

public class ClothingProduct extends Product{

    private String brand;



    public ClothingProduct(String pid, String name, double price, int quantity, int threshold) {
        super(pid, name, price, quantity, threshold, ProductCategory.CLOTHING);

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
