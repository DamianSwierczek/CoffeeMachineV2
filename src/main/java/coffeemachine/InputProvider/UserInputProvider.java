package coffeemachine.InputProvider;

import java.util.Scanner;

public class UserInputProvider {

    private final Scanner scanner;

    public UserInputProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    public String provideInput() {
        return scanner.next();
    }

    public Integer provideIntInput() {
        return scanner.nextInt();
    }
}
