import java.util.Scanner;

public interface PigUI
{
    int askUserForSeed();
    void displayCurrentScore(int player1Score, int player2Score);
    void displayGameOver(int player1Score, int player2Score);
    void displayPlayersTurn(int playerNumber);
    void displayRollResult(int diceRoll);
    void displayTurnResults(int playerNumber, int turnTotal, int newScore);
}

