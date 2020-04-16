package coffeemachine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public enum CoffeeType {
    ESPRESSO(0,200,16,new BigDecimal(10)),
    LATTE(75,350,10,new BigDecimal(5)),
    UNKNOWN_TYPE(0,0,0,new BigDecimal(0));


    final Map<MachineResource,Integer> resourceOfCoffeesMap = new HashMap();
    BigDecimal cost;

    CoffeeType(int milk, int water, int coffeeBeans, BigDecimal cost) {
        resourceOfCoffeesMap.put(MachineResource.MILK, milk);
        resourceOfCoffeesMap.put(MachineResource.WATER,water);
        resourceOfCoffeesMap.put(MachineResource.BEANS,coffeeBeans);

        this.cost = cost;
    }
}




