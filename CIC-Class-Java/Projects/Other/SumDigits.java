import java.util.Scanner;

public class NumberWorks{
	public static int sumDigits(int in){
		int sum = 0;
		while(in > 0){
			sum += in%10;
			in /= 10;
		}
		return sum;
	}

	public static int tally(){
		Scanner keeb = new Scanner(System.in);
		currentNum = 0;
		tally = 0;
		do{
			System.out.println(tally);
			System.out.println("Enter next number");
			currentNum = keeb.nextInt();
			tally ++;
		}
		while(currentNum != -999);
		return tally;
	}
	public static void main(String[] args) {
		System.out.println(tally());
	}
}
