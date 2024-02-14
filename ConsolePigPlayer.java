package pig;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsolePigPlayer implements PigPlayer {
    private Scanner scanner;
    private PrintStream out;
    // Constructor of the class
    public ConsolePigPlayer(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    // isRolling function which defines if the player wants to hold or not
    public boolean isRolling(int myScore, int otherScore, int turnTotal) {
        System.out.println("Turn total: " + turnTotal + "    " + "Roll/Hold? "); //program need to ask about the user's decision
        String input = scanner.nextLine(); // Read user input
        return input.isEmpty() && otherScore < 100 && myScore < 100;
    }

}
