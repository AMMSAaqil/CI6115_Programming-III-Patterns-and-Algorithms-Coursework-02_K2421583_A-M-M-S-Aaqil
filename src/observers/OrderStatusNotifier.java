package observers;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusNotifier {
    private final List<Customer> customers = new ArrayList<>();

    public void addObserver(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getName() + " has been added to the notification list.");
    }

    public void removeObserver(Customer customer) {
        customers.remove(customer);
        System.out.println(customer.getName() + " has been removed from the notification list.");
    }

    public void notifyObservers(String status) {
        for (Customer customer : customers) {
            customer.update(status);
        }
    }
}
