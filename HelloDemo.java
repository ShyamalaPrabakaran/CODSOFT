import java.util.*;
public class HelloDemo {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int min = 1;
    int max = 100;
    int maxAtt = 5;
    int score = 0;

    do {
      // Generate random number
      int randomly = min + (int) (Math.random() * ((max - min) + 1));
      boolean gc = false;

      for (int attempt = 1; attempt <= maxAtt; attempt++) {
        System.out.println("Guess #" + attempt + ": Enter a number between 1 and 100");
        int guess = s.nextInt();

        if (guess == randomly) {
          gc = true;
          break;
        } else if (guess > randomly) {
          System.out.println("Too high! Try again.");
        } else {
          System.out.println("Too low! Try again.");
        }
      }

      if (gc) {
        score++;
        System.out.println("Congratulations! You guessed the number in " + maxAtt + " attempts.");
      } else {
        System.out.println("You ran out of attempts. The number was: " + randomly);
      }

      // Ask user to play again (using clearer prompt and boolean check)
      System.out.println("Do you want to play again? (y/n)");
      

      // Continue the loop only if the user enters 'y' (case-insensitive)
    } while (s.nextLine().equalsIgnoreCase("y"));

    System.out.println("Thank you for playing! Your final score is: " + score);
    s.close();
  }
}
      


