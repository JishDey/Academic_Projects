/**
Parker Douglas
Document Index Class
10/21/2021
*/

import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry>
{
   public DocumentIndex()
   {
      super();
   }
   
   public DocumentIndex(int size)
   {
      super(size);
   }
   
   public void addWord(String word, int num)
   {
      int i = foundOrInserted(word);
      this.get(i).add(num);
   }
   
   public void addAllWords(String str, int num)
   {
      String[] words = str.split("\\W+");
      for (String word : words)
         if (word.length() > 0)
            addWord(word, num);
   }
   
   private int foundOrInserted(String word)
   {
      word = word.toUpperCase();
      
      int i;
      
      for (i = 0; i < this.size(); i++)
         if(word.equals(this.get(i).getWord()))
            return i;
         else if(word.compareTo(this.get(i).getWord()) < 0)
            break;
      
      this.add(i, new IndexEntry(word));
      
      return i;
   }
   
}