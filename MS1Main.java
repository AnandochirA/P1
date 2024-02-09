import java.util.Scanner;

public class MS1Main {
    public static void main(String[] args) {
        System.out.println("Please enter the seed:"); // Asking seed and reading it
        Scanner s = new Scanner(System.in);
        int seed = s.nextInt();
        Die MyDice = new Die(seed);

        for (int i = 0; i < 10; i++) // Rolling 10 times
        {
            int result = MyDice.nextRoll();
            System.out.println(result);
        }
        s.close();
    }
}
