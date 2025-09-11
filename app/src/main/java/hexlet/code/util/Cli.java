package hexlet.code.util;

import java.util.Scanner;

public final class Cli {

    private Cli() {
    }

    public static void greetUser(Scanner in) {

        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?\s""");

        System.out.printf("Hello, %s!\n", in.next());
    }
}
