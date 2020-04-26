package coffeemachine;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;


class CoffeeMachineTest {

    @Test

    public void testIfBuyingOneLatteCostFiveDollars() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Test 1");
        String amountToPay = "5\r\n";
        String coffeeType = "LATTE\r\n";
        String buyAction = "1\r\n";

        System.setIn(new ByteArrayInputStream((buyAction + coffeeType + amountToPay).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            Field cashInMachine = coffeeMachine.getClass().getDeclaredField("cashInTheMachine");
            cashInMachine.setAccessible(true);
            BigDecimal value = (BigDecimal) cashInMachine.get(coffeeMachine);
            Assert.assertSame(5, value.intValue());
        }
    }

    @Test

    public void testIfBuyingOneEspressoCostTenDollars() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Test 2");
        String amountToPay = "10\r\n";
        String coffeeType = "ESPRESSO\r\n";
        String buyAction = "1\r\n";

        System.setIn(new ByteArrayInputStream((buyAction + coffeeType + amountToPay).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            Field cashInMachine = coffeeMachine.getClass().getDeclaredField("cashInTheMachine");
            cashInMachine.setAccessible(true);
            BigDecimal value = (BigDecimal) cashInMachine.get(coffeeMachine);
            Assert.assertSame(10, value.intValue());
        }
    }

    @Test

    public void testIfBuyingOneLatteTakeProperValueOfMilk() {
        System.out.println("Test 3");
        String amountToPay = "5\n";
        String coffeeType = "LATTE\n";
        String buyAction = "1\n";

        System.setIn(new ByteArrayInputStream((buyAction + coffeeType + amountToPay).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            int remainingMilkInMachine = coffeeMachine.coffeeMachineResourcesMap.get(MachineResource.MILK);
            Assert.assertEquals(425, remainingMilkInMachine);
        }
    }

    @Test
    public void testIfBuyingOneLatteTakeProperValueOfWater() {
        System.out.println("Test 4");
        String amountToPay = "5\n";
        String coffeeType = "LATTE\n";
        String buyAction = "1\n";

        System.setIn(new ByteArrayInputStream((buyAction + coffeeType + amountToPay).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            int remainingWaterInMachine = coffeeMachine.coffeeMachineResourcesMap.get(MachineResource.WATER);
            Assert.assertEquals(150, remainingWaterInMachine);
        }
    }

    @Test
    public void testIfBuyingOneLatteTakeProperValueOfBeans() {
        System.out.println("Test 5");
        String amountToPay = "5\n";
        String coffeeType = "LATTE\n";
        String buyAction = "1\n";

        System.setIn(new ByteArrayInputStream((buyAction + coffeeType + amountToPay).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            int remainingBeansInMachine = coffeeMachine.coffeeMachineResourcesMap.get(MachineResource.BEANS);
            Assert.assertEquals(90, remainingBeansInMachine);
        }
    }

    @Test

    public void testIfBuyingOneEspressoTakeProperValueOfMilk() {
        System.out.println("Test 6");
        String amountToPay = "10\n";
        String coffeeType = "ESPRESSO\n";
        String buyAction = "1\n";

        System.setIn(new ByteArrayInputStream((buyAction + coffeeType + amountToPay).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            int remainingMilkInMachine = coffeeMachine.coffeeMachineResourcesMap.get(MachineResource.MILK);
            Assert.assertEquals(500, remainingMilkInMachine);
        }
    }

    @Test
    public void testIfBuyingOneEspressoTakeProperValueOfWater() {
        System.out.println("Test 7");
        String amountToPay = "10\n";
        String coffeeType = "ESPRESSO\n";
        String buyAction = "1\n";

        System.setIn(new ByteArrayInputStream((buyAction + coffeeType + amountToPay).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            int remainingWaterInMachine = coffeeMachine.coffeeMachineResourcesMap.get(MachineResource.WATER);
            Assert.assertEquals(300, remainingWaterInMachine);
        }
    }

    @Test
    public void testIfBuyingOneEspressoTakeProperValueOfBeans() {
        System.out.println("Test 9");
        String amountToPay = "10\n";
        String coffeeType = "ESPRESSO\n";
        String buyAction = "1\n";

        System.setIn(new ByteArrayInputStream((buyAction + coffeeType + amountToPay).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            int remainingBeansInMachine = coffeeMachine.coffeeMachineResourcesMap.get(MachineResource.BEANS);
            Assert.assertEquals(84, remainingBeansInMachine);
        }
    }

    @Test
    public void testIfYouCanRefillMilk() {
        System.out.println("Test 10");
        String amountToRefill = "100\n";
        String refillAction = "2\n";
        String refillType = "MILK\n";

        System.setIn(new ByteArrayInputStream((refillAction + refillType + amountToRefill).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            int milkValueAfterRefill = coffeeMachine.coffeeMachineResourcesMap.get(MachineResource.MILK);
            Assert.assertEquals(600, milkValueAfterRefill);
        }
    }

    @Test
    public void testIfYouCanRefillWater() {
        System.out.println("Test 11");
        String amountToRefill = "100\n";
        String refillAction = "2\n";
        String refillType = "WATER\n";

        System.setIn(new ByteArrayInputStream((refillAction + refillType + amountToRefill).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            int waterValueAfterRefill = coffeeMachine.coffeeMachineResourcesMap.get(MachineResource.WATER);
            Assert.assertEquals(600, waterValueAfterRefill);
        }
    }

    @Test
    public void testIfYouCanRefillBeans() {
        System.out.println("Test 12");
        String amountToRefill = "10\n";
        String refillAction = "2\n";
        String refillType = "BEANS\n";

        System.setIn(new ByteArrayInputStream((refillAction + refillType + amountToRefill).getBytes()));
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        try {
            coffeeMachine.run();
        } catch (NoSuchElementException e) {
            int beansValueAfterRefill = coffeeMachine.coffeeMachineResourcesMap.get(MachineResource.BEANS);
            Assert.assertEquals(110, beansValueAfterRefill);
        }
    }

}
