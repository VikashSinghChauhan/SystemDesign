package Product;//This class represents individual products with their attributes.


import Replenish.ReplenishmentStrategy;

public abstract class Product {
    private String pid;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    private ProductCategory productCategory;

    private ReplenishmentStrategy strategy;


    public Product(String pid, String name, double price, int quantity, int threshold, ProductCategory productCategory) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.threshold = threshold;
        this.productCategory = productCategory;
    }

    public void executeReplenishment(){
        if(strategy != null)
        {
            strategy.replenish(this);
        }
    }

    public void addStock(int quantity)
    {
        this.quantity  = this.quantity + quantity;
    }

    public void removeStock(int quantity)
    {
        this.quantity = this.quantity - quantity;
    }

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }


    public void setStrategy(ReplenishmentStrategy strategy) {
        this.strategy = strategy;
    }
}
