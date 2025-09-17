package hexlet.code;

import java.util.Scanner;

public record Engine() {
    private static final int QUESTION_INDEX = 0;
    private static final int CORRECT_ANSWER_INDEX = 1;

    public static void run(String rules, String[][] rounds) {
        final Scanner in = new Scanner(System.in);
        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?\s""");
        String username = in.nextLine().trim();
        System.out.printf("Hello, %s!%n", username);
        System.out.println(rules);

        for (String[] round : rounds) {
            String question = String.format("Question: %s%nYour answer: ", round[QUESTION_INDEX]);
            System.out.print(question);
            String answer = in.nextLine().trim();
            String correctAnswer = round[CORRECT_ANSWER_INDEX];

            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, answer, correctAnswer, username);
                System.exit(0);
            }
        }

        System.out.printf("Congratulations, %s!%n", username);
    }
}
