/*
All the problems on this page ahve been taken from the codecademy website for Java beginners
https://www.codecademy.com/resources/blog/java-code-challenges-for-beginners/

First 6 handle String inputs
Second 6 handle numeric inputs
*/
import java.util.*;

public class problems{

  public static void main(String args[]){
    //First 6 Questions
    /*
    problem_One("Codecademy is the best!");
    problem_Two("I can program in Java",3);
    problem_Three("I’m the new newt,","new");
    problem_Four("listen","silent");
    String[] fourChallInput = {"tar", "rat", "art", "meats", "steam"};
    problem_Four_Challenge(fourChallInput);
    problem_Five("The quick brown fox jumps over the lazy dog.");
    problem_Six("I love Codecademy");
    */
    //Second 6 Questions
    //problem_Seven(3956);
    //problem_Eight(8208);
    //int[] nineInput = { 2, -1, 3, 4 };
    //problem_Nine(nineInput);
    //problem_Ten(25);
    //problem_Eleven(12);
    problem_Twelve(Math.sqrt(3),Math.sqrt(26));
  }


  /*
  Problem 1 - Word Reversal
  For this challenge, the input is a string of words, and the output should be the words in reverse but with the letters in the original order. For example, the string “Dog bites man” should output as “man bites Dog.”
  After you’ve solved this challenge, try adding sentence capitalization and punctuation to your code. So, the string “Codecademy is the best!” should output as “Best the is Codecademy!”
  */
  public static void problem_One(String sentence){
    //Splits the input into an Array of individual Words
    String [] words = sentence.split(" ");
    String result = "";
    String punc = "";
    int arrayLength = words.length; //Length of the inputted Array
    int count = 1;
    System.out.println("String Before: "+ sentence);

    String [] newOrder = new String[arrayLength];
    int loopLength = arrayLength-1;

    for (int j = 0; j<arrayLength;j++){
      if (j ==  0){
        String x = words[(loopLength-j)];
        punc = x.substring(x.length()-1);
        newOrder[j] = (x.substring(0,1).toUpperCase()) + x.substring(1,x.length()-1);
      } else {
        newOrder[j] = words[(loopLength-j)];
      }
      count++;

      if (j==arrayLength-1){
        result += newOrder[j]+"";
      }else{
        result += newOrder[j]+" ";
      }
    }
    result += punc;
    System.out.println("String After: "+ result);
  }

  /*
  Problem 2 - Find the Word
  Starting with an input string of words, find the second-to-last word of the string. For example, an input of “I love Codecademy” should return “love.”
  To make your program more challenging, allow for a second numerical input, n, that results in returning the nth word of a string. So, for the string “I can program in Java” and n = 3, the output should be the third word, “program.”
  */
  public static void problem_Two(String sentence, int loc){
    String [] words = sentence.split(" ");
    System.out.println(words[loc-1]);
  }

  /*
  Problem 3 - Word Search
  For a given input string, return a Boolean TRUE if the string starts with a given input word. So, for an input string of “hello world” and input word “hello,” the program should return TRUE.
  For a more advanced word searcher, create a program that returns the number of times a word appears in an input string. For example, given an input word “new” and an input string “I’m the new newt,” the program should return a value of 2.
  */
  public static void problem_Three(String sentence, String word){
    boolean contains = sentence.contains(word);
    String [] words = sentence.split(" ");

    int occ = 0;
    System.out.println("Does the Sentence contains the given word? : " +contains);
    if (contains==true){
      for (int j = 0; j<words.length;j++){
        boolean enter = words[j].contains(word);
        if (enter==true){
          occ++;
        }
      }
      System.out.println("The Sentence contains the word " + occ + " times");
    }
  }

  /*
  Problem 4 - Anagrams
  Two words are anagrams if they contain the same letters but in a different order. Here are a few examples of anagram pairs:
    “listen” and “silent”
    “binary” and “brainy”
    “Paris” and “pairs”
    For a given input of two strings, return a Boolean TRUE if the two strings are anagrams.

    As an added challenge, for a given array of strings, return separate lists that group anagrams together. For example, the input {“tar,” “rat,” “art,” “meats,” “steam”}, the output should look something like {[“tar,” “rat,” “art”], [“meats,” “steam”]}.
  */
  public static void problem_Four(String word1, String word2){
    boolean same = false;
    System.out.println("The First word is "+word1);
    System.out.println("The Second word is "+word2);

    char[] wordOneArry = word1.toCharArray();
    char[] wordTwoArry = word2.toCharArray();

    Arrays.sort(wordOneArry);
    Arrays.sort(wordTwoArry);

    word1 = new String(wordOneArry);
    word2 = new String(wordTwoArry);
    int comp = word1.compareToIgnoreCase(word2);
    if (comp==0){
      same = true;
    }
    System.out.println("Are the Two string Anagrams? "+same);
  }
  //Needs Finishing
  public static void problem_Four_Challenge(String[] list){
    boolean same = false;
    String word = "";
    String [] alphaWords = new String[list.length];
    int comp = 1;
    for (int i = 0; i<list.length;i++){
      //System.out.println(list[i]);
      char[] characterArray = list[i].toCharArray();
      Arrays.sort(characterArray);
      word = new String(characterArray);
      //System.out.println(word);
      alphaWords[i] = word;
    }

    for (int x = 0; x<alphaWords.length;x++){
      char [] wordArray = alphaWords[x].toCharArray();
      System.out.println(wordArray);
    }
    /*
    char[] wordTwoArry = word2.toCharArray();

    Arrays.sort(wordOneArry);
    Arrays.sort(wordTwoArry);

    word1 = new String(wordOneArry);
    word2 = new String(wordTwoArry);
    int comp = word1.compareToIgnoreCase(word2);
    if (comp==0){
      same = true;
    }
    System.out.println("Are the Two string Anagrams? "+same);*/
  }

