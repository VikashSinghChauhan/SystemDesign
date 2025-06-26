package Replenish;

import Product.Product;

/**
 * This is an interface for different replenishment strategies. It declares a method replenish(Product product) that will be
 * implemented by concrete strategies to provide various ways to replenish stock for a given product
 */
public interface ReplenishmentStrategy {
    void replenish(Product product);
}
