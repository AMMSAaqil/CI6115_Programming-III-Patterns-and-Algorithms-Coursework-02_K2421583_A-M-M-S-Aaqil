package decorators;

public class BasicPizza implements Pizza {
    @Override
    public void makePizza() {
        System.out.println("Making a basic pizza.");
    }
}
