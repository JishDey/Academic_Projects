/* 
 * 
 * 
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class HidingCritter extends Critter
{
   private Location home;
   private Rock heldRock;
   private int[] path;
   private int placeInPath;
   
   public HidingCritter(){
      home = getLocation();
      super();
   }
   
   private void hide(){
      //put rock down and disappear(retains home location)
   }
   private Location findRock(){
      Actor fin;
      Actor temp;
      for(int i = 0; i < getGrid.getNumRows(); i++){
         for(int j = 0; j < getGrid.getNumCols(); j++){
            temp = new Location(i, j);
            if(fin instanceof Rock){
               //(new possible rock, but has to be shorter distance) - (if fin != null && temp closerThan fin, fin = temp)
            }
         
   }
   
   public void setPath(Location rockLocation){
      
   }
   
  

    /**
     * 
     */
    public void makeMove(Location loc)
    {
         //if path empty, get rock
         if(path = null /*|| path.length = 0*/){ //path? or maybe placeInPath == path.length
            setPath(findRock());
            placeInPath = 0;
         //else follow the path
         else{
            
            placeInPath++;
         }
         //if the next location has a rock, move there and store the rock
         //else if the next location has another critter, move it out of the way
    }
    
    public void moveTo(Location newLocation){ 
         if(getGrid.get(newLocation) instanceof Rock){
            heldRock = getGrid.get(newLocation);
         }
         super.moveTo(newLocation);
}
