
public class Cell {
	private int num;
	private boolean changeable;
	private int[] pencilMarks = new int[6];
	int row;
	int col;
	
	/*
	 * if a num is provided, assume changeable is false
	 */
	public Cell(int num, int row, int col){
		this.num = num;
		changeable = false;
		this.row = row;
		this.col = col;
	}
	/*
	 * if a num isnt provided, it is assumed cahngeable
	 */
	public Cell(int row, int col){
		changeable = true;
		this.row = row;
		this.col = col;
		num = 0;
	}
	
	public int getNum(){
		return num;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	public int[] getPencilMark(){
		return pencilMarks;
	}
	
	public void setPencilMarks(int index, int num){
		pencilMarks[index] = num;
	}
	
	public String toString(){
		if (num == 0){
			String marks = "";
			for (int x: pencilMarks){
				marks += x + " ";
			}
			marks = "pencil marks are:" + marks;
			return marks;
		}
		else
			return ("" + num);
	}
	
	public boolean isChangeable(){
		return changeable;
	}
}
