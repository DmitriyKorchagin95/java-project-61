package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Random;

public class Gcd implements Game {
    private final Random random = new Random();

    public Gcd() {
    }

    @Override
    public String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public Round nextRound() {
        final int firstNumber = random.nextInt(1, 100);
        final int secondNumber = random.nextInt(1, 100);
        final String question = String.format("Question: %s %s\nYour answer: ", firstNumber, secondNumber);
        String correctAnswer = String.valueOf(gcd(firstNumber, secondNumber));
        return new Round(question, correctAnswer);
    }

    private int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }
}
