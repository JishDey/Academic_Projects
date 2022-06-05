/*
   Jishnu Dey
   11/10/21
   Bug that draws 'RG' for 'Ralph Greenman' (no idea if that's a real person)
   Note: Only works in unbounded grid
*/

import info.gridworld.actor.Bug;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class InitialBugRG extends Bug{
   private int steps;
   private int[] turnList;
   private int[] turnList2;
   public InitialBugRG(){
      super();
      steps = 0;
      this.turnList = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1, 0, 1, 1, 0, 5, 0, 0, 1, 0, 0, 6}; //the letter R, in turns
      this.turnList2 = new int[]{0, 0, 7, 0, 7, 7, 7, 0, 4, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0}; //the letter G, in turns
   }
   
   public void sneak(){ //sneaks across the letters without drawing
      Grid<Actor> gr = getGrid();
      if (gr == null)
      return;
      Location loc = getLocation();
      Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()).getAdjacentLocation(0).getAdjacentLocation(getDirection()); //past the j to the next letter
      if (gr.isValid(next))
         moveTo(next);
      else
         removeSelfFromGrid();
   }
   
   public void act(){
      if(canMove() && steps < turnList.length){ //moves the bug if it's allowed to and while there are steps left to perform
         move();
         for(int i = 0; i < turnList[steps]; i++) //if the bug is able to move, it will also turn as specified by the turnList
            turn();
         steps++;
      }
      else if (steps < turnList.length + 1){
         sneak();
         steps++;
      }
      else if(canMove() && steps < turnList.length + turnList2.length){ //moves the bug if it's allowed to and while there are steps left to perform
         move();
         for(int i = 0; i < turnList2[steps - turnList.length]; i++) //if the bug is able to move, it will also turn as specified by the turnList
            turn();
         steps++;
      }
   }
   
}
