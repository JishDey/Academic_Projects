/* jdey
* Cieling
* Has a method that will round any number up. Note - output is double, and it only works for positive.
* 09/21/20
*/


public class Ciel
{
   public static double myCiel(double num)
   {
      double tnctn = num % 1.0;
      double numCeild = (int)num + (1 - (int)(1 - tnctn));
      return numCeild;
   }
   public static void main(String[] args)
   {
      System.out.println( ", " + myCiel(-324.888));
   
   }
}
