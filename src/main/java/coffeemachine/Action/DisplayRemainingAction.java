package coffeemachine.Action;

import coffeemachine.CoffeeMachine;
import coffeemachine.MachineResource;

import java.util.Map;

public class DisplayRemainingAction implements Action {

    CoffeeMachine coffeeMachine;

    public DisplayRemainingAction(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void performAction() {
        for (Map.Entry<MachineResource, Integer> entry : coffeeMachine.coffeeMachineResourcesMap.entrySet()) {
            System.out.println("Now we have " + entry.getValue() + " " + entry.getKey().name());
        }
        coffeeMachine.showMoney();
    }
}
