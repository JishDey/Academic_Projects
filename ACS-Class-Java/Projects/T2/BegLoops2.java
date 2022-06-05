import javafx.scene.layout.BorderStroke;

public class BegLoops2
 {
    public static void main(String[] args) 
     {

        boolean looper = true;
        for (int x = 1; looper; x++)
        {
            System.out.println(x);
            if (x >= 10)
                looper = false;
        }
     }
 }