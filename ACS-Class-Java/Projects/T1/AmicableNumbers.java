/* jdey
* finding amicable numbers
* 11/6/20
*/

import java.util.Scanner;
public class AmicableNumbers
{
    public static int sumOfFactors(int num) //finds the sum of factors of num
    {
        int factorSum = 0;
        for (int i = 1; i <= num/2; i++)
        {
            if(num%i == 0) //adds a number to the sum if it is a factor
            {
                factorSum += i;
            }
        }
        return factorSum;
    }

    public static boolean amicableOrNot(int friendOne, int friendTwo) // finds if friends are amicable
    {
        return sumOfFactors(friendOne) == friendTwo && sumOfFactors(friendTwo) == friendOne;
    }

    public static int findFriend(int num)
    {
        int possibleFriend = sumOfFactors(num);
        boolean friendFound = amicableOrNot(num, possibleFriend);
        if(friendFound)
            return possibleFriend;
        else
            return -1;
    }
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("The sum of all factors of 12 is " + sumOfFactors(12) + " and the sum of all factors of 9 are " + sumOfFactors(9) + "."); //test for method 1
        System.out.println( "284 and 220 are amicable: " + amicableOrNot(284, 220)); //test for method 2
        System.out.println("Is your number amicable? Number: ");
        int answer = keyboard.nextInt();
        int friend = findFriend(answer); //test for method 3
        if(friend == -1) 
        {
            System.out.println("no friends");
        }
        else
        {
            System.out.println(friend + "is the friend.");
        }
    }

}