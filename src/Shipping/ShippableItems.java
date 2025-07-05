package Shipping;
import Product.Product;
public class ShippableItems implements ShippableItem {
    private Product product;
    private int quantity;

    public ShippableItems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return this.quantity + "x " + this.product.getName();
    }

    @Override
    public double getWeight() {
        return this.product.getWeight() * this.quantity;
    }
}
