/* jdey
* first java test
* 9/8/20
*/
import java.util.Scanner; //Allows use of keyboard.
public class HelloWorld
{
   public static void main(String[] args)
   {
      //Scanner class allows input from keyboard.
      //Keyboard is just the object name.
      Scanner keyboard = new Scanner(System.in);
      System.out.println("What is your name?");
      String answer = keyboard.nextLine(); //nextLine() gets words phrases
      
      System.out.println("How many days has it been?");
      int days = keyboard.nextInt(); //nextInt() gathers integers
      
      //check if the correct amount of days has occured.
      if (days == 42) {
         System.out.println("Hello " + answer + ". The time has come.");
      }
      else {
         System.out.println("Hello " + answer + ".");
      };
   }
   
}