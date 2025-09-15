package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import hexlet.code.util.Cli;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final Random random = new Random();

        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");

        switch (in.nextLine().trim()) {
            case "1" -> Cli.greetUser(in);
            case "2" -> Even.run(random, in);
            case "3" -> Calc.run(random, in);
            case "4" -> Gcd.run(random, in);
            case "5" -> Progression.run(random, in);
            case "6" -> Prime.run(random, in);
            default -> System.exit(0);
        }
    }
}
