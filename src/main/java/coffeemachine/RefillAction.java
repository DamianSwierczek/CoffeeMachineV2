package coffeemachine;

public class RefillAction implements Action {

    CoffeeMachine coffeeMachine;
    UserInputProvider userInputProvider;

    public RefillAction(CoffeeMachine coffeeMachine, UserInputProvider userInputProvider) {
        this.coffeeMachine = coffeeMachine;
        this.userInputProvider = userInputProvider;
    }

    @Override
    public void performAction() {
        System.out.println("What you want to refill? Water, Milk, or Beans ?");
        String input = userInputProvider.provideInput().toUpperCase();
        System.out.println("How much?");
        int quantity = userInputProvider.provideIntInput();
        coffeeMachine.refill(MachineResource.valueOf(input), quantity);
    }
}
