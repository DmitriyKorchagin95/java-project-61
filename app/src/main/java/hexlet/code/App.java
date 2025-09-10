package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            int gameNumber = Menu.getMenu(scanner);

            switch (gameNumber) {
                case 1 -> Cli.askUsername(scanner);
                case 2 -> Even.start(scanner);
                case 0 -> {
                    return;
                }
                default -> {
                }
            }
        }
    }
}
