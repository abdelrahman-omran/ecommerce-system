package TestCases;
import Product.Product;
import Cart.*;
import Shipping.*;
import Customer.Customer;
import Checkout.CheckoutService;
import java.time.LocalDate;

public class Normal {
    public static void main(String[] args) {
        // ---------- Test 1: Normal Checkout ----------
        System.out.println("=== Test 1: Normal Checkout ===");
        Product cheese = new Product("Cheese", 100, 5, true, true, 0.2, LocalDate.now().plusDays(5));
        Product biscuits = new Product("Biscuits", 150, 2, true, true, 0.7, LocalDate.now().plusDays(5));
        Customer customer1 = new Customer("Ali", 500);
        Cart cart1 = new Cart();
        cart1.add(cheese, 2);
        cart1.add(biscuits, 1);
        CheckoutService.checkout(cart1, customer1);
        System.out.println();
    }
}
