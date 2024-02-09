import java.util.Scanner;

public class HoldAtXPigPlayer implements PigPlayer
{
    private int x;

    // Constructor
    public HoldAtXPigPlayer(int x)
    {
        this.x = x;
    }

    public boolean isRolling(int myScore, int otherScore, int turnTotal)
    {
        // Check if player's turn total is less than X and the player hasn't won
        return turnTotal < x && myScore < 20;
    }
}