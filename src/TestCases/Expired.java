package TestCases;

import Cart.Cart;
import Checkout.CheckoutService;
import Customer.Customer;
import Product.Product;

import java.time.LocalDate;


public class Expired {
    public static void main(String[] args) {
        // ---------- Test 2: Expired Product ----------
        System.out.println("=== Test 2: Expired Product ===");
        Product expired = new Product("Milk", 80, 3, true, true, 1.0, LocalDate.now().minusDays(1));
        Customer customer2 = new Customer("Mona", 500);
        Cart cart2 = new Cart();
        cart2.add(expired, 1);
        CheckoutService.checkout(cart2, customer2);
        System.out.println();
    }
}
