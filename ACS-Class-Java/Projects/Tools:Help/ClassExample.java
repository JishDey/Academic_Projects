import java.util.ArrayList;

public class ClassExample
{
    private int randomNumber;
    private int serial;
    private static int counter = 1;

    public ClassExample()
    {
        randomNumber = (int)(Math.random()*10.0);
        serial = counter;
        counter++;
    }

    public ClassExample(int instancereal)
    {
        randomNumber = (int)(Math.random()*10.0);
        serial = instancereal;
    }
  
    public static void main(String[] args) {
        int n = 20;
        ArrayList<ClassExample> studentsArray = new ArrayList<ClassExample>();
        //ClassExample[] studentsArray = new ClassExample[20];

        for(int i = 0; i < n; i++)
        {
            //studentsArray[i] = new ClassExample();
            studentsArray.add(new ClassExample());
            System.out.format("%04d%n", studentsArray.get(i).serial);
        }
        {
            ClassExample student = new ClassExample(3872);
            System.out.format("%04d%n", student.serial);
            System.out.println(student.randomNumber);
        }
        
        for (ClassExample classExample : studentsArray) {
            System.out.println("Serial " + classExample.serial + " has random " + classExample.randomNumber);
        }

        
    }

}