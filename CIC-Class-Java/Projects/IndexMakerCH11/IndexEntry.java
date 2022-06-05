/**
Parker Douglas
Index Entry Class
10/21/2021
*/

import java.util.ArrayList;

public class IndexEntry
{
   private String word;
   private ArrayList<Integer> numsList;
   
   public IndexEntry(String str)
   {
      word = str.toUpperCase();
      numsList = new ArrayList<Integer>();
   }
   
   public void add(int num)
   {
      if (!numsList.contains(num))
         numsList.add(num);
   }
   
   public String getWord()
   {
      return word;
   }
   
   public String toString()
   {
      String str = word;
      
      for (int x = 0; x < numsList.size()-1; x++)
         str += " " + numsList.get(x) + ",";
      
      str += " " + numsList.get(numsList.size()-1);
      
      return str;
   }
}