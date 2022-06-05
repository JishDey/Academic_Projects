import java.util.Scanner;
public class chatBot1
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("What is your name?");
      String answer = keyboard.nextLine(); 
      
      System.out.println("What is your favorite food?");
      String favoriteFood = keyboard.nextLine();
      
      System.out.println("Well I think " + favoriteFood + " is bad. What about your favorite class at school?");
      String favoriteSchool = keyboard.nextLine();
      
      System.out.println(favoriteSchool + " is dumb, oh well."); 
      
      System.out.println("How many days has it been?");
      int days = keyboard.nextInt();
      
      if (days == 42) {
         System.out.println("Hello " + answer + ". The time has come.");
      }
      else {
         System.out.println("Hello " + answer + ".");
      };
   
   }
}
