import java.util.Scanner;

public class JishnuMasterMindGame {
   private static Scanner sc = new Scanner(System.in);
   private String answer;
   private String[] gameBoard = new String[12];
   private int[][] scoreBoard = new int[12][2];
   private MasterMindPlayer masterMind = new MasterMindPlayer("mastermind", "mastermind");
   private MasterMindPlayer[] players;
   public JishnuMasterMindGame(int numPlayers){
      System.out.println("The first player is the mastermind");
      players = new MasterMindPlayer[numPlayers - 1];
      System.out.println("computer or human?");
      if(sc.nextLine().equals("computer")){
         players[0] = new MasterMindPlayer("computer", "com");
      }
      else{
         for (int i = 0; i < numPlayers -1; i++) {
            System.out.println("Enter your player name");
            String name = sc.nextLine();
            players[i] = new MasterMindPlayer("human", name);
         }
      }
      System.out.println("Mastermind, enter your code. The colors are You can choose G, Y, B, M, R, V.");
      answer = masterMind.getNextMove(scoreBoard, gameBoard, sc, 0);
   }
   public void runGame(){
      String guess;
      int numInRightPlace;
      int numRightColor;
      for (int i = 0; i < gameBoard.length; i++) {
         System.out.println(players[i%players.length].getName() + " , pick your guess.");
         guess = players[i%players.length].getNextMove(scoreBoard, gameBoard, sc, i);
         if(guess.equals(answer)){
            System.out.print("Code guessed. You won!");
            break;
         }
         else{
            gameBoard[i] = guess;
            numInRightPlace = rightPlace(guess);
            numRightColor = numCorr(guess);
            scoreBoard[i][0] = numInRightPlace;
            scoreBoard[i][1] = numRightColor;
            System.out.println(numInRightPlace + " " + numRightColor);
            printScoreBoard(i);
         }
      }
   }
   private int rightPlace(String in){
      int x = 0;
      for (int i = 0; i < 4; i++) {
         if(answer.charAt(i) == in.charAt(i)){
            x++;
         }
      }
      return x;
   }
   private int numCorr(String in){
      int s1l = 4;
      int s2l = 4;
      int x = 0;
      String temp = answer;
      for (int i = 0; i < s1l; i++) {
         for (int j = 0; j < s2l; j++) {
            if(in.charAt(i) == temp.charAt(j)){
               in = in.substring(0, i) + in.substring(i +1);
               temp = temp.substring(0, j) + temp.substring(j + 1);
               x++;
               s1l--;
               s2l--;
            }
         }
      }
      return x;
   }
   private void printScoreBoard(int n){
      for (int i = 0; i < n; i++) {
         System.out.print(gameBoard[i]);
         System.out.println("  " + scoreBoard[i][0] + "," + scoreBoard[i][1]);
      }
   }
   public static void main(String[] args) {
      System.out.println("how many players do you want to have?");
      int numPlayers = sc.nextInt();
      sc.nextLine();
      JishnuMasterMindGame a = new JishnuMasterMindGame(numPlayers);
      a.runGame();
   }
}
