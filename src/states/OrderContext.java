package states;

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        state = new PlacedState(this); // Initial state
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.nextState();
    }

    public void prevState() {
        state.prevState();
    }

    public void printStatus() {
        state.printStatus();
    }
}
