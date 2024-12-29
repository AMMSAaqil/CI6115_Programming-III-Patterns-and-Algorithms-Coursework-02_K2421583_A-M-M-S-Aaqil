package states;

public class DeliveredState implements OrderState {
    private final OrderContext context;

    public DeliveredState(OrderContext context) {
        this.context = context;
    }

    @Override
    public void nextState() {
        System.out.println("Order is already in the final state (Delivered).");
    }

    @Override
    public void prevState() {
        System.out.println("Moving back to 'Delivering' state.");
        context.setState(new DeliveringState(context));
    }

    @Override
    public void printStatus() {
        System.out.println("Order has been delivered.");
    }
}
