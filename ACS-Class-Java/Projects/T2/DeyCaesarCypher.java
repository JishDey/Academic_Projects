public class DeyCaesarCypher{    
    private static char charShift(int shiftBy, char x) {    //shifts characters by shiftchar
        int xint = (int)x;
        int a;
        if(xint >= 65 && xint <= 90) {              //capital letters
            a = (xint + shiftBy - 39)%26 + 65;
        }
        else if (xint >= 97 && xint <= 122) {     //lowercase letters
            a = (xint + shiftBy - 71)%26 + 97;
        }
        else{
            return x;
        }

        return (char)a;
    }

    private static String stringShift(int shiftBy, String in){    //loops charshift through a string
        String fin = "";
        for (int i = 0; i < in.length(); i++) {
            fin += charShift(shiftBy, in.charAt(i));
        }
        return fin;
    }

    public static String cypherString(int shiftBy, String in){   // accounts for errors that occur in stringShift when shiftby < -26
        if(shiftBy >= -26 && shiftBy <= 26){
            return stringShift(shiftBy, in);
        }
        else{
            System.out.println("Please shift string between 26 and -26");
            return "";
        }
    }

    public static String deCypherString(int shiftBy, String in){  // accounts for errors that occur in stringShift when shiftby < -26
        if(shiftBy >= -26 && shiftBy <= 26){
            return stringShift(-shiftBy, in);
        }
        else{
            System.out.println("Please decypher a phrase shifted between -26 and 26 characters");
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(deCypherString(15, CypherString(15, "test")));
    }
}