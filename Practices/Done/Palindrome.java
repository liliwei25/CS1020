/*
 * author  : [Li Liwei]
 * matric no. : [A0155991R]
 */

import java.util.*;

public class Palindrome {
 /* use this method to check whether the string is palindrome word or not
  *   PRE-Condition  :
  *   POST-Condition :
  */
 public static boolean isPalindrome(String word) {
   String palindrome = new StringBuilder(word).reverse().toString();
   
   if(word.compareToIgnoreCase(palindrome) == 0) return true;
   else return false;
 }
 
 public static void main(String[] args) {
  // declare the necessary variables
   String line1, line2;

  // declare a Scanner object to read input
   Scanner scn = new Scanner(System.in);

  // read input and process them accordingly
   line1 = scn.nextLine();
   line2 = scn.nextLine();

  // simulate the problem
  

  // output the result
   if(isPalindrome(line1+line2)) System.out.println("YES");
   else System.out.println("NO");
 }
}