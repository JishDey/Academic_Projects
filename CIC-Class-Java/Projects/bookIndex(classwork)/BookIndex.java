// Chapter 20 Question 11

import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks whether a text file that represents
 * an index for a book with entries and indented subentries
 * has no errors: that all the entries and subentries are in
 * the alphabetical order.
 */
public class BookIndex
{
  public static void main(String[] args)
  {
    String fileName;

    if (args.length >= 1)
    {
      fileName = args[0];
    }
    else
    {
      Scanner kboard = new Scanner(System.in);
      System.out.print("Enter the index file name: ");
      fileName = kboard.nextLine();
      kboard.close();
    }

    File file = new File(fileName);
    Scanner input = null;
    try
    {
      input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("Cannot open " + fileName);
      System.exit(1);
    }

    Stack<String> stack = new Stack<String>();
    int errors = 0;
    int pIndent = -1;//-1 or zero... neccecary?
    String pLine = "";
    String line = input.nextLine();
    while (input.hasNextLine())
    {
      int indent = getIndent(line);
      if(indent > pIndent){ //if there is a new sublist
         stack.push(pLine);
         pLine = "";
         //System.out.println(1);
      }
      else if(indent < pIndent){ //if the last sublist ends
         pLine = stack.pop();
         //System.out.println(2);
      }
      if(line.compareTo(pLine) < 0){
        errors ++;
        System.out.println(line.trim() + " should be before " + pLine.trim() + ".");
        //System.out.println(3);
      }
      
      pIndent = indent;
      pLine = line;
      line = input.nextLine();
    }
      
    input.close();
    System.out.println(errors + " errors.\n");
  }
  // Returns the number of spaces at the beginning of the line.
  private static int getIndent(String line)
  {
    int index = 0;
    while(index < line.length() && line.charAt(index) == ' '){
      index++;
    }
    return index;
  }
}
