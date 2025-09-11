package hexlet.code.util;

import java.util.Scanner;

public final class Menu {

    private Menu() {
    }

    public static void getMenu() {
        System.out.print("""
                \nPlease enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
    }

    public static int getGameNumber(Scanner in) {
        return in.nextInt();
    }
}
