package hexlet.code.games;

import hexlet.code.util.Engine;

import java.util.Random;
import java.util.Scanner;

public record Calc() {
    private static final String RULES = "What is the result of the expression?";
    private static final int MIN_RANDOM_VALUE = -10;
    private static final int MAX_RANDOM_VALUE = 10;
    private static final char[] OPERATIONS = {'+', '-', '*'};

    public static void run(Random random, Scanner in) {
        String[][] rounds = new String[][] {nextRound(random), nextRound(random), nextRound(random)};
        Engine.run(RULES, rounds, in);
    }

    private static String[] nextRound(Random random) {
        final int firstOperand = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final int secondOperand = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final char operation = OPERATIONS[random.nextInt(OPERATIONS.length)];
        String question = String.format("%s %s %s", firstOperand, operation, secondOperand);

        String correctAnswer = switch (operation) {
            case '+' -> String.valueOf(firstOperand + secondOperand);
            case '-' -> String.valueOf(firstOperand - secondOperand);
            default -> String.valueOf(firstOperand * secondOperand);
        };

        return new String[]{question, correctAnswer};
    }
}
