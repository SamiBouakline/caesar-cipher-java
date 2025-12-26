/**
 * @author Sami Bouakline
 * @since 2025-11-17
 * @program Java
 * @description creating a brute-force attack to decrypt file data
*/

//importing necessary libraries
import java.util.Scanner;
import java.io.*;

public class BruteForce
{
    /**
     * Program to read ciphertext from file and store in var
     * @param nothing
     * @throws IOException if file cannot be located
     * @return cipherText
    */
    static String readCipher()
    {
        try
        {
            //reading from file and storing in var
            FileReader fr = new FileReader("data/cipherText.txt");
            Scanner input = new Scanner(fr);
            
            String cipherText = input.nextLine();
            
            //outputting ciphertext to screen
            System.out.println("Ciphertext: "+cipherText);
            
            fr.close();
            input.close();
            
            return cipherText;
        }
        catch(IOException e)//exception if file cannot be located
        {
            System.out.println("Unable to locate file");
            return "";
        }
        
    }
    
    /**
     * Program to perform bruteforce attack on ciphertext
     * @param ciphertext - encrypted code from file
     * @throws nothing
     * @return nothing
    */
    static void bruteForce(String cipherText)
    {
        if (cipherText.isEmpty())
        {
            System.out.println("No ciphertext to decrypt.");
            return;
        }
        
        //array to hold all possible results from ciphertext
        String products[] = new String[25];
        
        //brute force attack
        for (int i=1;i<=25;i++)
        {
            StringBuilder newMessage = new StringBuilder();
            int index = 0;
            
            while (index < cipherText.length())
            {
                char letter = cipherText.charAt(index);
                if ((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z'))
                {
                    char base;
                    if (letter >= 'A' && letter <= 'Z')
                    {
                        base = 'A';
                    }
                    else
                    {
                        base = 'a';
                    }
                    
                    int decryptKey = (letter - base - i + 26)%26;
                    newMessage.append((char)(decryptKey + base));
                }
                else
                {
                    newMessage.append(letter);
                }
                index++;
            }
            products[i-1] = newMessage.toString();
            
            
        }
        //outputting each result
        for (int i=0;i<products.length;i++)
        {
            System.out.println("Key: "+(i+1)+":"+products[i]);
        }
    }
    public static void main(String[] args)
    {
        //subroutine to get ciphertext
        String cipherText = readCipher();
        
        //subroutine to perform brute force attack
        bruteForce(cipherText);
    }
}