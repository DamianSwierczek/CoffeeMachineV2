package coffeemachine;

public class ActionFactory {

    private static final String BUY_ACTION = "1";
    private static final String REFILL_ACTION = "2";
    private static final String REMAINING_ACTION = "3";
    private static final String EXIT_ACTION = "4";
    private UserInputProvider userInputProvider;
    private CoffeeMachine coffeeMachine;

    public ActionFactory(UserInputProvider userInputProvider, CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
        this.userInputProvider = userInputProvider;
    }

    public Action getAction(String input) {
        switch (input) {
            case BUY_ACTION:
                return new BuyAction(coffeeMachine, userInputProvider);

            case REFILL_ACTION:
                return new RefillAction(coffeeMachine,userInputProvider);

            case REMAINING_ACTION:
                return new DisplayRemainingAction(coffeeMachine);

            default:
                return new UnknownAction();

        }
    }
}
