package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Random;

public record Calc(Random random) implements Game {
    private static final int MIN_RANDOM_VALUE = -100;
    private static final int MAX_RANDOM_VALUE = 100;
    private static final char[] OPERATIONS = {'+', '-', '*'};

    @Override
    public String getRule() {
        return "What is the result of the expression?";
    }

    @Override
    public Round nextRound() {
        final int firstOperand = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final int secondOperand = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final char operation = OPERATIONS[random.nextInt(OPERATIONS.length)];
        String question = String
                .format("Question: %s %s %s%nYour answer: ", firstOperand, operation, secondOperand);

        String correctAnswer = switch (operation) {
            case '+' -> String.valueOf(firstOperand + secondOperand);
            case '-' -> String.valueOf(firstOperand - secondOperand);
            default -> String.valueOf(firstOperand * secondOperand);
        };

        return new Round(question, correctAnswer);
    }
}
