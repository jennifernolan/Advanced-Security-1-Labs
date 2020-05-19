/*
	Jennifer Nolan
	C16517636
	Program that will test if a given number is a prime number or composite. To achieve this implement Miller-Rabin Algorithm.
*/

import java.util.*;
import java.math.*;

public class Lab3PartA {
	
	//Constructor
	public Lab3PartA() {
		//Take in number from command line
		System.out.println("Please enter a number: ");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt(); //gather input and store in integer
		
		//go to function that will implement Miller-Rabin Algorithm
		boolean result = prime(number);
		
		//using result gathered from algorithm inform user if prime or not
		if(result)
		{
			System.out.println(number + " is prime");
		} else { 
			System.out.println(number + " is composite");
		}
	}
	
	public static void main(String[] args) {
		Lab3PartA lab = new Lab3PartA();
	}
	
	//function that will find if number is prime, if not will go to Miller Rabin function
	public boolean prime(int num) {
		
		if(num == 0 || num == 1) // if 0 or 1
		{
			return false;
		}
		else if(num == 2)  // if 2
		{
			return true;
		}
		else if(num % 2 == 0) // if number is divisible by 2 wih no remainder
		{
			return false;
		}
		else {
			int j = num - 1;
			
			while (j % 2 == 0) // get divisors of number - 1 with remainder 0 when divided by 2
			{
				j /= 2; 
			}
			
			//if the millerRabin algorithm comes back true then it is prime
			if(millerRabin(j, num)) 
			{
				return true;
			}
		}
		
		return false;
	}
	
	//miller rabin algorithm
	public boolean millerRabin(int k, int numb) {
		
		//select a random number
		int rand = 2 + (int)(Math.random() % (numb - 4));
		
		int pow = power(rand, k, numb); //go to power funcrion
		
		//if power returns 1 or number -1 then return prime
		if (pow == 1 || pow == numb - 1) {
			return true;
		}
		
		//while the number generated from the prime function doesn't equal number - 1
		while (k != numb - 1)
		{
			//get the modulus of power and numb
			pow = (pow * pow) % numb;
			k *= 2;
			
			//if power now equals following then return
			if (pow == 1) 
			{
				return false;
			}
			if (pow == numb - 1)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public int power(int ran, int x, int n) 
	{
		int result = 1;
		//get modulus of random number and number
		ran = ran % n;
		
		while(x > 0)
		{
			//if one
			if((x & 1) == 1)
			{
				//times the random number by one and get the modulus with number
				result = (result*ran) % n;
			}
			
			//if 0
			//shift x by one to the right
			x = x >> 1;
			//change the value of the random number
			ran = (ran*ran) % n;
		}
		
		//return the result to the miller rabin algorithm
		return result;
	}
}