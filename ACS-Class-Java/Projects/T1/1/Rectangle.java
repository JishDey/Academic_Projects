/*jdey
*rectangle examples
*input and calculations
*9/10/20
*/

import java.util.Scanner; // Keyboard input
public class Rectangle
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      //double allows for decimals; int is just integers
      System.out.print("Length: ");
      double length = keyboard.nextDouble();
      System.out.print("Width: ");
      double width = keyboard.nextDouble();
   
      //calculates on the right of the equal sign; assigns to left
      double area = length * width;
      double perimeter = 2 * (length + width);
   
      System.out.println("The area is " + area + ", and the perimeter is "+ perimeter + ".");
   
   }
   
}