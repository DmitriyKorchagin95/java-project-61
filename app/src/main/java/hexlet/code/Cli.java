package hexlet.code;

import java.util.Scanner;

public final class Cli {

    private Cli() {
    }

    public static String askUsername(Scanner scanner) {

        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?\s""");

        String userName = scanner.next();
        System.out.printf("Hello, %s!\n", userName);
        return userName;
    }
}
