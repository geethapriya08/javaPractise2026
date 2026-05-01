package com.impJavaPractice.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class UpdatedJavaprograms {
	
	//Anagram Program
	
	void anagram() {
		String str1 = "Race";
		String str2 = "Care";

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		// check if length is same
		if (str1.length() == str2.length()) {   

			// convert strings to char array
			char[] charArray1 = str1.toCharArray(); 
			char[] charArray2 = str2.toCharArray();

			// sort the char array
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);

			// if sorted char arrays are same
			// then the string is anagram
			boolean result = Arrays.equals(charArray1, charArray2);

			if (result) {
				System.out.println(str1 + " and " + str2 + " are anagram.");
			} else {
				System.out.println(str1 + " and " + str2 + " are not anagram.");
			}
		} 

	}
	
	//DuplicateWords
	
	void printDuplicateWordsInSentence() { 
        String input = "Big black bug bit a big black dog on his big black nose";
	    input = input.toLowerCase();

	    String[] word = input.split(" ");
	    int count;

	    for (int i = 0; i < word.length; i++) {
	        count = 1;

	        for (int j = i + 1; j < word.length; j++) {
	            if (word[i].equals(word[j])) {
	                count++;
	                word[j] = "0";
	            }
	        }

	        if (count > 1 && !word[i].equals("0")) {
	            System.out.println(word[i]);
	        }
	    }
	}
	//even odd word swap
	void evenOddWordSwap() {
		String str = "CloudiKnow";
		String output = "";
		for (int i = 0; i < str.length(); i++) {
			// swap only if the next char is within the string
			if (i + 1 < str.length()) {
				output = output + str.charAt(i + 1);
				output = output + str.charAt(i);
			}
			i = i + 1;
		}
		System.out.println("Given   String: " + str);
		System.out.println("Swapped String: " + output);     
		}
	
	void fibonacciSeries() {
		int n1 = 0, n2 = 1, n3;
      // System.out.println(n1+ " "+n2); //printing 0 and 1
		for (int i = 2; i < 10 ; i++) { // loop starts from 2 because 0 and 1 are already printed
          n3 = n1 + n2;
        System.out.println(" " + n3);
            n1 = n2;
			n2 = n3;

		}
		
	}
	
	void largestArray() {
        int arr[] = { 10, 324, 45, 90, 9808 };
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > max)
				max = arr[i];
        System.out.println(max);

	}
	
	
	void occurenceofChar() { 
    String str = "Soooorrrrryyyyy";
    HashMap<Character, Integer> hMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (hMap.containsKey(ch)) {
            hMap.put(ch, hMap.get(ch) + 1);
        } else {
            hMap.put(ch, 1);
        }
    }
    System.out.println(hMap);
}
	


     void palindrome() {  
		int num = 3553, reversedNum = 0, remainder;

		// store the number to originalNum
		int originalNum = num;

		// get the reverse of originalNum
		// store it in variable
		while (num != 0) {
			remainder = num % 10;
			reversedNum = reversedNum * 10 + remainder;
			num /= 10;
		}

		// check if reversedNum and originalNum are equal
		if (originalNum == reversedNum) {
			System.out.println(originalNum + " is Palindrome.");
		} else {
			System.out.println(originalNum + " is not Palindrome.");
		}

	}
	
	void printListOfPrimeNumbers() {
    	
        int limit = 100;
        // System.out.println("Prime numbers between 1 and " + limit + " are:");

        for (int num = 2; num <= limit; num++) {
            boolean isPrime = true;
            // Check for divisibility from 2 up to the square root of the number for efficiency
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break; // Exit the inner loop as soon as a divisor is found
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }
    }
	
	void removeDuplicateWords() {

		String str = "The first second was alright but the second second was tough.";
		System.out.println("Original String : "+str);
        String[] strWords = str.split("\\s+");

		// convert String array to LinkedHashSet to remove duplicates
		LinkedHashSet<String> lhSetWords = new LinkedHashSet<String>(Arrays.asList(strWords));

		// join the words again by space
		StringBuilder sbTemp = new StringBuilder();
		int index = 0;

		for (String s : lhSetWords) {

			if (index > 0)
				sbTemp.append(" ");

			sbTemp.append(s);
			index++;
		}

		str = sbTemp.toString();

		System.out.println("String after removing duplicate words: "+str);

	}

	void reverseString()
	{
		String original = "Hello World";
	    String reversed = "";
      for (int i = original.length() - 1; i >= 0; i--) {
          reversed = reversed + original.charAt(i);
      }
      System.out.println("Reversed: " + reversed);
	}
	
	
	void secondHighestArray() {   

		int a[] = { 90, 19, 67, 89, 28 };  
		Arrays.sort(a);

		System.out.println("Second highest "+a[a.length - 2]);
	}
	void secondHighestArray1() {

	    int[] a = { 90, 19, 67, 89, 28 };
        int highest = a[0];
	    int secondHighest = a[1];

	    for (int i = 1; i < a.length; i++) {
	        if (a[i] > highest) {
	            secondHighest = highest;
	            highest = a[i];
	        } else if (a[i] > secondHighest) {
	            secondHighest = a[i];
	        }
	    }

	    System.out.println("Second highest: " + secondHighest);
	}

	
	void stringnumberseparatorandAddtwonumbers()
	{

        String input = "ab12@3c45#6";
        StringBuilder letters = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();

        int sumOfDigits = 0;
        List<Integer> pairSums = new ArrayList<>();

        // Separate characters
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.append(ch);
            } 
            else if (Character.isDigit(ch)) {
                numbers.append(ch);
                sumOfDigits += Character.getNumericValue(ch);
            } 
            else {
                specialChars.append(ch);
            }
        }

        // Sum of every two digits
        for (int i = 0; i < numbers.length(); i += 2) {
            int first = Character.getNumericValue(numbers.charAt(i));
            int second = (i + 1 < numbers.length())
                    ? Character.getNumericValue(numbers.charAt(i + 1))
                    : 0;
            pairSums.add(first + second);
        }

        // Output
        System.out.println("Alphabets       : " + letters);
        System.out.println("Numbers         : " + numbers);
        System.out.println("Special chars   : " + specialChars);
        System.out.println("Sum of digits   : " + sumOfDigits);
        System.out.println("Sum of pairs    : " + pairSums);
    }

	
	
	void systemTime(){
	       // Get the current date and time
		    LocalDateTime currentDateTime = LocalDateTime.now();		    
			    // Define a format pattern
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    
			    // Format the current date and time into a readable string
		    String formattedDateTime = currentDateTime.format(formatter);
		    
			    // Print the result
			System.out.println("Current system date and time: " + formattedDateTime);
			  }
		void time() {
			// Get the current system time
	        LocalTime currentTime = LocalTime.now();

	        // Display the current time
	        System.out.println("Current Time: " + currentTime);
		}
		
		void date() {
			LocalDate currentDate = LocalDate.now();
			System.out.println(currentDate);
		}
	
	
   void stringnumberseparator() 
		{
		   String inputString = "He110, w0rld! 2024";
		    StringBuilder letters = new StringBuilder();
		    StringBuilder numbers = new StringBuilder();
		    StringBuilder specialChars = new StringBuilder();
		
		    for (int i = 0; i < inputString.length(); i++) {
		        char ch = inputString.charAt(i);
		
		        if (Character.isLetter(ch)) {
		            letters.append(ch);
		        } else if (Character.isDigit(ch)) {
		            numbers.append(ch);
		        } else {
		            // This will catch all non-letter and non-digit characters, 
		            // including spaces and punctuation.
		            specialChars.append(ch);
		        }
		    }
		
		    System.out.println("Original String: " + inputString);
		    System.out.println("Letters: " + letters);
		    System.out.println("Numbers: " + numbers);
		    System.out.println("Special Characters (including spaces): " + specialChars);
		}
   
   void reverseStringwithoutchangingplace1() { //olleH dlrow
	        String input = "Hello world";
	        String[] words = input.split(" ");

	        for (String word : words) {
	            for (int i = word.length() - 1; i >= 0; i--) {
	                System.out.print(word.charAt(i));
	            }
	            System.out.print(" ");
	        }
	    }
   //✅ Reverse string, Add numbers ,Separate numbers special characters alphabets Find occurrences of characters
	
   void allConditions() {

       String input = "Heelloo1234World@#$";

       StringBuilder reversed = new StringBuilder();
       StringBuilder characters = new StringBuilder();
       StringBuilder numbers = new StringBuilder();
       StringBuilder specialChars = new StringBuilder();

       int sumOfNumbers = 0;

       // Map for character occurrences
      // Map<Character, Integer> charCount = new HashMap<>();

       // ✅ Reverse String
       for (int i = input.length() - 1; i >= 0; i--) {
           reversed.append(input.charAt(i));
       }

       // ✅ Traverse string
       for (char ch : input.toCharArray()) {

           // ✅ Separate characters (alphabets)
           if (Character.isLetter(ch)) {
               characters.append(ch);

               // Count occurrences
            //   charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
           }

           // ✅ Separate numbers & add numbers
           else if (Character.isDigit(ch)) {
               numbers.append(ch);
               sumOfNumbers += Character.getNumericValue(ch);
           }

           // ✅ Separate special characters
           else {
               specialChars.append(ch);
           }
       }

       // ✅ Output
       System.out.println("Original String      : " + input);
       System.out.println("Reversed String      : " + reversed);
       System.out.println("Characters Only      : " + characters);
       System.out.println("Numbers Only         : " + numbers);
       System.out.println("Sum of Numbers       : " + sumOfNumbers);
       System.out.println("Special Characters   : " + specialChars);

       System.out.println("Character Occurrences:");
//       for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
//           System.out.println(entry.getKey() + " = " + entry.getValue());
//       }
   }


	  public static void main(String[] args) {
	   UpdatedJavaprograms updatedJavaProgram = new UpdatedJavaprograms();
	//   updatedJavaProgram.anagram();
//	   updatedJavaProgram.date();
//	   updatedJavaProgram.duplicateWords();
//	   updatedJavaProgram.evenOddWordSwap();
//	   updatedJavaProgram.fibonacciSeries();
//	   updatedJavaProgram.largestArray();
	  // updatedJavaProgram.occurenceofChar();
//	   updatedJavaProgram.palindrome();
	//   updatedJavaProgram.printListOfPrimeNumbers();
	   updatedJavaProgram.removeDuplicateWords();
//	   updatedJavaProgram.reverseString();
	  // updatedJavaProgram.secondHighestArray();
//	   updatedJavaProgram.stringnumberseparator();
//	   updatedJavaProgram.systemTime();
//	   updatedJavaProgram.time();
//	   updatedJavaProgram.reverseStringwithoutchangingplace();
	//   updatedJavaProgram.reverseStringwithoutchangingplace2();
	   //updatedJavaProgram.stringnumberseparatorandAddtwonumbers();
	   //updatedJavaProgram.occurenceofChar();
	   
	   
		

	}

}
