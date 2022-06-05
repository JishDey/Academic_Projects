public class DeyCaesarCypher{
    public static char charShift(int shiftBy, char x) {
        int xint = (int)x;
        int a;
        if(xint > 65 && xint < 90) {
            a = (xint + shiftBy - 65)%25 + 65;
        }
        return a;
    }

    public static String stringShift(String in){
        String fin;
        for (int i = 0; i < in.length(); i++) {
            fin += in.charAt(i);
        }
        return fin;
    }

    public static void main(String[] args) {
        System.out.println(charShift(0, 'a'));
    }
}