package hexlet.code.util;

import java.util.Scanner;

public record Cli() {
    public static String greetUser(Scanner in) {
        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?\s""");
        String username = in.nextLine().trim();
        System.out.printf("Hello, %s!%n", username);
        return username;
    }
}
