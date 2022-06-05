import java.util.Scanner;
public class TwoPoints
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("x1 y1 x2 y2");
      int x1 = keyboard.nextInt();
      int y1 = keyboard.nextInt();
      int x2 = keyboard.nextInt();
      int y2 = keyboard.nextInt();
      
      int slope = (y2 - y1) / (x2 - x1);
      int midpointX = (x1+x2)/2;
      int midpointY = (y1+y2)/2;
   
      System.out.println("The slope is " + slope + ", and the midpoint is ("+ midpointX + ", " + midpointY + ").");
   
   }
   
}