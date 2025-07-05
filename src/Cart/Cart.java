package Cart;
import Product.Product;
import java.util.*;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    // Add product with quantity
    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }
        if (quantity > product.getQuantity()) {
            System.out.println("Quantity exceeds available stock for " + product.getName());
            return;
        }

        // Check if product is already in cart
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                int newQty = item.getQuantity() + quantity;
                if (newQty > product.getQuantity()) {
                    System.out.println("Combined quantity exceeds available stock.");
                    return;
                }
                item.setQuantity(newQty);
                return;
            }
        }

        //if not in cart (new Item)
        items.add(new CartItem(product, quantity));
    }

    // Remove a product
    public void remove(Product product) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().equals(product)) {
                items.remove(i);
                i--;
            }
        }
    }
    public List<CartItem> getItems() {
        List<CartItem> copy = new ArrayList<>();
        copy.addAll(this.items);
        return copy;
    }
    // remove all items
    public void clear() {
        items.clear();
    }

    // Check if cart is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Get total subtotal
    public double getSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }
        return subtotal;
    }


    public void printCart() {
        if (isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Items in Cart:");
            for (CartItem item : items) {
                System.out.printf("%dx %s (%.2f each)\n", item.getQuantity(),
                        item.getProduct().getName(), item.getProduct().getPrice());
            }
        }
    }
}
