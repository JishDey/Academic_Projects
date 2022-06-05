import info.gridworld.actor.Bug;

public class SpiralBug extends Bug{
   private int side;
   private int steps;
   public SpiralBug(){
      super();
      side = 5;
      steps = 0;
   }
   
   public SpiralBug(int n){
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
         turn();
         steps = 0;
         side ++;
      }
   }
   
}