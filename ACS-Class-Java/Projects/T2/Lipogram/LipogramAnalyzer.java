public class LipogramAnalyzer{
   String input;
   
   public LipogramAnalyzer(String text){
      input = text;
   }
   
   public String mark(char letter){
      int length = this.input.length();
      String returnString = "";
      for (int i = 0; i < length; i++) {
         if(this.input.charAt(i) == letter) {
            returnString += "#";
         }
         else{
            returnString += this.input.charAt(i);
         }
      }
      return returnString;
   }
  
   public String allWordsWith(char letter){
      int i = 0;
      String returnString = "";
      String currentWord = "";
      boolean hasLetter = false;
      while (i < this.input.length()){
         if(!hasLetter&&(this.input.charAt(i) == letter))
            hasLetter = true;
         if((this.input.charAt(i) == ' ')){
            if(hasLetter){
               if(!returnString.contains(currentWord)){
                  returnString += currentWord + "\n";
               }
               hasLetter = false;
            }
            currentWord = "";
         }
         else {
            currentWord += this.input.charAt(i);
         }
         i++;
      }
      if(currentWord.contains(Character.toString(letter))){
         returnString += currentWord + "\n";
      }
      return returnString;
   }

   public static void main(String[] args) {
      LipogramAnalyzer a = new LipogramAnalyzer("This is not a drill. I repeat this is not a drill. E e E ee");
      System.out.println(a.mark('t'));
      System.out.println(a.allWordsWith('t'));
   }
}
