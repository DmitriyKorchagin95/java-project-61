package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import hexlet.code.util.Cli;
import hexlet.code.util.Engine;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final Random random = new Random();

        Engine.getMenu();
        String gameNumber = Engine.getGameNumber(in);

        switch (gameNumber) {
            case "1" -> Cli.greetUser(in);
            case "2" -> Engine.run(new Even(random), in);
            case "3" -> Engine.run(new Calc(random), in);
            case "4" -> Engine.run(new Gcd(random), in);
            case "5" -> Engine.run(new Progression(random), in);
            case "6" -> Engine.run(new Prime(random), in);
            default -> System.exit(0);
        }
    }
}
