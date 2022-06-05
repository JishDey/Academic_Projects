import java.util.Scanner;
public class IntegerDevision
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Cents: ");
      int cents = keyboard.nextInt();
      int dollars = cents/100;
      cents = cents % 100;
      int quarters = cents/25;
      cents = cents % 25;
      int dimes = cents/10;
      cents = cents % 10;
      int nickles = cents/5;
      cents = cents % 5;
      
      System.out.println("You could have $" + dollars + ", " + quarters + " quarters " + ", " + dimes + " dimes " + ", " + nickles + " nickles " + " and " + cents + " pennies "); 
      keyboard.close();
   }
}
