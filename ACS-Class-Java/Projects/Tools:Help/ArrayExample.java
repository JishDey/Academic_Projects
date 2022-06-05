//import java.util.ArrayList;

public class ArrayExample
{
    public static void main(String[] args) {

        /*
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
            myNumbers.add(6);
            myNumbers.add(7);
            myNumbers.add(8);
        ArrayList<Integer> myNumbers2 = new ArrayList<Integer>();
            myNumbers2.add(3);
            myNumbers2.add(9);
            myNumbers2.add(2);
        ArrayList<Integer> myNumbers3 = new ArrayList<Integer>();
            myNumbers3.add(0);
            myNumbers3.add(1);
            myNumbers3.add(3);
        
        ArrayList<ArrayList<Integer>> myNumbersSqrd = new ArrayList<ArrayList<Integer>>();
            myNumbersSqrd.add(myNumbers);
            myNumbersSqrd.add(myNumbers2);
            myNumbersSqrd.add(myNumbers3);

        for (int i = 0; i < myNumbersSqrd.size(); ++i) {
            System.out.println();
            for(int j = 0; j < myNumbersSqrd.size(); ++j) {
                System.out.print(myNumbersSqrd.get(i).get(j) + "  ");
            }
        }
        */

        
        int[][] myNumbers = {{7, 2, 1, 9, 4}, {7, 3, 7, 4, 0}, {2, 6, 5, 0, 4}};
        for (int i = 0; i < myNumbers.length; ++i) {
            System.out.println();
            for(int j = 0; j < myNumbers[i].length; j++) {
                System.out.print(myNumbers[i][j] + "  ");
            }
        }
        
        
        System.out.println();
    }
}
