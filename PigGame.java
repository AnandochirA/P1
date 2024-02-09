import java.util.Scanner;

public class PigGame {
    private PigPlayer player1;
    private PigPlayer player2;
    private int seed;
    private int player1Score;
    private int player2Score;
    private PigUI ui;
    private Die d;
    private Scanner scanner;

    // Constants
    public static final int GOAL_SCORE = 100;
    public static final int PIG_DIE_ROLL = 1;

    // Constructor
    public PigGame(PigPlayer player1, PigPlayer player2, int seed, PigUI ui) {
        this.player1 = player1;
        this.player2 = player2;
        this.seed = seed;
        this.ui = ui;
        d = new Die(seed); // Create a new standard six-sided die for the game
        player1Score = 0;
        player2Score = 0;
    }

    // Method to play a single game of Pig between two players
    public void play() {
        int turn = 1;
        int newScore = 0;
        while (player1Score < GOAL_SCORE && player2Score < GOAL_SCORE) {
            ui.displayCurrentScore(player1Score, player2Score);
            ui.displayPlayersTurn(turn);
            int result = 0;
            int cnt = 0;
            while (result != 1) {
                result = d.nextRoll();
                ui.displayRollResult(result);
                if (result != 1) {
                    newScore += result;
                    cnt++;
                    if (turn == 1) {
                        boolean continueRoll = player1.isRolling(player1Score, player2Score, newScore);
                        if (!continueRoll) {
                            ui.displayTurnResults(turn, newScore, player1Score);
                            break;
                        }
                    }
                }
            }
            if (turn == 1) player1Score += newScore;
            else player2Score += newScore;

            if (turn == 1) {
                ui.displayTurnResults(turn, newScore, player1Score);
                turn = 2;
            } else {
                ui.displayTurnResults(turn, newScore, player2Score);
                turn = 1;
            }
            newScore = 0; // Reset newScore for the next player's turn
        }
        ui.displayGameOver(player1Score, player2Score);
    }
}
