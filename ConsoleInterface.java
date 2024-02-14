package pig;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInterface implements PigUI
{
    public ConsoleInterface (Scanner scanner, PrintStream out) {}

    public int askUserForSeed(Scanner scanner) {
        System.out.println("What seed would you like?");
        int x = scanner.nextInt();
        return x;
    }

    public void displayCurrentScores(int player1Score, int player2Score)
    {
        System.out.println("Player 1 score: " + player1Score);
        System.out.println("Player 2 score: " + player2Score);
    }

    public void displayGameOver(int player1Score, int player2Score)
    {
        System.out.println("Game Over!!!");
        System.out.println("Player 1 score: " + player1Score);
        System.out.println("Player 2 score: " + player2Score);
    }

    public void displayPlayersTurn(int playerNumber)
    {
        System.out.println("It is player " + playerNumber + "'s turn");
    }

    public void displayRollResult(int diceRoll)
    {
        System.out.println("Roll: " + diceRoll);
    }

    public void displayTurnResults(int playerNumber, int turnTotal, int newScore)
    {
        System.out.println("Turn total: " + turnTotal);
        System.out.println("New Score: " + newScore);
    }
}
