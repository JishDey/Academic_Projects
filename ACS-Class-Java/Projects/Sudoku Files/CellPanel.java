import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;



/*
 * This class sets up a gui component representing a single Sudoku cell, with a number
 * field and 6 pencil mark fields
 * 
 * Created on Nov 10, 2005
 * @author kendra
 *
 */
public class CellPanel extends JPanel {

	private JFormattedTextField numField;
	private JFormattedTextField pencil1;
	private JFormattedTextField pencil2;
	private JFormattedTextField pencil3;
	private JFormattedTextField pencil4;
	private JFormattedTextField pencil5;
	private JFormattedTextField pencil6;

	private int row; //this cell's location
	private int col;//this cell's location
	private Sudoku game; //a reference to the main Sudoku game -- the "brains"
	private boolean numEditable; //indicates if the main number is editable (or if it was set by the game)
	
	/*
	 * Constructor
	 */
	public CellPanel(Sudoku game, int row, int col, boolean numEditable) {
		this.game = game;
		this.row = row;
		this.col = col;
		this.numEditable = numEditable;
		setLayout(new GridBagLayout());
		makeComponents();
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));		
	}
	
	/*
	 * makeComponents sets up all the gui components for a single cell in the Sudoku game
	 * 
	 */
	public void makeComponents(){
		makeTextFields();   //make the text boxes
		GridBagConstraints c = new GridBagConstraints(); //constraints are needed to make the gui look nice
		
		//add the first row of pencil marks
		c.weightx = .2; c.ipadx = 10; 
		c.gridx = 0; c.gridy = 0;   add(pencil1, c);
		c.gridx = 1; c.gridy = 0; add(pencil2, c);
		c.gridx = 2; c.gridy = 0; add(pencil3, c);
		
		//add the number box to the middle to of the cell area
		c.insets = new Insets(2,0,0,0);  //top padding
		c.ipady = 10;  c.ipadx = 40;  
	    c.weightx = 0; c.weighty = 1;
	    c.gridwidth = 6; 
	    c.gridheight = GridBagConstraints.RELATIVE;
		c.gridx = 0; c.gridy = 1; add(numField, c);
		
		//add the bottow row of pencil marks
		c.insets = new Insets(1,0,1,0);  //top & bottom padding
		c.weightx = .2; c.ipadx = 10;
		c.ipady = 20;  c.gridwidth = 1; c.gridheight = 1;
		c.gridx = 0; c.gridy = 2;  add(pencil4, c);
		c.gridx = 1; c.gridy = 2;add(pencil5, c);
		c.gridx = 2; c.gridy = 2; add(pencil6, c);
		
	}
	
	/*
	 * This method sets up each of the 7 text fields (the main number one and the six small pencil
	 * marks
	 */
	private void makeTextFields(){
		
		Font pencilFont = new Font("Helvetica", Font.ITALIC, 10);
		
	     pencil1 = new JFormattedTextField(createFormatter("#"));
		 pencil1.setColumns(1); 
		 pencil1.setBorder(BorderFactory.createEmptyBorder() ); 
		 pencil1.setFont(pencilFont); pencil1.setForeground(Color.GRAY);
		 pencil1.addActionListener(new TextListener());
		 
		 pencil2 = new JFormattedTextField(createFormatter("#"));
		 pencil2.setColumns(1);
		 pencil2.setBorder(BorderFactory.createEmptyBorder() ); 
		 pencil2.setFont(pencilFont); pencil2.setForeground(Color.GRAY);
		 pencil2.addActionListener(new TextListener());
		 
		 pencil3 = new JFormattedTextField(createFormatter("#"));
		 pencil3.setColumns(1);
		 pencil3.setBorder(BorderFactory.createEmptyBorder() ); 
		 pencil3.setFont(pencilFont); pencil3.setForeground(Color.GRAY);
		 pencil3.addActionListener(new TextListener());
		 
		 pencil4 = new JFormattedTextField(createFormatter("#"));
		 pencil4.setColumns(1);
		 pencil4.setBorder(BorderFactory.createEmptyBorder() ); 
		 pencil4.setFont(pencilFont); pencil4.setForeground(Color.GRAY);
		 pencil4.addActionListener(new TextListener());
		 
		 pencil5 = new JFormattedTextField(createFormatter("#"));
		 pencil5.setColumns(1);
		 pencil5.setBorder(BorderFactory.createEmptyBorder() ); 
		 pencil5.setFont(pencilFont); pencil5.setForeground(Color.GRAY);
		 pencil5.addActionListener(new TextListener());
		 
		 pencil6 = new JFormattedTextField(createFormatter("#"));
		 pencil6.setColumns(1);
		 pencil6.setBorder(BorderFactory.createEmptyBorder() ); 
		 pencil6.setFont(pencilFont); pencil6.setForeground(Color.GRAY);
		 pencil6.addActionListener(new TextListener());
		 
		 Font numFont = new Font("Helvetica", Font.BOLD, 24);
		 numField = new JFormattedTextField(createFormatter("#")); 
		 numField.setFont(numFont); numField.setHorizontalAlignment(JTextField.CENTER);
		 if(!numEditable){
		 	numField.setText(new Integer(game.getCell(row, col).getNum()).toString());
		 }
		 numField.setEditable(numEditable);
		 numField.addActionListener(new TextListener());
	
	}
	
	/*
	 * This method (modified from a Sun example for formatted text fields) makes it so that the 
	 * numfields can only contain numbers 1-9
	 */
	protected MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	        formatter.setInvalidCharacters("0");
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}

	/*
	 *  returns a String representation of a CellPanel, but this methd is a little weird because
	 * I couldnt' figure out what was actually stored in an empty textfield
	 */
	public String toString(){
		String s = "";
		try{
			if(!numField.getText().equals("") || numField.getText() != null){
				//can't seem to figure out what the text in an empty cell is, so trying to convert
				//it to an int works to find the "empty" cells
				int num2=  Integer.parseInt(numField.getText()); 
				s += numField.getText();
			}
			else{
				s += ".";
			}
		}
		catch(Exception e){
			s = ".";
		}
		return s;
	}
	/*
	 * Internal Class - this class implements the ActionListener interface and listens for
	 * events in which the user types in a text field
	 */
	private class TextListener implements ActionListener{

		/*
		 * TODO: Change this code so that it interacts properly with the game (Sudoku.java) or (Cell.java)
		 */
		public void actionPerformed(ActionEvent event){

			// here is some example code for one of the events that can happen
			if(event.getSource() == pencil1){
				//num will contain the integer that the user typed into pencil1 textfield
				int num = Integer.parseInt(pencil1.getText());
				game.changePencilMark(row, col, 0, num);
			}
			else if(event.getSource() == pencil2){
				//num will contain the integer that the user typed into pencil1 textfield
				int num = Integer.parseInt(pencil2.getText());
				game.changePencilMark(row, col, 1, num);
			}
			else if(event.getSource() == pencil3){
				//num will contain the integer that the user typed into pencil1 textfield
				int num = Integer.parseInt(pencil3.getText());
				game.changePencilMark(row, col, 2, num);
			}
			else if(event.getSource() == pencil4){
				//num will contain the integer that the user typed into pencil1 textfield
				int num = Integer.parseInt(pencil4.getText());
				game.changePencilMark(row, col, 3, num);
			}
			else if(event.getSource() == pencil5){
				//num will contain the integer that the user typed into pencil1 textfield
				int num = Integer.parseInt(pencil5.getText());
				game.changePencilMark(row, col, 4, num);
			}
			else if(event.getSource() == pencil6){
				//num will contain the integer that the user typed into pencil1 textfield
				int num = Integer.parseInt(pencil6.getText());
				game.changePencilMark(row, col, 5, num);
			}
			else if(event.getSource() == numField){
				//num will contain the integer that the user typed into pencil1 textfield
				int num = Integer.parseInt(numField.getText());
				game.changeCell(row, col, num);
			}
					
		}
		
	}
}

