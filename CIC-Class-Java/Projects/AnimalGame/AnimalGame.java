import java.util.Scanner;

public class AnimalGame
{
   private TreeNode root = null;
   private TreeNode pNode = null;
   private TreeNode cNode = null;
   private Scanner kb = null;
   
   public AnimalGame()//constructor, initializes root, keyboard, and the current node
   {
      root = new TreeNode("Panda");
      kb = new Scanner(System.in);
      cNode = root;
   }
   
   public static void main(String[] args)
   {
      AnimalGame game = new AnimalGame();
      game.handleGame();
   }
   
   public void handleGame()
   {
      boolean playAgain = true;
      while (playAgain)// main loop to give the computer more guesses
      {
         guess();
         System.out.println("Would you like to play again?");
         String answer = kb.nextLine();
         if (answer.charAt(0)==('n'))
         {
            playAgain = false;
         }
      }
   }
   
   public void guess()
   {
      cNode = root; //every time the game is played, processing starts from the root
      while(!(cNode.getLeft()==null) && !(cNode.getRight()==null)) //while not a leaf
      {
         System.out.println(cNode.getValue());
         String answer = kb.nextLine();
         pNode = cNode;                         //iterate down tree
         if (answer.charAt(0)==('y'))
            cNode = cNode.getRight();
         else
            cNode = cNode.getLeft();
      }

      //process leaf
      System.out.println("Is it a " + cNode.getValue() + "?"); 
      String answer = kb.nextLine();
      if (answer.charAt(0)==('y'))
         System.out.println("I win!!!");
      else
         insertNode();
   }
   
   public void insertNode() //insert a new node at wrong leaf cNode
   {
      System.out.println("What was your animal?");
      String animal = kb.nextLine();
      System.out.println("Please state your question.");
      String question = kb.nextLine();
      TreeNode newNode = new TreeNode(question, cNode, new TreeNode(animal)); //incorrect cNode added left, new animal added right
      
      //if we're at the root, add new node to root
      if(root.getLeft()==null){
          root = newNode;
      }

      //otherwise add new node to cNode's previous location
      else if (cNode == pNode.getLeft()) {
          pNode.setLeft(newNode);
      }
      else{
        pNode.setRight(newNode); 
      }
   }
}