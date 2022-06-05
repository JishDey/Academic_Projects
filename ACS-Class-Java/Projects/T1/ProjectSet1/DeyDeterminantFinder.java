/* jdey
* finds the determinant of a 2 x 2 matrix
* 10/05/20
*/

import java.util.Scanner;
public class DeterminantFinder
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter your matrix");
      System.out.print("(Line 1, seperated by a space,) A  B: "); 
      int a = keyboard.nextInt();
      int b = keyboard.nextInt();
      System.out.print("(Line 2, seperated by a space,) C  D: ");
      int c = keyboard.nextInt();
      int d = keyboard.nextInt();//The arrangment of the variables looks like the matrix.
      
      int determinant = a*d - c*b;//Determinant formula.
      System.out.println("The determinant is " + determinant);
   
   } // end main
} // end class
