package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Random;

public record Prime(Random random) implements Game {
    private static final int FIRST_ODD_DIVISOR = 3;
    private static final int MIN_RANDOM_VALUE = 2;
    private static final int MAX_RANDOM_VALUE = 100;

    @Override
    public String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public Round nextRound() {
        final int randomNumber = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        String question = String.format("Question: %s%nYour answer: ", randomNumber);
        String correctAnswer = isPrime(randomNumber) ? "yes" : "no";
        return new Round(question, correctAnswer);
    }

    private boolean isPrime(int number) {

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
