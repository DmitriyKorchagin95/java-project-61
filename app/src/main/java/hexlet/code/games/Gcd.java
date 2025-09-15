package hexlet.code.games;

import hexlet.code.util.Engine;

import java.util.Random;
import java.util.Scanner;

public record Gcd() {
    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    public static void run(Random random, Scanner in) {
        String[][] rounds = new String[][] {nextRound(random), nextRound(random), nextRound(random)};
        Engine.run(RULES, rounds, in);
    }

    private static String[] nextRound(Random random) {
        final int firstNumber = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final int secondNumber = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        String question = String.format("%s %s", firstNumber, secondNumber);
        String correctAnswer = String.valueOf(gcd(firstNumber, secondNumber));
        return new String[]{question, correctAnswer};
    }

    private static int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }
}
