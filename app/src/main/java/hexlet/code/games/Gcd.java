package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Random;

public record Gcd(Random random) implements Game {
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    @Override
    public String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public Round nextRound() {
        final int firstNumber = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final int secondNumber = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        String question = String.format("Question: %s %s%nYour answer: ", firstNumber, secondNumber);
        String correctAnswer = String.valueOf(gcd(firstNumber, secondNumber));
        return new Round(question, correctAnswer);
    }

    private int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }
}
