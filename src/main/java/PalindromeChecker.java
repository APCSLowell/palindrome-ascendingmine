import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word) {
  if (lowerNoSpaceLetter(word).equals(reverse(word)))
    return true;
  else
    return false;
}
public String reverse(String word) {
  String sNew = new String();
  for(int i = word.length()-1; i>=0; i--)
    if(Character.isLetter(word.charAt(i)))
      for(int j = i; j < i+1; j ++)
        if(!word.substring(j,j+1).equals(" "))
        sNew = sNew+word.charAt(j);
  return sNew.toLowerCase();
}
public String lowerNoSpaceLetter(String word){
  String lower = new String();
  for(int i = 0; i<word.length()-1; i++)
   if(Character.isLetter(word.charAt(i)))
      for(int j = i; j < i+1; j ++)
        if(!word.substring(j,j+1).equals(" "))
        lower = lower+word.charAt(j);
        return lower.toLowerCase();
}
