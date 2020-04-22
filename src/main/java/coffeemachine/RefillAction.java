package coffeemachine;

import java.util.InputMismatchException;

public class RefillAction implements Action {

    CoffeeMachine coffeeMachine;
    UserInputProvider userInputProvider;

    public RefillAction(CoffeeMachine coffeeMachine, UserInputProvider userInputProvider) {
        this.coffeeMachine = coffeeMachine;
        this.userInputProvider = userInputProvider;
    }

    @Override
    public void performAction() {
        System.out.println("What you want to refill? \nWater \nMilk \nBeans");
        String input = userInputProvider.provideInput().toUpperCase();
        try {
            MachineResource.valueOf(input);
            System.out.println("How much?");
            int quantity = userInputProvider.provideIntInput();
            coffeeMachine.refill(MachineResource.valueOf(input), quantity);
        } catch (IllegalArgumentException e){
            System.out.println("Wrong resource, try again");
        } catch (InputMismatchException e){
            System.out.println("We need some numbers here");
        }
    }

}
