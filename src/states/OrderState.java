package states;

public interface OrderState {
    void nextState();
    void prevState();
    void printStatus();
}
