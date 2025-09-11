package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Random;

public record Progression(Random random) implements Game {
    private static final int MIN_RANDOM_VALUE = 5;
    private static final int MAX_RANDOM_VALUE = 10;

    @Override
    public String getRule() {
        return "What number is missing in the progression?";
    }

    @Override
    public Round nextRound() {
        int[] progression = createProgression();
        int hiddenIndex = random.nextInt(progression.length);
        String correctAnswer = String.valueOf(progression[hiddenIndex]);
        String question = generateQuestion(progression, hiddenIndex);
        return new Round(question, correctAnswer);
    }

    public int[] createProgression() {
        final int[] progression = new int[random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)];
        final int start = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        final int step = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

        for (int i = 0; i < progression.length; i++) {
            progression[i] = start + i * step;
        }

        return progression;
    }

    private String generateQuestion(int[] progression, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ");

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

        sb.append("\nYour answer: ");
        return sb.toString();
    }
}
