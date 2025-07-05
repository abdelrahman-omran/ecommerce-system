package TestCases;

import Cart.Cart;
import Checkout.CheckoutService;
import Customer.Customer;
import Product.Product;

import java.time.LocalDate;

public class EmptyCart {
    // ---------- Test 5: Empty Cart ----------
    public static void main(String[] args) {
        System.out.println("=== Test 5: Empty Cart ===");
        Customer customer5 = new Customer("Youssef", 500);
        Cart cart5 = new Cart();
        CheckoutService.checkout(cart5, customer5);
        System.out.println();
    }
}
