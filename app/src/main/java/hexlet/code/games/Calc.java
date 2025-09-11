package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Random;

public class Calc implements Game {
    private final Random random;

    public Calc() {
        this.random = new Random();
    }

    @Override
    public String getRule() {
        return "What is the result of the expression?";
    }

    @Override
    public Round nextRound() {
        char[] operations = {'+', '-', '*'};
        int operand1 = random.nextInt(-10, 10);
        int operand2 = random.nextInt(-10, 10);
        char operation = operations[random.nextInt(operations.length)];
        final String question = String.format("Question: %s %s %s\nYour answer: ", operand1, operation, operand2);
        String correctAnswer = switch (operation) {
            case '+' -> String.valueOf(operand1 + operand2);
            case '-' -> String.valueOf(operand1 - operand2);
            default -> String.valueOf(operand1 * operand2);
        };
        return new Round(question, correctAnswer);
    }
}
