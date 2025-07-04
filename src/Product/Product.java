package Product;
import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean expirable;
    private boolean shippable;
    private double weight; // applicable if shippable = true
    private LocalDate expiryDate; // applicable if expirable = true

    public Product(String name, double price, int quantity,
                   boolean expirable, boolean shippable,
                   double weight, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirable = expirable;
        this.shippable = shippable;
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        if (this.expirable && this.expiryDate != null) {
            return LocalDate.now().isAfter(this.expiryDate);
        }
        return false;
    }

    public boolean isExpirable() {
        return this.expirable;
    }

    public boolean requiresShipping() {
        return this.shippable;
    }

    public double getWeight() {
        if(this.shippable){
            return this.weight;
        }
        return 0.0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

/*    public void reduceQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough " + name + " in stock.");
        }
        quantity -= amount;
    }*/
}