package hexlet.code.games;

import hexlet.code.Engine;

import java.util.random.RandomGenerator;

public record Calc() {
    private static final String RULES = "What is the result of the expression?";
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 100;
    private static final char[] OPERATIONS = {'+', '-', '*'};

    public static void run() {
        String[][] rounds = new String[][]{nextRound(), nextRound(), nextRound()};
        Engine.run(RULES, rounds);
    }

    private static String[] nextRound() {
        final int firstOperand = RandomGenerator.getDefault().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final int secondOperand = RandomGenerator.getDefault().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final char operation = OPERATIONS[RandomGenerator.getDefault().nextInt(OPERATIONS.length)];
        String question = String.format("%s %s %s", firstOperand, operation, secondOperand);
        String correctAnswer = makeCorrectAnswer(firstOperand, operation, secondOperand);
        return new String[]{question, correctAnswer};
    }

    private static String makeCorrectAnswer(int firstOperand, char operation, int secondOperand) {
        return switch (operation) {
            case '+' -> String.valueOf(firstOperand + secondOperand);
            case '-' -> String.valueOf(firstOperand - secondOperand);
            default -> String.valueOf(firstOperand * secondOperand);
        };
    }
}
