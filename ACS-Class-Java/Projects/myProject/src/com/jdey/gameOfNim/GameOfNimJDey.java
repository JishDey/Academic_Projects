/* jdey
* Plays game of nim with computer player
* 10/19/20
*/

package com.jdey.gameOfNim;


public class GameOfNimJDey
{
    public String names(boolean player) //returns player 1 or 2 from boolean
    {
        String playerName;
        if(player)
                playerName = "Computer";
        else
                playerName = "Human";
        return playerName;
    }

    public void stonesVisual(int stonesLeft, int beingDrawn) //draws stones
    {
        while(stonesLeft > 0) // or stonesLeft - beingDrawn, check this
        {
            System.out.print("* ");
            stonesLeft--;
        }
        while(beingDrawn > 0)
        {
            System.out.print("o ");
            beingDrawn--;
        }
        System.out.println("");
    }

    public int stonesDrawnByComputer(int currentStones) //impliment computer player
    {
        int i = 0; // start with 1?
        int num = 0;
        int num2 = 0;
        while(currentStones - num >= 0)
        {
            num2 = num;
            num = (int)(Math.pow(2, i)) - 1; //formula for a series of numbers that always wins. Relies on the fact that a player can't reach less than halfof a current number.
            i++;
        }
        
        if(currentStones == num2) //if the player reaches the series of numbers
            return 1;
        else
            return currentStones - num2;
        
    }

    /* public static void main(String[] args) //functionally gets number of total stones
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
    } */
}