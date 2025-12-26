/**
 * @author Sami Bouakline
 * @since 2025-11-17
 * @program Java
 * @description creating a Caesar cipher to encrypt file data
*/

//importing necessary libraries
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Encrypt
{
    /**
     * Program to read plaintext from file and store in var
     * @param nothing
     * @throws IOException if file cannot be located
     * @return plainText
    */
    static String plaintext()
    {
        try
        {
            //getting data from file and outputting
            FileReader fr = new FileReader("data/plainText.txt");
            Scanner input =new Scanner(fr);
            String plainText = input.nextLine();
            
            System.out.println("Plaintext: "+plainText);
            
            fr.close();
            input.close();
            
            return plainText;
        }
        catch(IOException e)
        {
            System.out.println("Unable to locate file");
            return "";
        }
        
    }
    
    /**
     * Program to create random key and encrypt plaintext using the key
     * @param plaintext - read from file
     * @throws nothing
     * @return cipherText
    */
    static String encryption(String plainText)
    {
        //activating random
        Random random = new Random();
        
        //creating a random key
        int key = random.nextInt(25) + 1;
        System.out.println("Key: "+key);
        
        //only encrypting uppercase and lowercase letters with key
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++)
        {
            char c = plainText.charAt(i);

            if (c >= 'A' && c <= 'Z')
                c = (char)((c - 'A' + key) % 26 + 'A');
            else if (c >= 'a' && c <= 'z')
                c = (char)((c - 'a' + key) % 26 + 'a');

            cipherText.append(c);
        }
        return cipherText.toString();

    }
    
    /**
     * Program to write ciphertext to file
     * @param ciphertext - var encrypted in prior subroutine
     * @throws IOException if file cannot be located
     * @return nothing
    */
    static void cipherFile(String cipherText)
    {
        try
        {
            //writing ciphertext to file
            PrintWriter pw = new PrintWriter("data/cipherText.txt");
            pw.print(cipherText);
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("Unable to locate file");
        }
    }
    public static void main(String[] args)
    {
        //subroutine to output plaintext
        String plainText = plaintext();
        
        //subroutine for encrypting plaintext
        String cipherText = encryption(plainText);
        
        //outputting ciphertext
        System.out.println("Ciphertext: "+cipherText);
        
        //writing ciphertext file
        cipherFile(cipherText);
        
    }
}