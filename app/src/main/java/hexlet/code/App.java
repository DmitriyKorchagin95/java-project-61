package hexlet.code;

import hexlet.code.util.Engine;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final Random random = new Random();
        Engine.printMenu();
        String gameNumber = Engine.readChoice(in);
        Engine.run(gameNumber, random, in);
    }
}
