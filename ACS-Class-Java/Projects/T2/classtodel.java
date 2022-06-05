public class classtodel {
    public static int[] toAscii(String from){
        int[] fin = new int[from.length()];
        for (int i = 0; i < from.length(); i++) {
            fin[i] = (int)(from.charAt(i));
        }
        return fin;
    }

    public static void main(String[] args) {
        String myString = "Hello world!";
        int[] myArray = toAscii(myString);

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(" " + myArray[i] + " ");
        }
    }
}