package Checkout;

import Product.Product;
import Cart.*;
import Shipping.*;
import Customer.Customer;
import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    private static final double SHIPPING_FEE_PER_ITEM = 10.0;

    public static void checkout(Cart cart, Customer customer) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        double shippingFees = 0;
        List<ShippableItem> itemsToShip = new ArrayList<>();


        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int qty = item.getQuantity();

            // Check stock
            if (qty > product.getQuantity()) {
                System.out.println("Error: " + product.getName() + " is out of stock.");
                return;
            }

            // Check expiry
            if (product.isExpirable() && product.isExpired()) {
                System.out.println("Error: " + product.getName() + " is expired.");
                return;
            }

            subtotal += product.getPrice() * qty;

            // Collect for shipping
            if (product.isShippable()) {
                itemsToShip.add(new ShippableItems(product, qty));
                shippingFees += SHIPPING_FEE_PER_ITEM * qty;
            }
        }

        double total = subtotal + shippingFees;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        // Deduct balance
        customer.pay(total);

        // Reduce stock
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Shipping
        if (!itemsToShip.isEmpty()) {
            ShippingService.ship(itemsToShip);
        }

        // Receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.2f\n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getProduct().getPrice() * item.getQuantity());
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal %.2f\n", subtotal);
        System.out.printf("Shipping %.2f\n", shippingFees);
        System.out.printf("Amount %.2f\n", total);
        System.out.println("----------------------");
        System.out.printf("Remaining balance %.2f\n", customer.getBalance());
    }
}

