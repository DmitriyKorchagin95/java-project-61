package hexlet.code;

import hexlet.code.games.*;
import hexlet.code.util.Cli;
import hexlet.code.util.Engine;
import hexlet.code.util.Menu;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        while (true) {
            Menu.getMenu();
            int gameNumber = Menu.getGameNumber(in);

            switch (gameNumber) {
                case 1 -> Cli.greetUser(in);
                case 2 -> Engine.run(new Even(), in);
                case 3 -> Engine.run(new Calc(), in);
                case 4 -> Engine.run(new Gcd(), in);
                case 5 -> Engine.run(new Progression(), in);
                case 6 -> Engine.run(new Prime(), in);
                case 0 -> {
                    return;
                }
                default -> {
                }
            }
        }
    }
}
