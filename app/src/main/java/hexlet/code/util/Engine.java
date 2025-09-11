package hexlet.code.util;

import hexlet.code.games.Game;

import java.util.Scanner;

public final class Engine {
    public static final int TOTAL_ROUNDS = 3;

    private Engine() {
    }

    public static void getMenu() {
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
    }

    public static String getGameNumber(Scanner in) {
        return in.nextLine().trim();
    }

    public static void run(Game game, Scanner in) {
        int roundNumber = 0;

        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?\s""");

        String username = in.nextLine().trim();
        System.out.printf("Hello, %s!%n", username);
        System.out.println(game.getRule());

        while (roundNumber < TOTAL_ROUNDS) {
            Round round = game.nextRound();
            System.out.print(round.question());
            String answer = in.nextLine().trim();
            String correctAnswer = round.correctAnswer();

            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
                roundNumber++;
            } else {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, answer, correctAnswer, username);
                break;
            }
        }

        if (roundNumber == TOTAL_ROUNDS) {
            System.out.printf("Congratulations, %s!%n", username);
        }
    }
}

