import java.util.ArrayList;

public class primeNumbers{
    public static ArrayList<Integer> sieveOfEratosthenes(int n){
        ArrayList<Integer> finArr = new ArrayList<Integer>();
        for (int i = 0; i < n+1; i++) {
            finArr.add(i);
        }
        for (int i = 2; i < Math.sqrt(finArr.size()); i++) {
            
            for (int j = 2*i; j < finArr.size(); j+=i) {
                finArr.set(j, 0);
            }
        }
        for (int i = 0; i < finArr.size(); i++) {
            if(finArr.get(i) == 0){
                finArr.remove(i);
                i--;
            }
        }
        return finArr;
    }
    public static void main(String[] args) {
        System.out.println(sieveOfEratosthenes(100));

    }
}