package coffeemachine;

public class BuyAction implements Action {

    private final CoffeeMachine coffeeMachine;
    private final UserInputProvider userInputProvider;

    public BuyAction(CoffeeMachine coffeeMachine, UserInputProvider userInputProvider) {
        this.coffeeMachine = coffeeMachine;
        this.userInputProvider = userInputProvider;
    }

    @Override
    public void performAction() {
        System.out.println("Which coffee would you like to buy? \nESPRESSO \nLATTE");
        String input = userInputProvider.provideInput().toUpperCase();
        coffeeMachine.buyCoffe(CoffeeType.valueOf(input));
    }

}
