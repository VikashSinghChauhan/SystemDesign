package Product;

import java.time.Instant;
import java.time.LocalDate;

public class GroceryProduct extends Product{

    private String brand;
    private LocalDate expiryDate = LocalDate.now();

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public GroceryProduct(String pid, String name, double price, int quantity, int threshold) {
        super(pid, name, price, quantity, threshold, ProductCategory.GROCERY);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
