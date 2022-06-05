import java.util.Scanner;

public class MasterMindPlayer {
   private String playerType;
   private String playerName;
   public MasterMindPlayer(String playerType, String playerName){
      this.playerType = playerType;
      this.playerName = playerName;
   }
   public String getNextMove(int[][] scoreBoard, String[] gameBoard, Scanner sc, int turn){
      if(playerType.equals("computer")){
         return computerMove(scoreBoard, gameBoard, turn);
      }
      else{
         String fin;
         while(true){
            fin = sc.nextLine();
            if(fin.length() == 4){
               for(int i = 0; i < fin.length(); i++){
                  if(!(fin.charAt(i) == 'R' || fin.charAt(i) == 'G' || fin.charAt(i) == 'Y' || fin.charAt(i) == 'B' || fin.charAt(i) == 'M' || fin.charAt(i) == 'V')){
                     break;
                  }
               }
               return fin;
            }
            System.out.println("Try again, invalid answer");
         }
      }
   }
   private String computerMove(int[][] scoreBoard, String[] gameBoard, int turn){//doesn't really work
      char[][] charBoard = new char[5][6];
      for (int i = 0; i < 5; i++) {
         charBoard[i][0] = 'G';
         charBoard[i][1] = 'Y';
         charBoard[i][2] = 'B';
         charBoard[i][3] = 'M';
         charBoard[i][4] = 'R';
         charBoard[i][5] = 'V';
      }
      if(turn == 0){
         return "" + charBoard[1][(int)Math.random() * 4] + charBoard[2][(int)Math.random() * 4] + charBoard[3][(int)Math.random() * 4] + charBoard[4][(int)Math.random() * 4];
      }
      if(turn == 1){ //if the characters were all wrong, eliminate them as options.
         if(scoreBoard[0][0] == 0 && scoreBoard[0][1] == 0){
            for (int i = 0; i < 4; i++) {
               for (int j = 0; j < 6; j++) {
                  if(charBoard[j][5] == gameBoard[0].charAt(i)){
                     for (int j2 = 0; j2 < 5; j2++) {
                        charBoard[j][j2] = ' ';
                     }
                  }
               }
            }
         }
      }
      char tempChar;
      String tempString = "";
      for (int i = 0; i < 4; i++) {
         do{
            tempChar = charBoard[i][(int)Math.random()*4];
         }while(tempChar != ' ');
         tempString += tempChar;
      }
      return tempString;//return random available color for each spot in the code.
   }
   public String getName(){
      return playerName;
   }
}