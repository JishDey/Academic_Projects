import info.gridworld.actor.Bug;

public class BoxBug extends Bug{
   private int side;
   private int steps;
   public BoxBug(){
      super();
      side = 5;
      steps = 0;
   }
   
   public BoxBug(int n){
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
      }
   }
   
}