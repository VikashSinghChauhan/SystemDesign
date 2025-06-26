package Observers;

import Product.Product;

public class InventoryObserver implements Observer{
    @Override
    public void onLowStock(Product product) {
        product.executeReplenishment();
    }
}
