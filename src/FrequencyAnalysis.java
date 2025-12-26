/**
 * @author Sami Bouakline
 * @since 2025-11-17
 * @program Java
 * @description creating a frequency analysis to decrypt file data
*/

//importing necessary libraries
import java.util.Scanner;
import java.io.*;

public class FrequencyAnalysis
{
    /**
     * Program to perform frequency analysis on ciphertext
     * @param ciphertext - encrypted code from file
     * @throws nothing
     * @return nothing
    */
    static void frequencyAnalysis(String cipherText)
    {
        //frequency analysis
        int counter[] = new int[26];//array holding count from A-Z

        //capitalizing letters of ciphertext
        for (int i=0;i<cipherText.length();i++)
        {
            char c = Character.toUpperCase(cipherText.charAt(i));
            if (c>= 'A' && c<= 'Z')
            {
                counter[c - 'A']++;
            }
        }
        
        //finding most common letter
        int maxNum = 0;
        for (int i=1;i<26;i++)
        {
            if (counter[i] > counter[maxNum])
            {
                maxNum = i;
            }
        }
        
        //outputting letter and # of occurences
        char commonLetter = (char)('A'+maxNum);
        System.out.println("Most common letter: "+commonLetter);
        System.out.println("# of occurences: "+counter[maxNum]);
        
        //assuming most common letter translates to 'E'
        System.out.println("Assuming most frequent letter represents 'E'");
        int analysisKey = (commonLetter - 'E' + 26)%26;
        System.out.println("Frequency analysis key: "+analysisKey);
        
        //decrypting text using frequency analysis key
        StringBuilder decrypted = new StringBuilder();
        
        for (int i=0;i<cipherText.length();i++)
        {
            char currentChar = cipherText.charAt(i);
            
            //decrypting uppercase letters
            if ((currentChar >= 'A' && currentChar <= 'Z'))
            {
                currentChar = (char)((currentChar - 'A' - analysisKey + 26)%26 + 'A');
            }
            //decrypting lowercase letters
            else if (currentChar >= 'a' && currentChar <= 'z')
            {
                currentChar = (char)((currentChar - 'a' - analysisKey + 26)%26 + 'a');
            }
            //keeping other chars untouched
            decrypted.append(currentChar);
        }
        //outputting decrypted text
        System.out.println("Decrypted: " + decrypted.toString());
    }
    
    /**
     * Program to get ciphertext from file
     * @param nothing
     * @throws IOException if file cannot be found
     * @return nothing
    */
    static String cipherFile()
        {
            try
            {
                //activating filereader
                FileReader fr = new FileReader("data/cipherText.txt");;
                Scanner input = new Scanner(fr);
                
                String cipherText = input.nextLine();
                
                fr.close();
                input.close();
                return cipherText;
            }
            catch(IOException e)
            {
                System.out.println("Unable to locate file");
                return "";
            }
            
        }
    public static void main(String[] args)
    {
        //subroutine to get ciphertext
        String cipherText = cipherFile();
        
        //subroutine to perform frequency analysis
        frequencyAnalysis(cipherText);
    }
}