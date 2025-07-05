import Product.Product;
import Cart.*;
import Shipping.*;
import Customer.Customer;
import Checkout.CheckoutService;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 5, true, true, 0.2, LocalDate.now().plusDays(10));
        Product tv = new Product("TV", 300, 2, false, true, 5.0, null);
        Product scratchCard = new Product("Scratch Card", 50, 10, false, false, 0.0, null);

        Cart cart1 = new Cart();
        cart1.add(cheese, 2);
        cart1.add(tv, 1);
        cart1.add(scratchCard, 1);

        Customer customer1 = new Customer("Ali", 600);
        CheckoutService.checkout(cart1, customer1);
    }
}