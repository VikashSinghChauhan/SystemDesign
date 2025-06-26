package Product;

public class ProductFactory {

    public Product createProduct(ProductCategory category, String pid,
                                 String name, double price, int quantity, int threshold)
    {
        switch (category){
            case ELECTRONICS:
                return new EletronicsProduct(pid, name, price, quantity, threshold);
            case CLOTHING:
                return new ClothingProduct(pid, name, price, quantity, threshold);
            case GROCERY:
                return new GroceryProduct(pid, name, price, quantity, threshold);
            default:
                throw new IllegalArgumentException(
                        "Unsupported product category : " + category
                );
        }
    }
}
