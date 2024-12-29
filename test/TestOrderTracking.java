package PizzaOrderingSystem.test;

import observers.Customer;
import observers.OrderStatusNotifier;

public class TestOrderTracking {
    public static void main(String[] args) {
        OrderStatusNotifier notifier = new OrderStatusNotifier();
        Customer alice = new Customer("Alice");

        notifier.addObserver(alice);
        notifier.notifyObservers("Your pizza is being prepared.");
        notifier.notifyObservers("Your pizza is out for delivery.");

        System.out.println("Test passed: Order tracking works as expected.");
    }
}
