import java.util.ArrayList;
import java.util.Iterator;

public class Sum2Test{
    public static void main(String[] args) {
        ArrayList<Double> a = new ArrayList<Double>();
        a.add(1.0);
        a.add(2.0);
        a.add(3.0);
        a.add(4.0);
        a.add(5.0);
        System.out.println(sum2(a));
    }

    public static double sum2(ArrayList<Double> list){
        double sum = 0;
        ArrayList<Double> lis = new ArrayList<Double>(list);
        for(double num : list){
            lis.remove(0);
            for(double num2 : lis){
                System.out.println(num + " :: " + num2);
                sum += num * num2;
            }
        }
        return sum;
    } 
}