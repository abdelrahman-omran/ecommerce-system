import Product.Product;
import Cart.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 5, true, true, 0.2, LocalDate.now().plusDays(10));
        Product tv = new Product("TV", 300, 2, false, true, 5.0, null);
        Product scratchCard = new Product("Scratch Card", 50, 10, false, false, 0.0, null);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);

        if(!cart.isEmpty())
            cart.printCart();
        else
            System.out.println("Cart is Empty");
    }
}