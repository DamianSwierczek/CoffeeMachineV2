package coffeemachine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

    private UserInputProvider userInputProvider;
    private BigDecimal cashInTheMachine = new BigDecimal(0);
    BigDecimal paid;
    ActionFactory actionFactory;
    Map<MachineResource, Integer> coffeeMachineResourcesMap = new HashMap<>();


    public CoffeeMachine(UserInputProvider userInputProvider) {
        this.userInputProvider = userInputProvider;
        this.actionFactory = new ActionFactory(userInputProvider, this);
        initResources();

    }

    CoffeeType buyCoffe(CoffeeType coffeType) {
        payForCoffee(coffeType);
        if (checkIfItsEnoughResources(coffeType) && checkIfItsEnoughMoney(paid,coffeType)) {
            addMoney(paid);
            removeResources(coffeType);
        }
        return coffeType;
    }

    private void performAction(Action action) {
        action.performAction();
    }


    private void initResources() {
        coffeeMachineResourcesMap.put(MachineResource.MILK, 500);
        coffeeMachineResourcesMap.put(MachineResource.WATER, 500);
        coffeeMachineResourcesMap.put(MachineResource.BEANS, 100);
    }

    public void refill(MachineResource machineResource, Integer value) {
        coffeeMachineResourcesMap.put(machineResource, coffeeMachineResourcesMap.get(machineResource) + value);
    }

    private void removeResources(CoffeeType coffeeType) {
        for (Map.Entry<MachineResource, Integer> entry : coffeeType.resourceOfCoffeesMap.entrySet()) {
            coffeeMachineResourcesMap.put(entry.getKey(), coffeeMachineResourcesMap.get(entry.getKey()) - entry.getValue());
        }
    }

    private boolean checkIfItsEnoughResources(CoffeeType coffeeType) {
        boolean isEnough = true;
        for (Map.Entry<MachineResource, Integer> entry : coffeeType.resourceOfCoffeesMap.entrySet()) {
            if (coffeeMachineResourcesMap.get(entry.getKey()) < entry.getValue()) {
                System.out.println("Not enough: " + entry.getKey());
                isEnough = false;
            }
        }
        return isEnough;
    }

    public void run() {
        while (true) {
            System.out.println("Pick action: \n1 - Buy \n2 - Refill \n3 - Show current resources \n4 - Exit");
            performAction(actionFactory.getAction(userInputProvider.provideInput()));
        }
    }

    private void addMoney(BigDecimal paid) {
        cashInTheMachine = cashInTheMachine.add(paid);
    }

    public void showMoney() {
        System.out.println("Now we have: " + this.cashInTheMachine + "$");
    }

    private CoffeeType payForCoffee(CoffeeType coffeeType) {
        System.out.println("Pay for coffee: " + coffeeType.cost + "$");
        paid = new BigDecimal(userInputProvider.provideIntInput());
        return coffeeType;
    }

    private boolean checkIfItsEnoughMoney(BigDecimal paid, CoffeeType coffeeType) {
        boolean isEnough = true;
        int comparison = paid.compareTo(coffeeType.cost);
        switch (comparison) {
            case 0:
                System.out.println("No change for you \nPreparing: " + coffeeType);
                break;
            case 1:
                BigDecimal substraction = new BigDecimal(0);
                substraction = paid.subtract(coffeeType.cost);
                this.paid = coffeeType.cost;
                System.out.print("Here's your change: " + substraction + "$\nPreparing: " + coffeeType + "\n");
                break;
            case -1:
                System.out.println("Not enough money, try again");
                isEnough = false;
                break;
        }
        return isEnough;
    }

}
