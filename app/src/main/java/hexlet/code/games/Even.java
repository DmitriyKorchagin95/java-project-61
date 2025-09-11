package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Random;

public final class Even implements Game {
    private final Random random;

    public Even() {
        this.random = new Random();
    }

    @Override
    public String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'";
    }

    @Override
    public Round nextRound() {
        final int randomNumber = random.nextInt(1, 1000);
        final String question = String.format("Question: %s\nYour answer: ", randomNumber);
        String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
        return new Round(question, correctAnswer);
    }
}
