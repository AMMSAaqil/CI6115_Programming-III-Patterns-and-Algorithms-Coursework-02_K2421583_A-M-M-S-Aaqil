package strategies;

public class DigitalWalletPayment implements PaymentStrategy {
    private final String walletId;

    public DigitalWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Digital Wallet: " + maskWalletId(walletId));
    }

    private String maskWalletId(String walletId) {
        if (walletId.length() < 4) return "****";
        return "****-****-" + walletId.substring(walletId.length() - 4);
    }
}
