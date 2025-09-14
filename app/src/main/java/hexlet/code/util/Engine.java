package hexlet.code.util;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Random;
import java.util.Scanner;

public record Engine() {
    public static final int TOTAL_ROUNDS = 3;
    public static final int RULES_INDEX = 0;
    public static final int QUESTION_INDEX = 1;
    public static final int CORRECT_ANSWER_INDEX = 2;

    public static void printMenu() {
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

    public static String readChoice(Scanner in) {
        return in.nextLine().trim();
    }

    private static String[] nextRoundOf(String gameNumber, Random random) {
        return switch (gameNumber) {
            case "2" -> Even.nextRound(random);
            case "3" -> Calc.nextRound(random);
            case "4" -> Gcd.nextRound(random);
            case "5" -> Progression.nextRound(random);
            case "6" -> Prime.nextRound(random);
            default -> null;
        };
    }

    public static void run(String gameNumber, Random random, Scanner in) {
        String username = Cli.greetUser(in);
        String[] round = nextRoundOf(gameNumber, random);

        if (gameNumber.equals("1") || round == null) {
            return;
        }

        String rules = round[RULES_INDEX];
        System.out.println(rules);
        int roundNumber = 0;

        while (roundNumber < TOTAL_ROUNDS) {
            round = nextRoundOf(gameNumber, random);
            String question = String.format("Question: %s%nYour answer: ", round[QUESTION_INDEX]);
            System.out.print(question);
            String answer = in.nextLine().trim();
            String correctAnswer = round[CORRECT_ANSWER_INDEX];


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
