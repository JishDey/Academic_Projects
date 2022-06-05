/*smaddock
* 1/4/2021
* first work with Strings
*/
public class FirstStrings
{
    public static int countChar(String target, String find) 
    {
        int counter = 0;
        for (int i = 0; i < target.length() - 1; i++) {
          if(find.equals(target.substring(i, i + 1)))
          {
              counter++;
          }
        }
        return counter;
    }

    public static void alternateChars(String input)
    {
        for (int i = 0; i < input.length(); i+=2) {
          System.out.print(input.charAt(i) + " ");
        }
    }

    public static void wordSplit(String input)
    {
      int index1 = -1;
        while(index1 + 1 < input.length()) 
        {
          int index2 = input.indexOf(" ", index1 + 1);
          if(index2 < 0) {
            break;
          }
          System.out.println(input.substring(index1 + 1, index2));
          index1 = index2;
        }
        System.out.println(input.substring(index1 + 1));
    }

  public static void main(String[] args)
  {
     //notice the capital for String.  It is an object
     String phrase = "how now brown cow";
     //the method length() returns an int of how many characters are in the String
     int len = phrase.length();
     System.out.println(len);
     wordSplit(phrase);
     //Strings are numbered by the use of index values (indices) which start at 0
     //So "frog" has a length of 4, with index values 0 ("f"), 1 ("r"), 2 ("o"), and 3 ("g")
     
     //substring() is a method that parses - takes apart - Strings
     //There are two variations.  The first - and most common - takes two
     //arguments substring(int startIndex, int upToIndex)
     // in math interval notation it would look like this [startIndex, upToIndex)
     
     //System.out.println(phrase.substring(2,5));
     
     //prints each letter by itself on a line
     //for (int index=0; index < len; index++)
     //   System.out.println(phrase.substring(index, index+1));
     
     //prints pairs of letters on separate lines starting at the end
     // for (int pos = len-3; pos > 0; pos--)
       //System.out.println(phrase.substring(pos, pos+2));
     
     //prints an inverted triangle starting with the whole phrase
     //and slowly taking a letter off from the beginning
    
    /*for (int x = 0; x<len;x++)
       System.out.println(phrase.substring(x)); */

    System.out.println(countChar(phrase, "w"));

    /*for (int i = 32; i < 256; i++) {
      char ch = (char)i;
      System.out.println(ch);
    } */
  
  }

}