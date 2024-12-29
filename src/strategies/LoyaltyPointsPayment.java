package strategies;

public class LoyaltyPointsPayment implements PaymentStrategy {
    private int points;

    public LoyaltyPointsPayment(int points) {
        this.points = points;
    }

    @Override
    public void pay(double amount) {
        int requiredPoints = (int) (amount * 10); // 1 dollar = 10 points
        if (points >= requiredPoints) {
            points -= requiredPoints;
            System.out.println("Paid $" + amount + " using " + requiredPoints + " loyalty points. Remaining points: " + points);
        } else {
            System.out.println("Insufficient loyalty points. Need " + requiredPoints + ", but have only " + points);
        }
    }
}
