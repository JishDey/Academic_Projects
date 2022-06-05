/* jdey
* solving quadratics
* 09/23/20
*/

import java.util.Scanner;
public class QuadraticSolver
{
   public static String quadratic(double a, double b, double c)
   {
      double discriminant = (b*b)-(4*a*c);
       if (a == 0) 
      {
         return "not a quadratic";
      }
      else if (discriminant < 0) 
      {
         double partialroot = (-b/2*a);
         String solution = "x1, x2 =1" + partialroot + " + (" + discriminant/(2*a) + ")i" + ", " + partialroot + " + (" + discriminant/(2*a) + ")i";
         return solution;
      }
      else
      {
         double root1 = (-b + Math.sqrt(discriminant))/(2*a);
         double root2 = (-b - Math.sqrt(discriminant))/(2*a);
         String solution = "(x1, x2 =)" + root1 + ", "+ root2;
         return solution; 
      }

   }
   
   public static void main(String[] args)
   {
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("a:");
      double avar = keyboard.nextInt();
      System.out.println("b:");
      double bvar = keyboard.nextInt();
      System.out.println("c:");
      double cvar = keyboard.nextInt();
      String solved = quadratic(avar, bvar, cvar);
      if (solved == "not a quadratic")
      {
         System.out.println("Not a quadratic.");
      }
      else 
      {
         System.out.println(solved);
      }
   } 
}
