package hexlet.code.games;

import hexlet.code.Engine;

import java.util.random.RandomGenerator;

public record Gcd() {
    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    public static void run() {
        String[][] rounds = new String[][]{nextRound(), nextRound(), nextRound()};
        Engine.run(RULES, rounds);
    }

    private static String[] nextRound() {
        final int firstNumber = RandomGenerator.getDefault().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final int secondNumber = RandomGenerator.getDefault().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        String question = String.format("%s %s", firstNumber, secondNumber);
        String correctAnswer = String.valueOf(gcd(firstNumber, secondNumber));
        return new String[]{question, correctAnswer};
    }

    private static int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }
}