  /*
  Problem 5 - Panagrams
  A pangram is a sentence that contains all 26 letters of the English alphabet. One of the most well-known examples of a pangram is, “The quick brown fox jumps over the lazy dog.” Create a pangram checker that returns a Boolean TRUE if an input string is a pangram and FALSE if it isn’t.
  For an added pangram challenge, create a perfect pangram checker. A perfect pangram is a sentence that uses each letter of the alphabet only once, such as, “Mr. Jock, TV quiz Ph.D., bags few lynx.”
  */
  public static void problem_Five(String sentence){
    //replaceAll("\\s+","") -- Removes Spaces in a String input
    //replaceAll("\\p{Punct}", "") -- Removes all punctuation
    boolean containsAll = false;
    ArrayList<Character> alphabet = new ArrayList<Character>();
    ArrayList<Character> inputed = new ArrayList<Character>();
    String alphabetString = "abcdefghijklmnopqrstuvwxyz";
    String alphaSent = sentence.replaceAll("\\s+","").replaceAll("\\p{Punct}", "").toLowerCase();
    String orderedInput = "";


    for (int i = 0; i<alphabetString.length();i++){
      alphabet.add(alphabetString.charAt(i));
    }
    for (int i = 0; i<alphaSent.length();i++){
      inputed.add(alphaSent.charAt(i));
    }
    /* https://labex.io/tutorials/java-how-to-remove-duplicates-from-an-arraylist-using-a-hashset-in-java-414124 Learning How to use HashSet for Duplicates*/
    HashSet<Character> uniqueInput = new HashSet<>(inputed);
    ArrayList<Character> uniqueList = new ArrayList<Character>(uniqueInput);

    for (int i = 0; i<uniqueList.size();i++){
      orderedInput += uniqueList.get(i);
    }
    //System.out.println(test);
    boolean same = compareStrings(alphabetString,orderedInput);

    if (same==true){
      System.out.println("It contains all the letters of the alphabet");
    } else {
      System.out.print("It is not a Panagram");
    }
  }

  /*
  Problem Six - Count vowels and consonants
  With this challenge, you’ll create a program that will count the number of vowels and the number of consonants in a string.
  Using the same example string “I love Codecademy,” should output as “vowels: 7, consonants: 8.” This is, of course, assuming you didn’t include “y” as a vowel, in which case your output should read: “vowels: 8, consonants: 7.”
  */
  public static void problem_Six(String sentence){
    ArrayList<Character> vowels = new ArrayList<Character>();
    String vo = "aeiou";
    String input = sentence.replaceAll("\\s+","").replaceAll("\\p{Punct}", "").toLowerCase();
    int vCount = 0;
    int cCount = 0;
    char current = 'a';

    for (int i = 0; i<vo.length();i++){
      vowels.add(vo.charAt(i));
    }

    for (int i = 0; i<input.length();i++){
      current = input.charAt(i);

      if (vowels.contains(current)){
        vCount++;
      } else {
        cCount++;
      }
    }

    System.out.println("Number of Vowels in Sentence: "+vCount);
    System.out.println("Number of Consonants in Sentence: "+cCount);
  }

  /*
  Problem 7 - Number Reversal
  This one is a technical interview favorite. For a given input number, return the number in reverse. So, an input of 3956 should return 6593.
  If you’re ready for a bigger challenge, reverse a decimal number. The decimal point should stay in the same place. So, the number 193.56 should output 653.91.
  */
  // https://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number learning the POP and PUSH functions
  public static void problem_Seven(int n){
    LinkedList<Integer> stack = new LinkedList<Integer>();
    ArrayList<Integer> invert = new ArrayList<Integer>();
    int org = n;
    int count = 1;
    while (n>0){
      stack.push(n%10);
      n = n/10;
    }
    int size = stack.size();
    System.out.println("Inputed Integer is: "+stack);
    for (int i=0;i<size;i++){
      invert.add((stack.get(size-count)));
      count++;
    }
    /*
    while (!stack.isEmpty()){
      System.out.println(stack.pop());
    }*/
    System.out.println("Inverted Integer is: "+invert);
  }

