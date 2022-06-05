package test.search;


public class Main {
    public static void main(String[] args) {
        final int numOfElements = 10;
        Sorts b = new Sorts();
        int[] myArray = new int[numOfElements];

        for (int i = 0; i != myArray.length -2; i++) {
            myArray[i] = (int)(numOfElements * 2 * Math.random());
            System.out.println(myArray[i]);
        }
        
        b.selectionSort(myArray);
        b.verifySorted(myArray);

        //for (int i = 0; i < myArray.length; i++) {
        //    System.out.println(myArray[i]);
        //}

        

    }
    
}