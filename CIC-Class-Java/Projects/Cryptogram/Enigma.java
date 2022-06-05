import java.util.Arrays;

public class Enigma{
    private char[] lookupTable;
    public Enigma(){
        lookupTable = new char[26];
        Arrays.fill(lookupTable, '-');
    }
    
}