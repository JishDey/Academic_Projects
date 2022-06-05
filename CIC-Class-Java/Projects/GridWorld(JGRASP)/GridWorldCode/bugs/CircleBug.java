import info.gridworld.actor.Bug;

public class CircleBug extends Bug{
   private int side;
   private int steps;
   public CircleBug(){
      super();
      side = 5;
      steps = 0;
   }
   
   public CircleBug(int n){
      super();
      side = n;
      steps = 0;
   }
   
   public void act(){
      if(canMove() && steps < side){
         move();
         steps ++;
      }
      else {
         turn();
         steps = 0;
      }
   }
   
}