package TestCases;
import Product.Product;
import Cart.*;
import Shipping.*;
import Customer.Customer;
import Checkout.CheckoutService;
import java.time.LocalDate;

public class InsufficientBalance {
    public static void main(String[] args) {
        System.out.println("=== Test 4: Insufficient Balance ===");
        Product fridge = new Product("Fridge", 700, 2, false, true, 8.0, null);
        Customer customer4 = new Customer("Nada", 500); // not enough
        Cart cart4 = new Cart();
        cart4.add(fridge, 1);
        CheckoutService.checkout(cart4, customer4);
        System.out.println();
    }
}
