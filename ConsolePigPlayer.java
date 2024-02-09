import java.io.PrintStream;
import java.util.Scanner;

public class ConsolePigPlayer implements PigPlayer {
    private Scanner scanner;
    private PrintStream out;

    //constructor of the class
    public ConsolePigPlayer(Scanner scanner, PrintStream out) 
    {
        this.scanner = scanner;
        this.out = out;
    }
    //isRolling function which defines the player wants hold it or not 
    public boolean isRolling(int myScore, int otherScore, int turnTotal) {
        out.print("Turn total: " + turnTotal + "    " + "Roll/Hold? ");
        String input = scanner.nextLine(); // Read user input 
        return input.isEmpty(); // If input is empty, return true (roll again), otherwise return false (hold)
    }
}
