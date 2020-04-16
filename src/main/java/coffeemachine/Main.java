package coffeemachine;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine(userInputProvider);
        coffeeMachine.run();
    }
}
