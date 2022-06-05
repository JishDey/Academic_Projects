/* jdey
* converting Farenheight to Celcius
* 09/20/20
*/

import java.util.Scanner;
public class DeyFarenheightToCelcius
{
   
   private static double round(double num, int place) //rounding method with parameters
   {
      double scale = Math.pow(10,place);
      double temp = num * scale;
      double tempad5 = temp + 0.5;
      int tempI = (int)tempad5;
      double answer = tempI/scale;
      return answer;
   };
   
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Temperature in F");
      int tempinf  = input.nextInt();
      double farenheight = tempinf; // Stores int as double.
      double celcius = (farenheight - 32) * 5/9; // Changes the farenheight to celcius
      double celciusRounded = round(celcius, 2); //Uses round method to round the result.
      System.out.println(celciusRounded + " in C.");
   
   } // end main
} // end class
