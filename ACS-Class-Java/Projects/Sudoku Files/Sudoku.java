/**
 @author Kendra Knudson
 modified by Jishnu Dey
 */
import java.util.*;



import java.io.File;
public class Sudoku {
	Cell[][] puzzlematrix;
	
	public Sudoku(){
		puzzlematrix = new Cell[9][9];
		readPuzzleFromFile(new File("puzzle3.txt"));
	}
	public static void main(String[] args){
			Sudoku game = new Sudoku();
			SudokuGui gui = new SudokuGui(game);
	}
	public void readPuzzleFromFile(File f){
		try{
			Scanner sc = new Scanner(f);
			for (int x = 0; x < puzzlematrix.length; x++){
				String line = sc.nextLine();
				Scanner lineScanner = new Scanner(line);
				for (int y = 0; y < puzzlematrix[x].length; y++){
					String s = lineScanner.next();
					if (s.equals(".")){
						puzzlematrix[x][y] = new Cell(x,y);
					}
					else{
						int i = Integer.parseInt(s);
						puzzlematrix[x][y] = new Cell(i,x,y);
					}
				}
			}
		}
		catch(Exception e){
			System.err.println("Error reading file");
		}
	}
	
	public void changeCell(int row, int col, int num){
		puzzlematrix[row][col].setNum(num);
	}
	public Cell getCell(int row,int col){
		return puzzlematrix[row][col];
		
	}
	public void changePencilMark(int row, int col, int index, int num){
		puzzlematrix[row][col].setPencilMarks(index, num);
	}
	public void printCell(int row, int col){
		System.out.print(puzzlematrix[row][col]);
	}
	public void printMatrix(){
		for (int i = 0; i < puzzlematrix.length; i++) {
			for (int j = 0; j < puzzlematrix[i].length; j++) {
				this.printCell(i, j);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public boolean checkFinished(){
		boolean fin = true;
		for (int i = 0; i < 9; i++) {
			fin = fin && checkRow(i) && checkCol(i);
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				fin = fin && checkBox(3* i, 3* j);
			}
		}
		return fin;
	}
	
	private boolean checkRow(int row){
		boolean[] aboolarray = new boolean[9];
		for (int i = 0; i < puzzlematrix[row].length; i++) {
			if(aboolarray[puzzlematrix[row][i].getNum()-1]){
				return false;
			}
			aboolarray[puzzlematrix[row][i].getNum()-1] = true;
		}
		return true;
	}
	
	
	private boolean checkCol(int col){
		boolean[] aboolarray = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if(aboolarray[puzzlematrix[i][col].getNum()-1]){
				return false;
			}
			aboolarray[puzzlematrix[i][col].getNum()-1] = true;
		}
		return true;
	}
	
	//top right corner of each box
	private boolean checkBox(int row, int col){
		boolean[] aboolarray = new boolean[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(puzzlematrix[i+row][j+col].getNum() <= 0 || puzzlematrix[i+row][j+col].getNum() > 9){
					return false;
				}
				else if(!aboolarray[puzzlematrix[i+row][j+col].getNum()-1]){
					aboolarray[puzzlematrix[i+row][j+col].getNum()-1] = true;
				}
				else{
					return false;
				}
				
			}
		}
		return true;
	}
}
