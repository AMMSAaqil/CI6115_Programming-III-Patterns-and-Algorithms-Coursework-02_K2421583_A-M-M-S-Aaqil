package chains;

public class CrustHandler extends CustomizationHandler {
    @Override
    public void handleRequest(String type, String value) {
        if (type.equalsIgnoreCase("crust")) {
            System.out.println("Crust set to: " + value);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(type, value);
        }
    }
}
