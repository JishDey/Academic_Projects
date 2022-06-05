import java.util.Scanner;

public class CollatzCalculator{
    public static int calculator(int pnum){
        if(pnum%2 == 0){
            return pnum/2;
        }
        else{
            return (3 * pnum) + 1;
        }
    }
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("n:");
        int answer = a.nextInt();
        while(true){
            answer = calculator(answer);
            System.out.println(answer);
            if(answer == 1){
                break;
            }
        }
        
    }
}