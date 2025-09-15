package hexlet.code.games;

import hexlet.code.util.Engine;

import java.util.Random;
import java.util.Scanner;

public record Prime() {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int FIRST_ODD_DIVISOR = 3;
    private static final int MIN_RANDOM_VALUE = 2;
    private static final int MAX_RANDOM_VALUE = 100;

    public static void run(Random random, Scanner in) {
        String[][] rounds = new String[][] {nextRound(random), nextRound(random), nextRound(random)};
        Engine.run(RULES, rounds, in);
    }

    private static String[] nextRound(Random random) {
        final int randomNumber = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        String question = String.valueOf(randomNumber);
        String correctAnswer = isPrime(randomNumber) ? "yes" : "no";
        return new String[]{question, correctAnswer};
    }

    private static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int i = FIRST_ODD_DIVISOR; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
