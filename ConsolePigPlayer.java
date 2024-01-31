import java.util.Scanner;

public class ConsolePigPlayer
{
    public ConsoleInterface​(java.util.Scanner scanner, java.io.PrintStream out) {}
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
    }
    void displayPlayersTurn​(int playerNumber)
    {

    }
    void displayRollResult​(int diceRoll)
    {
        System.out.println("Roll:" );
    }
    void displayTurnResults​(int playerNumber, int turnTotal, int newScore)
    {

    }
}