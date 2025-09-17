package hexlet.code.games;

import hexlet.code.Engine;

import java.util.random.RandomGenerator;

public record Progression() {
    private static final String RULES = "What number is missing in the progression?";
    private static final int MIN_RANDOM_VALUE = 5;
    private static final int MAX_RANDOM_VALUE = 10;

    public static void run() {
        Engine.run(
                RULES,
                new String[][]{nextRound(), nextRound(), nextRound()}
        );
    }

    private static String[] nextRound() {
        int start = RandomGenerator.getDefault().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        int step = RandomGenerator.getDefault().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        int length = RandomGenerator.getDefault().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        int hiddenIndex = RandomGenerator.getDefault().nextInt(length);
        String[] progression = makeProgression(start, step, length);
        String correctAnswer = String.valueOf(progression[hiddenIndex]);
        progression[hiddenIndex] = "..";
        String question = String.join(" ", progression);
        return new String[]{question, correctAnswer};
    }

    private static String[] makeProgression(int start, int step, int length) {
        String[] progression = new String[length];

        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }

        return progression;
    }
}
