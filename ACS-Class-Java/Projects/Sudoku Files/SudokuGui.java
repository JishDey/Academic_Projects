import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


/**
 * This class is the overall gui for a Sudoku game. it needs a reference to the actual game when it is 
 * constructed, to provide call backs to, as the user inputs things into the gui
 * 
 * The gui is meant to be light-weight and not to do any of the "smarts" of the game
 * 
 *  @author kendra knudtzon
 *
 */
public class SudokuGui extends JFrame {
	
	Sudoku game; // a reference to the actual game
	
	JPanel board; // A gui panel to hold the board
	JPanel gridPanel; //the panel to hold all the cells
	
	JLabel gameStatus;		//a text label to hold the game status
	CellPanel[][] cellArray;	//a 2d array to keep track of the textField cellPanels

	JButton checkGame; 
	JButton importPuzzle;
	
	boolean gameOver = false;
	
	public SudokuGui(Sudoku game){

		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Make the window icon something nice
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Image icon = tk.createImage("images\\blossomSmall.gif" );
		setIconImage(icon);

		//Set up the Panel for the board
		board = new JPanel();
		board.setBackground(Color.darkGray);
		board.setLayout(new BorderLayout());
		board.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	
		cellArray = new CellPanel[9][9];

		//Make the top status panel
		JPanel topPanel = new JPanel();
		gameStatus = new JLabel("Still Playing...");
		topPanel.add(gameStatus);
		board.add(BorderLayout.NORTH, topPanel);

		//Make individual cells
		makeGridPanel();
	
		//Make the buttons at the bottom of the gui
		JPanel bottomPanel = new JPanel();
		 checkGame = new JButton("CheckGame");
		checkGame.addActionListener(new ButtonListener());
		bottomPanel.add(checkGame);
		 importPuzzle = new JButton("SetAsGameBoard");
		importPuzzle.addActionListener(new ButtonListener());
		bottomPanel.add(importPuzzle);
		
		board.add(BorderLayout.SOUTH, bottomPanel);
		//make the board part of the interface as the content pane
		setContentPane(board);

		//display on screen correctly
		setTitle("Sudoku");
		pack();
		setVisible(true);
	}

	/**
	 * Sets up the grid panel that holds the individual CellPanels
	 */
	private void makeGridPanel(){

		GridLayout tilesGrid= new GridLayout(3,3);
		tilesGrid.setVgap(1);
		tilesGrid.setHgap(2);
		gridPanel = new JPanel(tilesGrid);
		//make the individual cells
		for (int row = 0; row < 9; row++){
			for(int col = 0; col < 9; col++){
				CellPanel p = new CellPanel(game, row, col, game.getCell(row, col).isChangeable());
				cellArray[row][col] = p;					
			}
		}
		
		makeBoxPanels(); //draws the boxes around the groups of 9 cells
		board.add(BorderLayout.CENTER, gridPanel);
	} 

	/*
	 * this method makes the boxes
	 * A box is a 3 x 3 square in the game
	 */
	public  void makeBoxPanels(){
		//This code is kind of strange, but it needs to go 3x3 to grab the cells and make
		// a panel with a border so that the gui looks like a normal Sudoku board
		for (int boxRow = 0; boxRow < 9; boxRow+=3){
			for (int boxCol = 0; boxCol < 9; boxCol+=3){
				JPanel box = new JPanel(new GridLayout(3,3));
				Border b = BorderFactory.createLineBorder(Color.BLACK, 3);
				box.setBorder(b);
		
				//Take a set of 9 cells and make a box, by adding the cells to this box
				for (int row = boxRow; row < boxRow+3; row++){
					for(int col = boxCol; col < boxCol+3; col++){
						box.add(cellArray[row][col]);
					}
				}
				gridPanel.add(box);//add each box to the overall grid panel
			}
		}
	}		

	
	/*
	 * This method starts the gui, giving it a fake game, this is only for testing and integration purposes,
	 * as the real game should start from the Sudoku.java class, which should create the SudokuGui instance, 
	 * passing in itself as a parameter to the constructor: by doing
	 * SudokuGui gui = new SudokuGui(this); //the this is the Sudoku object
	 */
	//public static void main(String[] args){
		//SudokuGui gui = new SudokuGui(new Sudoku(true)); //fake game
		
	//}
	
	/*
	 * Internal Class, ButtonListener waits for button click events, calling the proper methods
	 * TODO: adjust as necessary
	 * @author kendra
	 */
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == checkGame ){
				boolean win = game.checkFinished();
				if (win == true)
					gameStatus.setText("YOU WIN!!!!");
				else
					gameStatus.setText("Sorry not correct");
			}
			else if (event.getSource() == importPuzzle){
				System.out.println("Import not yet implemented");
				// TODO:  You guys need to figure out this part:
				//game.getPuzzleFromGui();
			}
		}
	}
}
