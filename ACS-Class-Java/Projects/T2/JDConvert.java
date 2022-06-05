/**
 * Jishnu Dey
 * 1/9/21
 */
public class JDConvert {
    static final char[] CHARARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'};
    // This is my own work from studying over break.
    public static int sequentialSearch(char[] array, int goal) {
        for (int i = 0; i < array.length; i ++) {
            if(array[i] == goal) {
                return i;
            }
        }
        return -1;
    }

    public static String jdfromDecimal(int num, int newBase) {
        if(newBase > 23) {
            System.out.println("Base is too big");
            return "-1";
        }
        else if (newBase < 1) {
            System.out.println("Base is too small");
            return "-1";
        }

        String output = "";
        int currentdigit;
        while (num > 0) {
            currentdigit = num%newBase;
            num /= newBase;
            output = "" + CHARARRAY[currentdigit] + output;
        }
        return output;
    }

    public static int jdtoDecimal (String num, int oldBase) {
        int fin = 0;
        int numLength = num.length();
        for (int i = 0; i < num.length(); i++) {
            fin += Math.pow(oldBase, numLength - (i + 1)) * sequentialSearch(CHARARRAY, num.charAt(i));
            if((sequentialSearch(CHARARRAY, num.charAt(i))) > oldBase || (sequentialSearch(CHARARRAY, num.charAt(i))) < 0) {
                System.out.println("Not in base " + oldBase);
                return -1;
            }

            
        }
        return fin;
    }

    public static int jdtoDecimal (int num, int oldBase) {
        int fin = 0;
        if (oldBase >= 10){
            System.out.println("Base is too big");
            return -1;
        }
        else if (oldBase < 1) {
            System.out.println("Base is too small");
            return -1;
        }

        for (int i = 0; num > 0; i++) {
            fin += num%10 * Math.pow(oldBase, i);
            if (oldBase < num%10) {
                System.out.println("Not in base " + oldBase + ".");
                return -1;
            }
            num/=10;
        }
        return fin;
    }
    public static void main(String[] args) {
        System.out.println(jdtoDecimal(1412, 7));
        System.out.println(jdtoDecimal("fd1140c", 12));
        System.out.println(jdfromDecimal(2384, 22)); 
    }
    
}

