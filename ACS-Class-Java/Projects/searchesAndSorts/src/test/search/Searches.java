package test.search;
public class Searches {

    public int sequentialSearch(int[] array, int goal) {
        for (int i = 0; i < array.length; i ++) {
            if(array[i] == goal) {
                return i;
            }
        }
        return -1;
    }

    public int binary(int[] array, int goal) {
        int middleIndex = array.length/2;
        int endIndex = array.length - 1;
        int beginIndex = 0;
        int length = array.length;

        while(length > 0){
            if(array[middleIndex] == goal) {
                return middleIndex;
            }
            else if (goal > array[middleIndex]) {
                beginIndex = middleIndex + 1;
            }
            else {
                endIndex = middleIndex - 1;
            }
            length = endIndex - beginIndex + 1;
            middleIndex = beginIndex + length/2;
        }
        
        return -1;
    }

    public int binarySearchRecursive(int[] array, int goal) {

        return binarySearchRecursive(array, goal, 0, array.length - 1);
    }

    public int binarySearchRecursive(int[] array, int goal, int beginIndex, int endIndex) {
        int length = endIndex - beginIndex + 1;
        int middleIndex = beginIndex + length/2;

        if(length == 0) {
            return -1;
        }

        if(array[middleIndex] == goal) {
            return middleIndex;
        }

        if (goal > array[middleIndex]) {
            return binarySearchRecursive(array, goal, middleIndex + 1, endIndex);
        }
        else {
            return binarySearchRecursive(array, goal, beginIndex, middleIndex - 1);
        }
    }
}