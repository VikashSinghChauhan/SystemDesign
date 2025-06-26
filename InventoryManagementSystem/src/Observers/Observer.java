package Observers;

import Product.Product;

public interface Observer {
    void onLowStock(Product product);
}
