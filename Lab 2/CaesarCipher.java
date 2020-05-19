//Jennifer Nolan C16517636 Lab 2
//Program to decrypt Ceasar cipher (part one) and find the key that was used to encrypt the message (part two)

import java.util.*;

public class CaesarCipher {
	
	public static void main(String[] args) {
		
		//string that the decrypted message will be stored in
		String decryptedMessage = "";
		
		//mechanism that gets the input from the user from the command line
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the encrypted text:");
		String encryptedText = input.nextLine(); //gather input
			
		System.out.println("\nEnter the shift value:");
		int shift = input.nextInt(); //gather input
		
		//for loop to decrypt message
		for(int i = 0; i < encryptedText.length(); i++) 
		{
			//move one character along at a time
			char letter = encryptedText.charAt(i);
			
			//if the letter is between a and z (lowercase only)
			if(letter >= 'a' && letter <= 'z')
			{
				//shift the letter to decrypt
				letter = (char)(letter - shift);
				
				//if after shift the letter is less than a then reshift to other end of alphabet
				if(letter < 'a') 
				{
					//reshift to other end of alphabet
					letter = (char)(letter - 'a'+'z'+1);
				} else if(letter > 'z')
				{
					//if letter ends up greater then z after shift then reshift
					letter = (char)(letter + 'z'-'a'-1);
				}
				decryptedMessage = decryptedMessage + letter;
			}
			//for letters in uppercase
			//if the letter is between A and Z (uppercase only)
			else if(letter >= 'A' && letter <= 'Z')
			{
				//shift the letter to decrypt
				letter = (char)(letter - shift);
					
				//if after shift the letter is less than A then reshift to other end of alphabet
				if(letter < 'A') 
				{
					//reshift to other end of alphabet
					letter = (char)(letter - 'A'+'Z'+1);
				}
				else if(letter > 'Z')
				{
					//if letter ends up greater then Z after shift then reshift
					letter = (char)(letter - 'Z'+'A'-1);
				}
				
				//add the decrypted letter to the decrypted message
				decryptedMessage = decryptedMessage + letter;
				
			} 
			//if any punctuation is used just add it to the decrypted message without being altered
			else {
				decryptedMessage = decryptedMessage + letter;
			}
		}
		
		//display the decrypted message
		System.out.println("\nDecrypted message:");
		System.out.println(decryptedMessage);
	}
}