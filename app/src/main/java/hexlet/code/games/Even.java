package hexlet.code.games;

import hexlet.code.Engine;

import java.util.random.RandomGenerator;

public record Even() {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 1000;

    public static void run() {
        Engine.run(
                RULES,
                new String[][]{nextRound(), nextRound(), nextRound()}
        );
    }

    private static String[] nextRound() {
        final int randomNumber = RandomGenerator.getDefault().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        String question = String.valueOf(randomNumber);
        String correctAnswer = isEven(randomNumber) ? "yes" : "no";
        return new String[]{question, correctAnswer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
