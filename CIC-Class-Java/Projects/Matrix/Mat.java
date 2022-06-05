
/**
 * smaddock and friends (Jishnu, Noah, Oliver, Parker, Sophia ) September 22,
 * 2021 class to represent 2D matrices
 */

public class Mat {
  private double[][] mat; // the basic matrix

  // constructors
  // default is a 2 X 2 identity matrix
  // given with class
  public Mat() {
    mat = new double[2][2];
    mat[0][0] = 1;
    mat[0][1] = 0;
    mat[1][0] = 0;
    mat[1][1] = 1;

  }

  // constructor for an square identity matrix of size n
  // individual
  public Mat(int n) {
    mat = new double[n][n];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) { // i = j if on diagonal - fill with 1, otherwise fill with 0
        if (i == j)
          mat[i][j] = 1;
        else
          mat[i][j] = 0;
      }
    }

  }

  // constructor for an square matrix of size n filled with n random numbers
  // from low - high
  // group
  public Mat(int n, int low, int high) {
    mat = new double[n][n];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        mat[i][j] = (int) (Math.random() * (high - low + 1) + low); //random from low - high
      }
    }

  }

  // copy constructor
  // individual
  public Mat(Mat other) {
    mat = new double[other.mat.length][other.mat[0].length]; //matrix of other.mat length and width
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        mat[i][j] = other.mat[i][j];                         //other.mat -> this.mat
      }
    }

  }

  // constructor from an existing 2D array
  // individual
  public Mat(double[][] other) {
    mat = new double[other.length][other[0].length];        //matrix of other length and width
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        mat[i][j] = other[i][j];                            //other -> this.mat
      }
    }
  }

  // toString for display purposes
  // group
  public String toString() {
    String str = "";
    for (double[] row : mat) {
      for (double num : row)
        str += num + "\t"; //tab - spaces out numbers
      str += "\n \n";      //two new lines every row
    }
    return str;
  }

  // accessor and mutator methods (getters and setters)
  // returns the entire Mat as a 2D array
  // individual
  public double[][] getMat() {
    return mat;
  }

  // returns the nth row in the Mat
  // individual
  public double[] getRow(int n) {
    return mat[n];

  }

  // returns the nth column in the Mat
  // individual
  public double[] getCol(int n) {
    double[] rn = new double[mat.length];
    for (int i = 0; i < mat.length; i++) {
      rn[i] = mat[i][n];
    }
    return rn;
  }

  // returns the element at row, col of the matrix
  // individual
  public double getElement(int row, int col) {
    return mat[row][col];
  }

  // sets all the values of mat to those of from
  // individual
  public void setMatrix(double[][] from) {
    mat = new double[from.length][from[0].length];        //matrix of 'from' length and width
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        mat[i][j] = from[i][j];                           //from -> this.mat
      }
    }
  }

  // sets the element at row, col to n
  // individual
  public void setElement(int row, int col, double n) {
    mat[row][col] = n;
  }

  // fills the matrix with n
  // individual
  public void fill(double n) {
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        mat[i][j] = n;
      }
    }

  }

  // fills with random numbers in the range of low to high
  // individual
  public void fillRandom(double low, double high) {
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        mat[i][j] = (int) (Math.random() * (high - low + 1) + low); //fills with low - high
      }
    }
  }

  // adds and returns the result of this + other
  // individual
  public Mat add(Mat other) {
    double[][] fin = new double[mat.length][mat[1].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        fin[i][j] = mat[i][j] + other.getElement(i, j);  //fils with this + other (where other mat is private)
      }
    }
    return new Mat(fin);
  }

  // finds and returns the difference of this and other
  // individual
  public Mat subtract(Mat other) {
    double[][] fin = new double[mat.length][mat[1].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        fin[i][j] = mat[i][j] - other.getElement(i, j);  //fils with this - other (where other mat is private)
      }
    }
    return new Mat(fin);
  }

  // multiplies each element by scalar; returns the result
  // individual
  public Mat multiply(double scalar) {
    double[][] fin = new double[mat.length][mat[1].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        fin[i][j] = mat[i][j] * scalar;                  //fils with this + scalar
      }
    }
    return new Mat(fin);
  }

  // multiplies one matrix with another, assuming the two matrices can be multiplied
  // individual
  public Mat multiply(Mat other) {
    double[][] fin = new double[mat.length][mat.length];
    double fi;                                              //variable for collecting this row * other column sum
    for (int i = 0; i < mat.length; i++) {
      double[] row = getRow(i);
      for (int j = 0; j < mat.length; j++) {
        fi = 0;                                             //clear
        double[] col = other.getCol(j);                     //get other column
        for (int k = 0; k < col.length; k++) {              //k = 1->length
          fi += row[k] * col[k];                            //this row[k] + other column[k]
        }
        fin[i][j] = fi;
      }

    }
    return new Mat(fin);
  }

  // individual
  private double det2() {
    return (mat[0][0] * mat[1][1]) - (mat[1][0] * mat[0][1]);   //det 2x2 formula: ad - bc

  }

  // finds and returns the determinant of a 3X3 matrix
  // individual
  private double det3() { // The 3x3 determinant formula is the three [i+n][i] diagonals subtracted from three [i + n][-i] reverse diagonals of the matrix,
                          // where i+n 'wraps around' when it reaches n.
    int a = 0, tempA;
    int b = 0, tempB;
    for (int i = 0; i < 3; i++) {              //i = 1 -> 3 : 'n' in description
      tempA = 1;
      tempB = 1;
      for (int j = 0; j < 3; j++) {            //j = 0 -> 2 : 'i' in description
        tempA *= mat[(j + i) % 3][j];
        tempB *= mat[(3 - (j - i)) % 3][j];

      }
      a += tempA;                              //collects sum of diagonals
      b += tempB;                              //collects sum of reverse diagonals
    }
    return a - b;
  }

  // transposes mat and returns it as a Mat
  public Mat transpose() {
    double[][] fin = new double[mat[1].length][mat.length];
    for (int i = 0; i < fin.length; i++) {
      for (int j = 0; j < fin[i].length; j++) {
        fin[i][j] = mat[j][i];
      }
    }
    return new Mat(fin);

  }

  // finds the inverse through an augmented matrix
  // group
  public Mat inverse() {
    double[][] newMat = new double[mat.length][mat.length * 2]; //empty augmented matrix of length, length * 2

    for (int row = 0; row < mat.length; row++)                  //fills first half of augmented matrix with original
      for (int col = 0; col < mat.length; col++)
        newMat[row][col] = mat[row][col];

    for (int row = 0; row < mat.length; row++)                  //fills second half of augmented matrix with identity matrix
      for (int col = mat.length; col < mat.length * 2; col++)
        if (row != col - mat.length)
          newMat[row][col] = 0;
        else
          newMat[row][col] = 1;

    // actually doing it

    for (int col = 0; col < mat.length; col++) {
      // get 1 in correct place
      double temp = newMat[col][col];
      for (int i = 0; i < newMat[0].length; i++)  //row division to get [i][i] = 1
        newMat[col][i] = newMat[col][i] / temp;

      for (int i = 1; i < mat.length; i++) {
        int row = (col + i) % mat.length;   //row goes back from past end to start
        double temp2 = newMat[row][col];
        for (int j = 0; j < newMat[0].length; j++)
          newMat[row][j] = newMat[row][j] - newMat[col][j] * temp2; //other rows have zero in that column - row subtraction
      }
    }
    Mat a = new Mat(newMat);

    return new Mat(a.subMatrix(0, mat.length, mat.length - 1, newMat[0].length - 1));
  }

  public Mat divide(Mat other) {
    return multiply(other.inverse());
  }

  public double[][] subMatrix(int startRow, int startColumn, int endRow, int endColumn) {
    double[][] fin = new double[endRow - startRow + 1][endColumn - startColumn + 1];
    for (int i = startRow; i <= endRow; i++) {
      for (int j = startColumn; j <= endColumn; j++) {
        fin[i - startRow][j - startColumn] = mat[i][j];
      }
    }
    return fin;
  }

  public double[][] subMatrix(int removeRow, int removeCol) {
    double[][] fin = new double[mat.length - 1][mat[0].length - 1];
    int k = 0, l = 0;
    for (int i = 0; i < mat.length; i++) {
      l = 0;
      if (i != removeRow) {            //copies when row not removeRow
        for (int j = 0; j < mat[0].length; j++) {
          if (j != removeCol) {        //copies when col not removeCol
            fin[k][l] = mat[i][j];
            l++;
          }
        }
        k++;
      }
    }
    return fin;
  }
  public double det()
   {
      if (mat.length == 2) //base case 1
         return det2();
      else if (mat.length == 3) //base case 2
         return det3();
      //else (recursive)
      int sum = 0;
     
      for (int col = 1; col < mat.length+1; col++) //element [0][col-1]
      {
         int sign;
         if (col % 2 != 0)//if col is odd
            sign = 1;
         else//if col is even
            sign = -1;
         
         Mat subMat = new Mat(subMatrix(0, col-1)); //the determinant of the submatrix excluding the element
         
         sum += mat[0][col-1] * sign * subMat.det(); //the determinant is the sum of the element times the even/odd grid times the determinant of the submatrix excluding the element
      }
     
      return sum;
   }
}