import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WarGameJDey{
	public static ArrayList<Integer> allcards = new ArrayList<Integer>();
	public Queue<Integer> player1 = new LinkedList<Integer>();
	public Queue<Integer> player2 = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		WarGameJDey a = new WarGameJDey();
		System.out.println(a.player1);
		a.playGame();
	}
	
	public WarGameJDey(){
		for (int i = 1; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				allcards.add(i);
			}
		}
		while(allcards.size()>0){
			player1.add(allcards.remove((int)(allcards.size()* Math.random())));
			player2.add(allcards.remove((int)(allcards.size()* Math.random())));
		} 
	}

	public static String numToCard(int in){      //converts 1, 11, 12, 13 to respective face cards
		switch (in) {
			case 1:
				return "Ace";
			case 11:
				return "Joker";
			case 12:
				return "Queen";
			case 13:
				return "King";
			default:
				return in + "";
		}
		
	}

	public void playGame(){ 
		Scanner kbd = new Scanner(System.in);
		Queue<Integer> hold = new LinkedList<Integer>();
		while(!player1.isEmpty() && !player2.isEmpty()){
			System.out.println("Deck sizes: you: " + player1.size() + ", computer: " + player2.size());
			int p1 = player1.remove();
			int p2 = player2.remove();
			System.out.print("You had had a " + numToCard(p1) + ". The computer had a " + numToCard(p2) + ".");
			hold.add(p1);
			hold.add(p2);
			if (p1 > p2) {                       //your card is greater
				System.out.println(" You get " + hold.size() + " cards.");
				while(!hold.isEmpty()){
					player1.add(hold.remove());  //adds all cards from cards currently in play
				}
			} else if (p2 > p1){                 //computer card is greater
				System.out.println(" Computer gets " + hold.size() + " cards.");
				while(!hold.isEmpty()){
					player2.add(hold.remove());  //adds all cards from cards currently in play
				}
			} else {                             //the two cards are equal
				System.out.println(" War!");
				for (int i = 0; i < 3; i++) {    //takes three cards from each
					hold.add(player1.remove());
					hold.add(player2.remove());
				}
			}
			kbd.nextLine();                      //waits for enter between turns
			//System.out.println(hold);
			//System.out.println()
		}
		if (player1.size() == 0) {
			System.out.println("computer won!");
		} else {
			System.out.println("you win!");
		}
	}
}
