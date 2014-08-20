package got1;

/**
 * King Robert has 7 kingdoms under his rule. 
 * He finds out from a raven that the Dothraki are soon going to wage a war against him. 
 * But, he knows the Dothraki need to cross the narrow river to enter his dynasty. 
 * There is only one bridge that connects both sides of the river which is sealed by a huge door.
 * 
 * The king wants to lock the door so that the Dothraki can't enter. 
 * But, to lock the door he needs a key that is an anagram of a certain palindrome string.
 * The king has a string composed of lowercase English letters. Help him figure out if any anagram of the string can be a palindrome or not.
 * 
 * 
 * Input Format
 * A single line which contains the input string
 * 
 * Constraints
 * 1<=length of string <= 10^5
 * Each character of the string is a lowercase English letter.
 * 
 * 
 * Output Format
 * A single line which contains YES or NO in uppercase.
 * 
 * 
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans;
        int[] count = new int[26];
        for ( int i = 0; i < 26; i++ ) {
            count[i] = 0;
        }
        int length = inputString.length();
        for ( int i = 0; i < length; i++ ) {
            char c = inputString.charAt(i);
            count[c - 'a'] += 1;
        }
        int odd = 0;
        for ( int i = 0; i < 26; i++ ) {
            if ( count[i] % 2 != 0 ) {
                odd++;
            }
        }
        if ( length % 2 == 0 ) {
            ans = odd == 0 ? "YES" : "NO";
        }else {
        	ans = odd == 1 ? "YES" : "NO";
        }
        System.out.println(ans);
        myScan.close();
    }
}

