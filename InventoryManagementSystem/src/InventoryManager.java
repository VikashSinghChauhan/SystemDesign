import Product.ProductFactory;
import Replenish.ReplenishmentStrategy;
import Product.Product;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

// This class handles inventory operations and uses the singleton pattern.
public class InventoryManager {
    private static InventoryManager instance;
    private List<Warehouse> warehouses;
    private ProductFactory productFactory;
//    private List<Observer> observers;





    //static method to get the singleton instance with thread safety
    public static synchronized InventoryManager getInstance()
    {
        if(instance == null)
        {
            instance = new InventoryManager();
            instance.warehouses  = new ArrayList<>();
            instance.productFactory = new ProductFactory();
        }
        return instance;
    }


    public void addWareHouse(Warehouse warehouse)
    {
        warehouses.add(warehouse);
    }

    public void removeWareHouse(Warehouse warehouse)
    {
        warehouses.remove(warehouse);
    }


    public Product getProductById(String pid)
    {
        for(Warehouse warehouse : warehouses)
        {
            Product product = warehouse.getProductById(pid);
            if(product!=null)return product;
        }
        return null;
    }

    //check stock levels and apply replenishmetn strategy if needed
//    public void checkAndReplenish(String pid)
//    {
//        Product product = getProductById(pid);
//        if(product!=null)
//        {
//            if(product.getThreshold() < product.getThreshold())
//            {
//                //
//            }
//            if(replenishmentStrategy != null)
//            {
//                replenishmentStrategy.replenish(product);
//            }
//        }
//    }

    //global inventory check
    public void perfromInventoryCheck(){
        for(Warehouse warehouse : warehouses)
        {
            for(Product product : warehouse.getAllProduct())
            {
                if(product.getQuantity() < product.getThreshold())
                {
                    //nofify
                    product.executeReplenishment();
                }
            }
        }
    }


}

/***
 * Singleton design pattern for Inventory Manager.
 * Observer design pattern for Inventory alerts
 * Factory pattern for product creation --> allows easy addition.
 * strategy pattern for replenishment.
 */

/***
 * Design challenges
 * 1. concurrency -> handling large number of products and warehouses
 * 2. Data consistency -> Ensuring accurate inventory counts across system
 * 3. Customizable replensishment -> supporting different replenishment strategies
 * 4. Edge cases: handling product returns, damaged inventory, and seasonal demand fluctuations.
 */



