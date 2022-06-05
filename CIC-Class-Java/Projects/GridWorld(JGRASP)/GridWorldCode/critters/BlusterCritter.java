import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

public class BlusterCritter{
   private int c;
   public BlusterCritter(int c){
      super();
      this.c = c;
   }
   
   public ArrayList<Actors> getActors(){
   ArrayList<Actors> actors = new ArrayList<Actors>();
   
      Location loc = this.getLocation();
      int r = loc.getRow-2;
      int c = col.getCol-2;
      for(int i = 0; i < 25; i++){
         current = new Location(i/5, i%5); 
         if(i != 13 &&getGrid().isValid(current)){
            actors.add(getGrid.get(current);
         }
      return actors 
   }
   
   public void processActors(ArrayList <Actor> actors){
      for(Actor a: actors){
         if(a instanceof critter){
            sum++;
         }
      if(c<sum){
         
      }
}