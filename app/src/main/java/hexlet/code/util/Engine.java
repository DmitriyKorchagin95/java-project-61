package hexlet.code.util;

import hexlet.code.games.Game;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;

    public static void run(Game game, Scanner in) {
        int roundNumber = 0;

        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?\s""");


        String username = in.next().trim();
        System.out.printf("Hello, %s!\n", username);
        System.out.println(game.getRule());

        while (roundNumber < ROUNDS) {
            Round round = game.nextRound();
            System.out.printf(round.question());
            String answer = in.next().trim();
            String correctAnswer = round.correctAnswer();

            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
                roundNumber++;
            } else {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!""", answer, correctAnswer, username);
                break;
            }
        }

        if (roundNumber == 3) {
            System.out.printf("Congratulations, %s!", username);
        }
    }
}

