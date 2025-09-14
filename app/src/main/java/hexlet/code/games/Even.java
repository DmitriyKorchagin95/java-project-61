package hexlet.code.games;

import java.util.Random;

public record Even() {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 1000;

    public static String[] nextRound(Random random) {
        final int randomNumber = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        String question = String.valueOf(randomNumber);
        String correctAnswer = isEven(randomNumber) ? "yes" : "no";
        return new String[]{RULES, question, correctAnswer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
