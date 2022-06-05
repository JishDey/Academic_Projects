import java.util.ArrayList;
public class jDeyfactMan{
    private ArrayList<Integer> numList = new ArrayList<Integer>();

    private void printnumList(){
        System.out.println(numList);
    }
    public jDeyfactMan(int gameSize){
            for (int i = 0; i < gameSize; i++) {
                numList.add(i+1);
            }
    }
    public void runGame(){
        /*
        
        */
        while(numList.size())
    }
    public static void main(String[] args) {
        jDeyfactMan a = new jDeyfactMan(10);
        a.printnumList();

    }
}