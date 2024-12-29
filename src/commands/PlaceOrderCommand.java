package commands;

public class PlaceOrderCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Order has been placed successfully.");
    }
}
