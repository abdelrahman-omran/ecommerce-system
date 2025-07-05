package TestCases;

import Product.Product;
import Cart.*;
import Shipping.*;
import Customer.Customer;
import Checkout.CheckoutService;
import java.time.LocalDate;

public class Out_of_Stock {
    public static void main(String[] args) {
        // ---------- Test 3: Out of Stock ----------
        System.out.println("=== Test 3: Out of Stock ===");
        Product tv = new Product("TV", 300, 1, false, true, 5.0, null);
        Customer customer3 = new Customer("Tarek", 1000);
        Cart cart3 = new Cart();
        cart3.add(tv, 2); // more than available
        CheckoutService.checkout(cart3, customer3);
        System.out.println();
    }
}
