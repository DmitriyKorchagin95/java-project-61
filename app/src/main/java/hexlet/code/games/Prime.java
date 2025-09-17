package hexlet.code.games;

import hexlet.code.Engine;

import java.util.random.RandomGenerator;

public record Prime() {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_RANDOM_VALUE = 2;
    private static final int MAX_RANDOM_VALUE = 100;

    public static void run() {
        String[][] rounds = new String[][]{nextRound(), nextRound(), nextRound()};
        Engine.run(RULES, rounds);
    }

    private static String[] nextRound() {
        final int randomNumber = RandomGenerator.getDefault().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        String question = String.valueOf(randomNumber);
        String correctAnswer = isPrime(randomNumber) ? "yes" : "no";
        return new String[]{question, correctAnswer};
    }

    private static boolean isPrime(int number) {
        final int firstOddDivisor = 3;

        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int i = firstOddDivisor; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
