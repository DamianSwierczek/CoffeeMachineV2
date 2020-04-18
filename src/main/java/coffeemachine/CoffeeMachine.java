package coffeemachine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

    private UserInputProvider userInputProvider;
    private BigDecimal cashInTheMachine = new BigDecimal(0);
    ActionFactory actionFactory;
    Map<MachineResource, Integer> coffeeMachineResourcesMap = new HashMap<>();


    public CoffeeMachine(UserInputProvider userInputProvider) {
        this.userInputProvider = userInputProvider;
        this.actionFactory = new ActionFactory(userInputProvider, this);
        initResources();

    }

    CoffeeType buyCoffe(CoffeeType coffeType) {
        if (checkIfItsEnoughResources(coffeType)) {
            removeResources(coffeType);
            payForCoffee(coffeType);
        }
        return coffeType;
    }

    private void performAction(Action action) {
        action.performAction();
    }


    public void initResources() {
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
            System.out.println("Pick action: 1 - Buy, 2 - Refill, 3 - Show current resources, 4 - Exit");
            performAction(actionFactory.getAction(userInputProvider.provideInput()));
        }
    }

    public void addMoney(BigDecimal paid) {
        cashInTheMachine = cashInTheMachine.add(paid);
    }

    public void showMoney() {
        System.out.println("Now we have: " + this.cashInTheMachine + "$");
    }

    private CoffeeType payForCoffee(CoffeeType coffeeType) {
        System.out.println("Pay for coffee: " + coffeeType.cost + "$");
        BigDecimal paid = new BigDecimal(userInputProvider.provideIntInput());
        addMoney(paid);
        return coffeeType;
    }
}
