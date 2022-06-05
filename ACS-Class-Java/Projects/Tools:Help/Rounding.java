/* jdey
* Rounding and methods
* Has a method that will round any number taking the number as a double input and place as integer. 
* 09/21/20
*/


public class Rounding
{
   public static double round(double num, int place)
   {
      double scale = Math.pow(10,place);
      double temp = num * scale;
      double tempad5 = temp + 0.5;
      int tempI = (int)tempad5;
      double answer = tempI/scale;
      return answer;
   }
   
   public static void main(String[] args)
   {
      System.out.println(round(549.3299238, 3));
   
   }
}
