import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public abstract class Main
{
    public static void main(String[] args)
    {
        // Create a ConsoleInterface
        PigUI ui = new ConsoleInterface(new Scanner(in), out);

        // Create seed
        int seed = ui.askUserForSeed();

        // Create two pig players
        PigPlayer player1 = new PigPlayer()
        {
            public boolean isRolling(int myScore, int otherScore, int turnTotal) {return true;}
        };

        PigPlayer player2 = new HoldAtXPigPlayer(5);

        // Create a PigGame with the two players
        PigGame pigGame = new PigGame(player1, player2, seed, ui);

        // Start the game
        pigGame.play();
    }
}
