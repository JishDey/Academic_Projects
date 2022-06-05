import java.util.Scanner;
public class Todel
{
    public static boolean isLeapYear(int year)
    {
        boolean trueorfalse = year%4 == 0 && (year%100 != 0 || year%400 == 0);
        return trueorfalse;
    }
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Year: ");
        int year = keyboard.nextInt();
        System.out.println(isLeapYear(year));
    }
}