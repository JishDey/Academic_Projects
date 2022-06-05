/* Jishnu Dey
*  Predator Prey project
*  3/4/22
*/

import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class PredatorPrey{
	private LinkedList<String> allAnimals;

	public PredatorPrey(ArrayList<String> animalIn){ // initializes the linked list of all animals
		allAnimals = new LinkedList<String>();
		while(animalIn.size() > 0){
			allAnimals.add(animalIn.remove((int)Math.random() * animalIn.size()));
		}
	}
	public static void main(String[] args) throws IOException{
		Scanner keyboard = new Scanner(System.in);
		String fileName;
			
		if (args.length > 0){
			fileName = args[0];
		}
		else{
			System.out.print("\nEnter input file name: ");
			fileName = keyboard.nextLine().trim();
		}
		BufferedReader file = getFile(fileName);						//the list of animals gets created from a text file with the animals in seperate lines
		ArrayList<String> animalIn = new ArrayList<String>();
		String line = file.readLine();
		while (line != null){
			animalIn.add(line);
			line = file.readLine();
		}
		PredatorPrey a = new PredatorPrey(animalIn);
		while (a.allAnimals.size() > 1) {								//game loop
			System.out.println("Animals remaining:" + a.allAnimals);
			System.out.println("Which predator catches it's prey?");
			a.tag(keyboard.nextLine());
		}
		System.out.println("Last Animal:" + a.allAnimals);
	}
	private static BufferedReader getFile(String fileName) throws IOException{ 
		BufferedReader file = new BufferedReader(new FileReader(fileName), 1024);
		return file;
	} 
	private void tag(String predator){           //uses a loop to find the animal that we're looking for
		Iterator irr = allAnimals.iterator();
		while (irr.hasNext()) {
			if(irr.next().equals(predator)){
				if(irr.hasNext()){
					irr.next();				    //this is the prey of the animal that we found
					irr.remove();
					return;
				}
				allAnimals.removeFirst();
				return;
			}
		}
		System.out.println("No animal caught");
	}
} 