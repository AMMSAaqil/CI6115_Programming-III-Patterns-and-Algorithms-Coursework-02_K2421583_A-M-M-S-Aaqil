package observers;

public class Customer {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void update(String status) {
        System.out.println("Notification for " + name + ": " + status);
    }
}
