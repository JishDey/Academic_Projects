/* jdey
* calculates the cost to ship jars of jam
* 10/08/20
*/

import java.util.Scanner;
public class DeyJamJarCalculator
{
   private static double myCiel(double num) //Ceiling method, but it only works for positive numbers. Works for any number of jars that makes sense.
   {
      double tnctn = num % 1.0;  //tnctn is the truncation aka all of the decimals.
      double numCeild = (int)num + (1 - (int)(1 - tnctn)); /*
      This is essentially always adding 1 to the truncated num.
      Everything past the first '1-' accounts for the special case that the number ends a '.0'
      (int)(1 - tnctn) outputs 0 for all values except for 0, in which case it outputs 1.
      The 1 - reverses that.
      */
      return numCeild;
   }
   
   public static double myRound(double num, int place) //Rounding method that takes place and num.
   {
      double scale = 10;
      for (int i = 0; i < place; i++) //replaces Math.pow
      {
         scale = 10 * scale;
      }
      
      double temp = num * scale;
      double tempad5 = temp + 0.5;
      int tempI = (int)tempad5;
      double answer = tempI/scale;
      return answer;
   }
   
   public static void main(String[] args)
   { 
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Jars of jam: ");
      int jars = (int)keyboard.nextDouble();
      
      double shippingCartons  = myCiel((double)jars/12);
      
      double jarsWeightlbs = (double)(21 * jars)/16; //Creates weight in oz, then casts to double before dividing and getting lbs. 
      double cartonsWeightlbs = (double)(shippingCartons * 25)/16;
      double totalWeightlbs = jarsWeightlbs + cartonsWeightlbs;
      double totalCostWeight = myCiel(totalWeightlbs) * 0.96;
      
      double totalCost = 3.00 + (shippingCartons * 1.44) + totalCostWeight;
      double finalCost = myRound(totalCost, 2);
       
      System.out.print(jars + " jars of jam costs $" + finalCost + " to ship.");
   
   } // end main
} // end class
