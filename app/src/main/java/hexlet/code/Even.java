package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class Even {

    private Even() {
    }

    public static void start(Scanner scanner) {

        Random random = new Random();
        int round = 0;
        String username = Cli.askUsername(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'");

        while (round < 3) {
            int randomNumber = random.nextInt(1, 1000);
            System.out.printf("Question: %s\nYour answer: ", randomNumber);
            String answer = scanner.next().toLowerCase().trim();
            String correctAnswer = isEven(randomNumber) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
                round++;
            } else {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, answer, correctAnswer, username);
                round = 0;
            }
        }

        if (round == 3) {
            System.out.printf("Congratulations, %s!", username);
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
