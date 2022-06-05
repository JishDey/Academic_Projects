/** smaddock and friends (Jishnu, Noah, Oliver, Parker, Sophia )
* September 22, 2021
* class to represent 2D matrices
*/

public class MatPrep
{
  private double[][] mat; //the basic matrix
  
  //constructors
  //default is a 2 X 2 identity matrix
  //given with class
  public MatPrep()
  {
     mat = new double[2][2];
     mat[0][0] = 1;
     mat[0][1] = 0;
     mat[1][0] = 0;
     mat[1][1] = 1;
         
  }
  //constructor for an square matrix of size n filled with random numbers
  //from low - high
  //individual
  public MatPrep(int n, int low, int high)
  {
    mat = new double[n][n];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        mat[i][j] = (int)(Math.random() * (high - low + 1) + low);
      }
    }
  
  }
  

  //toString for display purposes
  //group
  public String toString()
  {
    String str = "";
    for (double[] row : mat){
      for(double num : row)
        str += num + "\t";
      str += "\n";
    }
    return str;
  }
}//end class