  /*
  Problem 8 - Armstrong Numbers
  An Armstrong number is a whole number that’s equal to the sum of its digits raised to the power of the total number of digits. For example, 153 is an Armstrong number because there are three digits, and 153 = 13 + 53 + 33. The four-digit number 8208 is also an Armstrong number, as 8208 = 84 + 24 + 04 + 84.
  Create an Armstrong number checker that returns a Boolean TRUE if the input number is an Armstrong number. Hint: to extract each digit from a given number, try using the remainder/modulo operator.
  If you’re looking for something a little more challenging, create an Armstrong number calculator that returns all Armstrong numbers between 0 and the input number.
  */
  public static void problem_Eight(int n){
    LinkedList<Integer> stack = new LinkedList<Integer>();
    int org = n;
    Double sum = 0.0;
    int x = 0;
    boolean same = false;
    while (n>0){
      stack.push(n%10);
      n = n/10;
    }
    int size = stack.size();
    System.out.println("Inputed Integer is: "+stack);
    for (int j=0; j<size;j++){
      x = stack.get(j);
      sum = sum + (Math.pow(x,size));
    }
    int value = (int)Math.round(sum);
    if (value == org){
      same = true;
    }
    System.out.println("Is "+org+" an Armstrong Number? "+same);
  }

  /*
  Problem 9 - Product Maximizer
  For a given input array of numbers, find the two that result in the largest product. The output should include the two numbers in the array along with their product.
  As an extra challenge, use an input of two arrays of numbers and find two numbers — one from each input array — that results in the largest product.
  */
  public static void problem_Nine(int[] input){
    int size = input.length;
    int product = 0;
    Arrays.sort(input);
    product = (input[size-1])*(input[size-2]);
    System.out.println("This two largest numbers in the array are "+input[size-1]+" & "+input[size-2]);
    System.out.println("The Largest Product from the array is: "+product);
  }

  /*
  Problem 10 - Prime Number checker
  A prime number is any whole number greater than 1 whose only factors are 1 and itself. For example, 7 is a prime number because it’s only divisible by 1 and 7.
  Create a function that returns TRUE if an input number is prime. The first few prime numbers are 2, 3, 5, 7, 11, 13, 17, and 19.
  For a slightly harder challenge, create a prime number calculator that outputs all prime numbers between 2 and the input number.
  */
  public static void problem_Ten(int n){
    System.out.println("Inputted Number: "+n);
    boolean prime = false;
    int count = 0;
    //Ensures that the number is Larger than 1 and Not EVEN, unless 2
    if (n>1 && (n%2 != 0) || n == 2){
      for (int i = 1;i<=n;i++){
        //System.out.println(n%i);
        if (n%i==0){
          count++;
        }
      }
      if (count == 2){
        System.out.println("PRIME");
        prime = true;
      }
    }
    System.out.println("Is this number a prime: "+prime);
  }

  /*
  Problem 11 - Prime Factorization
  The prime factors of a number are all of the integers below that number that are divisible into the number as well as 1. For example, the prime factors of 12 are 1,2,3,4,6, and 12.
  Create a prime factorization calculator that returns the prime factors of any number between 2 and 100. If you’re looking for a more advanced version of this challenge, use exercise 9 to create a prime factorization calculator for any number. Hint: think about using square roots to cut your work in half.
  */
  public static void problem_Eleven(int n){
    ArrayList<Integer> factors = new ArrayList<Integer>();
    for (int i = 1; i<=n; i++){
      if (n%i == 0){
        factors.add(i);
        }
      }
    System.out.println(factors);
  }

  /*
  Problem 12 - Summation
  Write a Java program that returns the sum of two numbers. The numbers to be summed may be integers, rational numbers, real numbers, or complex numbers.
  For example, the input 289 + 398 should output 687.
  */
  public static void problem_Twelve(double x, double y){
    System.out.print(x+y);
  }
  //Removes Duplcates from a String Input - Taken from https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/ on 22/03/2025
  public static String removeDuplicate(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        boolean[] seen = new boolean[256];

        // Traverse through all characters
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check if s[i] is present before it
            if (!seen[c]) {
                sb.append(c);
                seen[c] = true;
            }
        }

        return sb.toString();
    }
  public static String alpabetizeString(String s){
    char[] wordOneArry = s.toCharArray();
    Arrays.sort(wordOneArry);
    s = new String(wordOneArry);
    return s;
  }
  public static boolean compareStrings(String s1, String s2){
    int comp = s1.compareToIgnoreCase(s2);
    if (comp==0){
      return true;
    } else {
      return false;
    }
  }
}
