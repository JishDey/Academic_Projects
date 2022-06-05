package com.jdey.general;
import java.util.Scanner;
public class RecursionExample{
    /*public long factorial(long argument) {
        long finalNum = 1;
        for (int i = 1; i <= argument; i++) {
            finalNum *= i;
        }
        return finalNum;
    } */

    
    
    public long factorial(long num) {
        if(num > 1){
            num *= factorial(num-1);
        }
        return num;
    }

    public static void main(String[] args) {
        RecursionExample j = new RecursionExample();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Factorial what?");
        int argument = keyboard.nextInt();
        System.out.println(j.factorial(argument));
        //System.out.println(j.myDouble(argument));
        keyboard.close();
    }
}