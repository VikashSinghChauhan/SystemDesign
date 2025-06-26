import Observers.InventoryChecker;
import Product.Product;

import java.util.*;
import Observers.InventoryObserver;

public class Warehouse {
    private String wid;
    private String name;
    private String location;
    private Map<String, Product> products; //pid --> product

    InventoryChecker inventoryChecker;


    public  void addProduct(Product product, int quantity){
        String pid = product.getPid();
        if(products.containsKey(pid))
        {
            Product existingProduct = products.get(pid);
            existingProduct.addStock(quantity);
        }
        else{
            product.addStock(quantity);
            products.put(pid, product);
        }

        System.out.println(quantity + " units of " + product.getName()
        + " (SKU: " + pid + ") added to " + name
        + ". New Quantity: " + getAvailableQuantity(pid));
    }

    public  boolean removeProduct(String  pid,  int quantity){

        if(products.containsKey(pid))
        {
            Product product = products.get(pid);
            int currQuantity = product.getQuantity();
            if(currQuantity < product.getThreshold())
            {
                inventoryChecker.notifyObservers(product);
            }
            if(currQuantity >= quantity)
            {
                // sufficient inventory to remove
                product.removeStock(quantity);
                return  true;
            }
            else {
                System.out.println("Error: Insufficient inventory. Requested: "
                + quantity + ", Available: " + currQuantity);

                return false;
            }
        }
        return true;
    }
    public  int getAvailableQuantity(String  pid){
        if(products.containsKey(pid))
        {
            return products.get(pid).getQuantity();
        }
        return 0;
    }

    public Product getProductById(String pid)
    {
        if(products.containsKey(pid))
        {
            return products.get(pid);
        }
        return null;
    }

    public List<Product> getAllProduct(){
        return new ArrayList<>(products.values());
    }


    public Warehouse(String wid, String name, String location, InventoryChecker inventoryChecker) {
        this.wid = wid;
        this.name = name;
        this.location = location;
        this.products = new HashMap<>();
        this.inventoryChecker = inventoryChecker;
    }

    public String getWid() {
        return wid;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }





}
