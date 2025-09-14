package hexlet.code.games;

import java.util.Random;

public record Progression(Random random) {
    private static final String RULES = "What number is missing in the progression?";
    private static final int MIN_RANDOM_VALUE = 5;
    private static final int MAX_RANDOM_VALUE = 10;

    public static String[] nextRound(Random random) {
        int[] progression = createProgression(random);
        int hiddenIndex = random.nextInt(progression.length);
        String correctAnswer = String.valueOf(progression[hiddenIndex]);
        String question = generateQuestion(progression, hiddenIndex);
        return new String[]{RULES, question, correctAnswer};
    }

    private static int[] createProgression(Random random) {
        final int[] progression = new int[random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)];
        final int start = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final int step = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

        for (int i = 0; i < progression.length; i++) {
            progression[i] = start + i * step;
        }

        return progression;
    }

    private static String generateQuestion(int[] progression, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            if (i == index) {
                sb.append("..");
            } else {
                sb.append(progression[i]);
            }

            if (i < progression.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
