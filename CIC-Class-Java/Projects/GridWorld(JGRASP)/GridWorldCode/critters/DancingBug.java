/*
   Jishnu Dey
   11/10/21
   Bug that dances around according to a pattern and changes color
   Note: Only works in unbounded grid
*/

import info.gridworld.actor.Bug;
import java.awt.Color;

public class DancingBug extends Bug{
   private int steps;
   private int[] turnList;
   public DancingBug(int[] turnList){ //constructor that accepts the list of turn per move
      super();
      steps = 0;
      this.turnList = turnList;
   }
   
   public void act(){
      if(canMove()){ //moves the bug if it's allowed to
         move();
         for(int i = 0; i < turnList[steps]; i++) //if the bug is able to move, it will also turn as specified by the turnList
            turn();
         //random color values for each new move - the bug will change color every turn
         int r =(int) (1 + (Math.random() * 225));
         int g =(int) (1 + (Math.random() * 225));
         int b =(int) (1 + (Math.random() * 225));
         setColor(new Color(r,g,b)); //sets the bug to random color
      }
      else { //otherwise, the bug turns until it finds a move that it can make
         turn();
      }
      steps++;
      steps %= turnList.length;
   }
   
}
