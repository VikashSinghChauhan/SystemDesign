package Replenish;

import Product.Product;
import Product.GroceryProduct;

import java.time.LocalDate;

public class PerishableReplenishmentStrategy implements ReplenishmentStrategy{
    @Override
    public void replenish(Product product) {
        if(product instanceof GroceryProduct)
        {
            GroceryProduct g = ((GroceryProduct) product);
            if(g.getExpiryDate().isBefore(LocalDate.now().plusDays(3)))
            {
                System.out.println("Reorder fresh stock for Product Id :: "+ g.getPid());
            }
        }
    }
}
