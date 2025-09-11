package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Random;

public record Even(Random random) implements Game {
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 1000;

    @Override
    public String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public Round nextRound() {
        final int randomNumber = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final String question = String.format("Question: %s%nYour answer: ", randomNumber);
        String correctAnswer = isEven(randomNumber) ? "yes" : "no";
        return new Round(question, correctAnswer);
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
