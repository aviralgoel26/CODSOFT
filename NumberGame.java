import java.util.Scanner;
public class NumberGame
{
    static int score=0;
    public static void Game()
    {
      Scanner kb=new Scanner(System.in);
      System.out.println("A number is chosen between 1 and 100.");
      System.out.println("Guess the number in 5 chances.");
      int number=(int)(Math.random()*(100-1)+1);
      int a=0;
      for(int i=0;i<5;i++)
      {
          System.out.println("Guess the number:");
          int guess=kb.nextInt();
          if(guess==number)
          {
              System.out.println("Hurrah!! You guessed the number");
              score++;
              System.out.println("Rounds Won - "+score);
              break;
          }
          else
          {
              a++;
              if((Math.abs(guess-number))<=5)
              {
                  System.out.println("You are Closer");
              }
              else if(guess<number)
              {
                System.out.println("OOPS!! The Number is greater than "+guess); 
              }
              else
              {
                  System.out.println("OOPS!! The Number is less than "+guess);
              }
          }
      }
      if(a==5)
      {
      System.out.println("You Loose!!, The number was "+ number);
      System.out.println("Better luck next time");
      System.out.println("Number of Rounds Won - " + score);
    }
    }
    public static void main()
    {
        Game();
        int i=1;
        Scanner sc=new Scanner(System.in);
        while(i!=0)
        {
        System.out.println("Do you want to play another round, If yes than type '1'");
        int ask=sc.nextInt();
        if(ask==1)
        {
            Game();
        }
        else
        {
        System.out.println("Come Back Soon!!");
        break;
        }
        }
        
    }
}