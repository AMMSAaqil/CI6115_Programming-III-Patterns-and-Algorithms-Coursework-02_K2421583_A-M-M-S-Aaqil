package chains;

public class SauceHandler extends CustomizationHandler {
    @Override
    public void handleRequest(String type, String value) {
        if (type.equalsIgnoreCase("sauce")) {
            System.out.println("Sauce set to: " + value);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(type, value);
        }
    }
}
