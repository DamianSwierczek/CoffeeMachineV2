package coffeemachine;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum CoffeeType {
    ESPRESSO(0, 200, 16, new BigDecimal(10)),
    LATTE(75, 350, 10, new BigDecimal(5)),
    UNKNOWN_TYPE(0, 0, 0, new BigDecimal(0));


    Map<MachineResource, Integer> resourceOfCoffeesMap = new HashMap();
    BigDecimal cost;

    CoffeeType(int milk, int water, int coffeeBeans, BigDecimal cost) {
        resourceOfCoffeesMap = Collections.unmodifiableMap(Map.of(MachineResource.MILK, milk,
                MachineResource.WATER, water,
                MachineResource.BEANS, coffeeBeans));

        this.cost = cost;
    }
}




