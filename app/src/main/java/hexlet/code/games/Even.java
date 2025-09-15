package hexlet.code.games;

import hexlet.code.util.Engine;

import java.util.Random;
import java.util.Scanner;

public record Even() {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 1000;

    public static void run(Random random, Scanner in) {
        String[][] rounds = new String[][] {nextRound(random), nextRound(random), nextRound(random)};
        Engine.run(RULES, rounds, in);
    }

    private static String[] nextRound(Random random) {
        final int randomNumber = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        String question = String.valueOf(randomNumber);
        String correctAnswer = isEven(randomNumber) ? "yes" : "no";
        return new String[]{question, correctAnswer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
