package Product;
import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean expirable;
    private boolean shippable;
    private double weight;
    private LocalDate expiryDate;

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

    public void reduceQuantity(int amount) {
        if (amount > this.quantity) {
            System.out.println("Not enough " + this.name + " in stock.");
            return;
        }
        this.quantity -= amount;
    }
    public void addQuantity(int amount) {
        if (amount < 0) {
            System.out.println("Cannot add negative quantity.");
            return;
        }
        this.quantity += amount;
    }

    public void setPrice(double newPrice) {
        if (newPrice < 0) {
            System.out.println("Price cannot be negative.");
        }
        this.price = newPrice;
    }

    public boolean isExpirable() {
        return this.expirable;
    }

    public boolean isShippable() {
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
}