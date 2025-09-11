package hexlet.code.games;

import hexlet.code.util.Round;

import java.util.Arrays;
import java.util.Random;

public class Progression implements Game {
    private final Random random;

    public Progression() {
        this.random = new Random();
    }

    @Override
    public String getRule() {
        return "What number is missing in the progression?";
    }

    @Override
    public Round nextRound() {
        int[] progression = createProgression();
        int hiddenIndex = random.nextInt(progression.length);
        String correctAnswer = String.valueOf(progression[hiddenIndex]);
        String progressionWithHiddenElement = Arrays.toString(progression)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replace(correctAnswer, "..");
        final String question = String.format("Question: %s\nYour answer: ", progressionWithHiddenElement);
        return new Round(question, correctAnswer);
    }

    public int[] createProgression() {
        int[] progression = new int[random.nextInt(6, 10)];
        int start = random.nextInt(1, 9);
        int step = random.nextInt(2, 8);

        for (int i = 0; i < progression.length; i++) {
            progression[i] = start + i * step;
        }

        return progression;
    }
}
