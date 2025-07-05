package Customer;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public void pay(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
    }

    public void chargeBalance(double amount) {
        if (amount < 0) {
            System.out.println("Cannot add negative funds.");
            return;
        }
        balance += amount;
    }
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

}
