package main;

import builders.PizzaBuilder;
import commands.CommandInvoker;
import commands.PlaceOrderCommand;
import commands.ProvideFeedbackCommand;
import decorators.Pizza;
import decorators.BasicPizza;
import decorators.ExtraCheeseDecorator;
import decorators.ExtraToppingsDecorator;
import observers.Customer;
import observers.OrderStatusNotifier;
import states.OrderContext;
import strategies.CreditCardPayment;
import strategies.DigitalWalletPayment;
import strategies.LoyaltyPointsPayment;
import strategies.PaymentStrategy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Welcome to the Pizza Ordering System ---");

        // Ask for customer name
        System.out.println("Please enter your name: ");
        String customerName = scanner.nextLine();

        // 1. Pizza Customization (Builder)
        System.out.println("\nCustomize your pizza:");
        System.out.println("Choose crust (1-Regular, 2-Thin Crust): ");
        String crust = (scanner.nextInt() == 1) ? "Regular" : "Thin Crust";
        scanner.nextLine(); // Consume newline

        System.out.println("Choose sauce (1-Tomato Basil, 2-BBQ): ");
        String sauce = (scanner.nextInt() == 1) ? "Tomato Basil" : "BBQ";
        scanner.nextLine();

        System.out.println("Choose cheese (1-Mozzarella, 2-Cheddar): ");
        String cheese = (scanner.nextInt() == 1) ? "Mozzarella" : "Cheddar";
        scanner.nextLine();

        System.out.println("Enter toppings (comma-separated, e.g., Olives,Mushrooms): ");
        String[] toppings = scanner.nextLine().split(",");

        PizzaBuilder.Pizza pizza = new PizzaBuilder()
                .setCrust(crust)
                .setSauce(sauce)
                .setCheese(cheese)
                .setToppings(toppings)
                .build();
        System.out.println("\nYour pizza has been customized:");
        pizza.displayPizza();

        // 2. User Profile Management
        UserProfileManager profileManager = new UserProfileManager();
        String pizzaDetails = crust + ", " + sauce + ", " + cheese + ", " + String.join(", ", toppings);
        profileManager.saveFavorite(customerName, pizzaDetails);
        System.out.println(customerName + "'s favorite pizza: " + profileManager.getFavorite(customerName));

        // 3. Seasonal Promotions
        SeasonalPromotionsManager promotionsManager = new SeasonalPromotionsManager();
        promotionsManager.addPromotion("20% off all Pepperoni pizzas!");
        promotionsManager.addPromotion("Free extra cheese on Fridays!");
        System.out.println("\nAvailable promotions:");
        promotionsManager.displayPromotions();

        // 4. Real-Time Order Tracking (Observer)
        OrderStatusNotifier notifier = new OrderStatusNotifier();
        Customer customer = new Customer(customerName);
        notifier.addObserver(customer);

        System.out.println("\nTracking your order:");
        notifier.notifyObservers("Your pizza is being prepared.");
        notifier.notifyObservers("Your pizza is out for delivery.");
        notifier.notifyObservers("Your pizza has been delivered.");

        // 5. Payment (Strategy)
        System.out.println("\nChoose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Digital Wallet");
        System.out.println("3. Loyalty Points");
        int paymentChoice = scanner.nextInt();
        PaymentStrategy paymentStrategy;

        if (paymentChoice == 1) {
            scanner.nextLine(); // Consume newline
            System.out.println("Enter your credit card number: ");
            String cardNumber = scanner.nextLine();
            paymentStrategy = new CreditCardPayment(cardNumber);
        } else if (paymentChoice == 2) {
            System.out.println("Enter your wallet ID: ");
            scanner.nextLine(); // Consume newline
            String walletID = scanner.nextLine();
            paymentStrategy = new DigitalWalletPayment(walletID);
        } else {
            System.out.println("Enter available loyalty points: ");
            int points = scanner.nextInt();
            paymentStrategy = new LoyaltyPointsPayment(points);
        }

        paymentStrategy.pay(25.0);

        // 6. Order State Management
        OrderContext orderContext = new OrderContext();
        orderContext.printStatus();
        orderContext.nextState();
        orderContext.printStatus();
        orderContext.nextState();
        orderContext.printStatus();

        // 7. Command Pattern
        CommandInvoker invoker = new CommandInvoker();
        invoker.setCommand(new PlaceOrderCommand());
        invoker.executeCommand();
        System.out.println("\nWould you like to provide feedback? (1-Yes, 2-No): ");
        int feedbackChoice = scanner.nextInt();
        if (feedbackChoice == 1) {
            invoker.setCommand(new ProvideFeedbackCommand());
            invoker.executeCommand();
        }

        // 8. Pizza Decoration (Decorator)
        System.out.println("\nWould you like to add extra cheese and toppings to your pizza? (1-Yes, 2-No): ");
        int decorationChoice = scanner.nextInt();
        Pizza decoratedPizza = new BasicPizza();
        if (decorationChoice == 1) {
            decoratedPizza = new ExtraCheeseDecorator(decoratedPizza);
            decoratedPizza = new ExtraToppingsDecorator(decoratedPizza);
        }
        System.out.println("\nFinal pizza details:");
        decoratedPizza.makePizza();

        // Display Final Message
        System.out.println("\nThank you, " + customerName + ", for using the Pizza Ordering System!");
        scanner.close();
    }
}
