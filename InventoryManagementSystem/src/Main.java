import Observers.InventoryChecker;
import Product.ProductCategory;
import Product.ProductFactory;
import Product.Product;
import Replenish.PerishableReplenishmentStrategy;
import Replenish.ThresholdBasedReplenishmentStrategy;

public class Main {
    public static void main(String[] args) {

       InventoryManager inventoryManager = InventoryManager.getInstance();

       //create adn add warehouses
        Warehouse warehouse1 = new Warehouse("1", "warehosue 1", "xyz",new InventoryChecker());
        Warehouse warehouse2 = new Warehouse("2", "wareshouse 2", "abc", new InventoryChecker());
        inventoryManager.addWareHouse(warehouse1);
        inventoryManager.addWareHouse(warehouse2);


        //create products using productFactory

        ProductFactory productFactory = new ProductFactory();
        Product laptop  =  productFactory.createProduct(ProductCategory.ELECTRONICS, "123",
               "laptop DELL", 30000, 3, 1);

        laptop.setStrategy(new ThresholdBasedReplenishmentStrategy());

        Product tshirt  = productFactory.createProduct(ProductCategory.CLOTHING, "456",
                "Tshirt", 300, 20, 5);

        tshirt.setStrategy(new ThresholdBasedReplenishmentStrategy());


        Product apple  = productFactory.createProduct(ProductCategory.GROCERY, "789",
                "Apple", 3, 300, 10);

        apple.setStrategy(new PerishableReplenishmentStrategy());

        warehouse1.addProduct(laptop, 12);
        warehouse1.addProduct(tshirt, 12);
        warehouse2.addProduct(apple, 50);

        inventoryManager.perfromInventoryCheck();

    }
}


/***
 * efficiently track, manage, optimize product inventory
 * handle multiple products,
 * tack stock levels  --> maintain threshold and trigger alert.
 * process orders --> (various operations, added, removed)
 * ensure timely replenishment.
 *
 *
 * operations ::
 * 1. add new products to inventory
 * 2. remove product
 * 3. generate alert for replenishment.
 */