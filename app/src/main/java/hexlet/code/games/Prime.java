package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Random;

public class Prime implements Game {
    private final Random random;

    public Prime() {
        this.random = new Random();
    }

    @Override
    public String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public Round nextRound() {
        final int randomNumber = random.nextInt(2, 100);
        final String question = String.format("Question: %s\nYour answer: ", randomNumber);
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

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
