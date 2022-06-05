import java.util.Arrays;
import java.util.Scanner;

public class JDeyMasterMindGame{
    private char[][] gameBoard = new char[13][4];
    private int[][] scoreBoard = new int[13][2];
    private char[] code = new char[4];
    private Scanner sc = new Scanner(System.in);
    private String answer = "";
    public JDeyMasterMindGame(){
        boolean flag;
        do{
            flag = false;
            System.out.println("What is your code? Respond in a sequence of R, G, Y, B, M, V");
            String codeS = sc.nextLine();
            for (int i = 0; i < code.length; i++) {
                if(codeS.charAt(i) == 'R' || codeS.charAt(i) == 'G' || codeS.charAt(i) == 'Y' || codeS.charAt(i) == 'B' || codeS.charAt(i) == 'M' || codeS.charAt(i) == 'V'){
                    code[i] = codeS.charAt(i);
                    answer += codeS.charAt(i);
                }
                else{
                    System.out.println("Try writing a seqence with R, G, Y, B, M, V.");
                    flag = true;
                }
            }
            System.out.println("\n \n \n \n \n \n \n \n \n");
        }while(flag);
        gameBoard[0] = code;
    }
    public void printBoard(int numRows){
        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println(" ");
            for (int j = 0; j < 2; j++) {
                System.out.print(scoreBoard[i][j]);
            }
            System.out.println();
        }
    }
    public void runGame(){
        String guess;
        int i = 1;
        while(i<13){
            System.out.println("Guess the code. You can choose G, Y, B, M, R, V.");
            guess = sc.nextLine();
            if(answer.equals(guess)){
                System.out.println("correct code");
                break;
            }
            else{
                int numRight = 0;
                int numFound = 0;
                for (int j = 0; j < code.length; j++) {
                    gameBoard[i][j] = guess.charAt(j);
                    if(gameBoard[i][j] == gameBoard[0][j]){
                        numRight++;
                    }
                    int n = 4;
                    for (int j2 = 0; j2 < n; j2++) {
                        if(gameBoard[0][j] == guess.charAt(j2)){
                            numFound++;
                            guess = guess.substring(0, j2) + guess.substring(j2);
                            n--;
                        }
                    }
                }
                scoreBoard[i][0] = numRight;
                scoreBoard[i][1] = numFound - numRight;
                System.out.println("You have " + numRight + " correct colors in the correct place, and " + (numFound - numRight) + " correct colors in the wrong spaces.");
            }
            printBoard(i);
            i++;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        JDeyMasterMindGame a = new JDeyMasterMindGame();
        a.runGame();
    }
}