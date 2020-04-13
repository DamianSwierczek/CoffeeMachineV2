package coffeemachine;

import java.math.BigDecimal;

public class BuyAction implements Action {

    private static final String ESPRESSO = "1";
    private static final String LATTE = "2";
    private final CoffeeMachine coffeeMachine;
    private final UserInputProvider userInputProvider;

    public BuyAction(CoffeeMachine coffeeMachine, UserInputProvider userInputProvider) {
        this.coffeeMachine = coffeeMachine;
        this.userInputProvider = userInputProvider;
    }


    @Override
    public void performAction() {
        System.out.println("Which coffee would you like to buy? ESPRESSO, LATTE");
        CoffeeType coffeType = chooseCoffee(userInputProvider.provideInput().toUpperCase());
        System.out.println("Pay for coffee " + coffeType.cost);
        BigDecimal paid = new BigDecimal(userInputProvider.provideInput());
        coffeeMachine.addMoney(paid);
        try {
            System.out.println(coffeeMachine.buyCoffe(coffeType));
        } catch (Exception e) {
            System.err.println("Something went wrong" + e.getMessage());
        }

    }

    private CoffeeType chooseCoffee(String input) {
        return CoffeeType.valueOf(input);
    }
}
