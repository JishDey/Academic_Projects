package com.jdey.gameOfNim;

import java.util.Scanner;

public class Game 
{
    public static void main(String[] args) //functionally gets number of total stones
    {
        GameOfNimJDey game = new GameOfNimJDey();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How many total stones should there be? Let's play with twenty or more.");
        int numberOfStones = keyboard.nextInt();
        while(numberOfStones < 20)
        {
            System.out.println("Let's play with twenty or more.");
            numberOfStones = keyboard.nextInt();
        }
        boolean turn = true;

        while(numberOfStones > 0) //runs the game. Should be > 1.
        {
            int stonesDrawn;
            System.out.println(game.names(turn) + " player, how many stones will you draw?");
            if(turn)
                stonesDrawn = game.stonesDrawnByComputer(numberOfStones);
            else
                stonesDrawn = keyboard.nextInt();

            if(stonesDrawn <= numberOfStones/2 && stonesDrawn > 0)
            {
                numberOfStones -= stonesDrawn;
                game.stonesVisual(numberOfStones, stonesDrawn);
            }
            else if(numberOfStones == 1) //end of the game - to draw the final stone, which is less than half
                numberOfStones -= stonesDrawn;
            else //player plays a number that can't be played.
            {
                System.out.println("You can't do that! Try a number less than half the stones left.");
                turn = !turn;
            }
            
            System.out.println("There are " + numberOfStones + " stones left.");
            turn = !turn;

        }
        
        System.out.println(game.names(turn) + " player has won!");
        keyboard.close();
    }
}
