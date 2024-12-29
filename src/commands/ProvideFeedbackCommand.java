package commands;

public class ProvideFeedbackCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Thank you for your feedback!");
    }
}
