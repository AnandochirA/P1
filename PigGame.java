package pig;

import java.io.PrintStream;
import java.util.Scanner;

public class PigGame {
    private PigUI ui;
    private Scanner scanner;
    private PrintStream out;
    private PigPlayer player1;
    private PigPlayer player2 = new HoldAtXPigPlayer(5);
    private int seed;
    private final int GOAL_SCORE = 100;
    private final int DIE_PIG_ROLL = 1;
    public PigGame(PigPlayer player1, PigPlayer player2, int seed, PigUI ui)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.seed = seed;
        this.ui = ui;
    }

    public void play()
    {
        //players' scores start from 0 at the beginning of the game
        int player1Score = 0;
        int player2Score = 0;
        //The first player starts to play
        int turn = 1;
        //Making standard 6 sided die
        Die dice = new Die(seed);
        while(player1Score < GOAL_SCORE && player2Score < GOAL_SCORE) //if no one reached the GOAL_SCORE it runs
        {
            ui.displayCurrentScores(player1Score, player2Score); //displaying the scores
            int rollResult = 0;
            int turnTotal = 0; //turnTotal starts from 0
            if(turn == 1) // if it is the first player's turn
            {
                ui.displayPlayersTurn(turn);
                rollResult = dice.nextRoll();
                ui.displayRollResult(rollResult);
                turnTotal += rollResult; // the first roll is automatically
                while(rollResult != DIE_PIG_ROLL)
                {
                    if (!player1.isRolling(player1Score, player2Score, turnTotal)) { // checking if user want to hold it or continue the game
                        rollResult = dice.nextRoll(); //Rolling the die
                        ui.displayRollResult(rollResult); //Displaying the roll result
                        turnTotal += rollResult;
                        player1Score += turnTotal;
                        ui.displayTurnResults(turn, turnTotal, player1Score); //if user decided to hold it, program need to display about this turn
                        rollResult = DIE_PIG_ROLL; //We need to exit the while because user wants to hold
                        turn = 2; // Switching the turn because the first player's turn ended
                    }
                    else{
                        rollResult = dice.nextRoll(); //Rolling the die
                        ui.displayRollResult(rollResult);
                        turnTotal += rollResult;
                        if(rollResult == DIE_PIG_ROLL) //if rolling result equals to 1 we need to display turn before it stop
                        {
                            player1Score += turnTotal;
                            ui.displayTurnResults(turn, turnTotal, player1Score);
                            turn = 2; // Switching the turn because the first player's turn ended
                        }
                    }
                }
            }
            else { //if it is computer's turn
                ui.displayPlayersTurn(turn); //displaying who is turn is it
                while(rollResult != DIE_PIG_ROLL)
                {
                    rollResult = dice.nextRoll(); //Rolling the die
                    ui.displayRollResult(rollResult); //Displaying the roll result
                    if(rollResult == DIE_PIG_ROLL) { //if it equals to 1, we need to display about turn before it stop
                        player2Score += turnTotal;
                        ui.displayTurnResults(turn, turnTotal, player2Score);
                        turn = 1; // Switching the turn because the second player's turn ended
                    }
                    else{
                        if(turnTotal + rollResult < 20)
                        {
                            turnTotal += rollResult;
                        }
                        else //the computer has limit in one turn which 20, so we need to check it.
                        {
                            player2Score += turnTotal;
                            ui.displayTurnResults(turn, turnTotal, player2Score);
                            turn = 1; // Switching the turn because the second player's turn ended
                            rollResult = DIE_PIG_ROLL;
                        }
                    }
                }
            }
        }
        ui.displayGameOver(player1Score, player2Score); //program need to display game over when game is done
    }
}
