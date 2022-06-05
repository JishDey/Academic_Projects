import java.util.ArrayList;

public class ArrayListExample
{
    public static void main(String[] args) {
        ArrayList<String> vehicles = new ArrayList<String>(); //ArrayList<String>(< Int.max);
        System.out.println(vehicles.size());
        vehicles.add("car");
        vehicles.add("plane");
        vehicles.add(1, "hovercraft");
        vehicles.add(3, "boat");
        vehicles.add("hoverplane");
        vehicles.add("helicopter");
        vehicles.add("truck");
        vehicles.add("tank");
        vehicles.add("motorcycle");
        vehicles.add("scooter");
        vehicles.add("skateboard");
        
        System.out.println(vehicles.size());
        for (String vehicle : vehicles) {
            System.out.println(vehicle);
        }

        
        char myChar = ' ';
        int myInt = myChar;
        System.out.println(myInt);

    }
}