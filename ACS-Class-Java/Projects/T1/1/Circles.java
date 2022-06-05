/* jdey
* calculations based on Math class
* 9/10/20
*/

public class Circles
{
   public static void main(String[] args)
   {
   
      double radius = 2.0;
      
      double area = Math.PI * radius * radius;
      //double area = Math.PI * Math.pow(radius, 2);
      double circ = 2 * radius * Math.PI;
      
      System.out.println("The area is " + area + " and the circumfurence is " + circ + ".");
   }
}