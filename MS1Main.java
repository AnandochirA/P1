package pig;

import java.util.Scanner;

public class MS1Main {
    public static void main(String[] args)
    {
        System.out.println("Please enter the seed:"); // Asking seed and reading it
        Die MyDice = new Die(87);

        for (int i = 0; i < 10; i++) // Rolling 10 times
        {
            int result = MyDice.nextRoll();
            System.out.println(result);
        }
    }
}
