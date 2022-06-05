import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizGame {
    private String[][] questionAnswer;
    private String typeZero; //latin
    private String typeOne;  //english
    private int endI;//end index, everything after has been discarded

    public QuizGame(Scanner sc) throws FileNotFoundException{ 
        System.out.println("What is the name of your quiz file?");
        String nl = sc.nextLine();
        File txt = new File(nl);
        Scanner sd = new Scanner(txt);
        String questionTypes = sd.nextLine();
        int dash = questionTypes.indexOf('-');
        typeZero = questionTypes.substring(dash + 1).trim(); //type (e.g. english)
        typeOne = questionTypes.substring(0, dash).trim();   //type (e.g. latin)
        int count = 0;
        while(sd.hasNextLine()){    //Find how many lines the document has.
            sd.nextLine();
            count++;
        }
        questionAnswer = new String[count][2];
        sd.close();
        sd = new Scanner(txt);//resets sd to the top of the file.
        sd.nextLine();  //skip the first line, which is supposed to define the types (language) of terms.
        for (int i = 0; i < count; i++) {     //initialize questionAnswer
            String QAset = sd.nextLine();
            dash = QAset.indexOf('-');
            questionAnswer[i][0] = QAset.substring(0, dash).trim();
            questionAnswer[i][1] = QAset.substring(dash + 1).trim(); 
        }
        endI = questionAnswer.length - 1;
        sd.close();
    }

    public void runGame(Scanner sc){// runs game
        int question;
        int answer;

        while(true){ //answer with type one (e.g. english) or type zero (e.g. latin);
        System.out.println("Do you want to answer with " + typeZero + " or " + typeOne + "?");
        String nl = sc.nextLine(); 
            if (nl.equals(typeZero)) {
                question = 0;
                answer = 1;
                break;
            }
            else if(nl.equals(typeOne)) {
                question = 1;
                answer = 0;
                break;
            }
            System.out.println("Not available");
        }
        while(endI >= 0){     //main loop
            int num = (int) (Math.random()*(endI + 1)); //choose a random questionAnswer set
            System.out.println(questionAnswer[num][question]);
            String rep = sc.nextLine();
            if(questionAnswer[num][answer].equals(rep)){
                String[] tmp = questionAnswer[num];
                questionAnswer[num] = questionAnswer[endI];
                questionAnswer[endI] = tmp; //last three lines - if correct, swap with last but 1.
                System.out.println("Correct, only " + (endI) + " left to go.");
                endI--;
            }
            else{
                System.out.println("Incorrect, it was " + questionAnswer[num][answer] + ".");
            }
            
        }
        System.out.println("complete.");
    }
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); //scanner is outside bc it didn't break that way. I did some messing with the scanners and I had some issues with the closed scanners.
        try{
            QuizGame a = new QuizGame(sc);
            a.runGame(sc);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        sc.close();
    }
}