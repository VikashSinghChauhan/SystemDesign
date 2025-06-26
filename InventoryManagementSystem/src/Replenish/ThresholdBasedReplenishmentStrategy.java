package Replenish;

import Product.Product;

public class ThresholdBasedReplenishmentStrategy implements ReplenishmentStrategy{
    @Override
    public void replenish(Product product) {
        if(product.getQuantity() < product.getThreshold())
        {
            System.out.println("Reorder triggered for Product id : " + product.getPid());
        }
    }
}
