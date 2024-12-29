package chains;

public abstract class CustomizationHandler {
    protected CustomizationHandler nextHandler;

    public void setNextHandler(CustomizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String type, String value);
}
