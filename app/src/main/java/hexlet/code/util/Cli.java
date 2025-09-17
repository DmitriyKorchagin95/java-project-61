package hexlet.code.util;

import java.util.Scanner;

import static java.lang.System.in;

public record Cli() {
    public static void greetUser() {
        Scanner in = new Scanner(System.in);
        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?\s""");
        System.out.printf("Hello, %s!%n", in.nextLine().trim());
    }
}
