//Jennifer Nolan C16517636 Lab2
//Program to decrypt Vigenere cipher (part three) with keyword KISWAHILI

import java.util.*;

public class VigenereCipher {
	
	public static void main(String[] args) {
		
		//string that the decrypted message will be stored in
		String decryptedMessage = "";
		//string that will contain the new generated key
		String newKey = "";
		int j = 0;
		
		//mechanism that gets the input from the user from the command line
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the encrypted text:");
		String encryptedText = input.nextLine(); //gather input
		
		System.out.println("\nEnter the key:");
		String key = input.nextLine(); //gather input
		
		//generate new key using provided key and making it repeat
		for(int i = 0; i < encryptedText.length(); i++)
		{
			//when the end of the key is reached reset j to start from the beginning of the key again
			if(j == key.length())
			{
				j = 0;
			}
			//add character to new key
			newKey = newKey + key.charAt(j);
			
			j++;
		}
		
		j = 0;
		
		for(int i = 0; i < encryptedText.length(); i++)
		{
			//move one character along at a time
			char encryptedLetter = encryptedText.charAt(i);
			
			//if the character is a letter
			if(encryptedLetter >= 'A' && encryptedLetter <= 'Z' || encryptedLetter >= 'a' && encryptedLetter <= 'z')
			{
				char keyLetter = newKey.charAt(j);
				//convert encrypted letter to decrypted letter value
				int letter = (encryptedLetter - keyLetter + 26) % 26 + 'A';
				
				j++;
			
				//convert letter value to an ASCII value and add it to the decrypted message
				decryptedMessage = decryptedMessage + (char)(letter);
			} 
			//if the character is a punctuation symbol just add it to the decrypted message without altering
			else {
				decryptedMessage = decryptedMessage + encryptedLetter;
			}
		}
		
		//display the decrypted message
		System.out.println("\nDecrypted message:");
		System.out.println(decryptedMessage);
	}
}