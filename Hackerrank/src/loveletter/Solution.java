/**
 *  Problem Statement
 *  
 *  James got hold of a love letter that his friend Harry has written for his girlfriend. 
 *  Being the prankster that James is, he decides to meddle with it.
 *  He changes all the words in the letter into palindromes.
 *  While modifying the letters of the word, he follows 2 rules:
 *  (a) He always reduces the value of a letter, e.g. he changes 'd' to 'c', but he does not change 'c' to 'd'.
 *  (b) If he has to repeatedly reduce the value of a letter, he can do it until the letter becomes 'a'. Once a letter has been changed to 'a', it can no longer be changed.
 *  
 *  Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations he carries out to convert a given string into a palindrome.
 *  
 *  Input Format
 *  The first line contains an integer T, i.e., the number of test cases.
 *  The next T lines will contain a string each.
 *  
 *  Output Format
 *  A single line containing the number of minimum operations corresponding to each test case.
 *  Constraints
 *  1 ≤ T ≤ 10
 *  1 ≤ length of string ≤ 104
 *  All characters are lower cased english letters. 
 */

package loveletter;

import java.util.Scanner;

public class Solution {
    public static int minSteps( String s ) {
        int i = 0;
        int j = s.length() - 1;
        int steps = 0;
        while ( i != j && i < j ) {
            steps += Math.abs((int) ( s.charAt(j) - s.charAt(i) )) ;
            i++;
            j--;
        }
        return steps;
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int testcases = sc.nextInt();
        while ( testcases-- > 0 ) {
            String s = sc.next();
            int result = minSteps( s );
            System.out.println( result );           
        }
        sc.close();
    }
}