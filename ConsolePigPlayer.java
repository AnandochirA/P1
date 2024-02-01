import java.util.Scanner;

public interface PigUI
{
    int	askUserForSeed();
    void displayCurrentScores​(int player1Score, int player2Score);
    void displayGameOver​(int player1Score, int player2Score);
    void displayPlayersTurn​(int playerNumber);
    void displayRollResult​(int diceRoll);
    void displayTurnResults​(int playerNumber, int turnTotal, int newScore);
}

public class ConsolePigPlayer implements PigUI
{
    public ConsoleInterface ​(java.util.Scanner scanner, java.io.PrintStream out) {}
    int	askUserForSeed()
    {
        System.out.println("What seed would you like?");
        Scanner myObj = new Scanner(System.in);
        myObj.close();
        int x = myObj.nextInt();
        return x;
    }
    void displayCurrentScores​(int player1Score, int player2Score)
    {
        System.out.println("Player 1 score:" + player1Score);
        System.out.println("Player 2 score:" + player2Score);
    }
    void displayGameOver​(int player1Score, int player2Score)
    {
        System.out.println("Game Over!!!");
        System.out.println("Player 1 score:" + player1Score);
        System.out.println("Player 2 score:" + player2Score);
    }
    void displayPlayersTurn​(int playerNumber)
    {
        System.out.println("It is player " + playerNumber + "'s turn");
    }
    void displayRollResult​(int diceRoll)
    {
        System.out.println("Roll:" );
        //How to dice roll???
    }
    void displayTurnResults​(int playerNumber, int turnTotal, int newScore)
    {
        System.out.println("Turn total: " + turnTotal);
        System.out.println("New Score: " + newScore);
    }
}
