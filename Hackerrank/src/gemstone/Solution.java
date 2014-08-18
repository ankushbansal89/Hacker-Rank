/**
 * Problem Statement
 * 
 * John has discovered various rocks. 
 * Each rock is composed of various elements, and each element is represented by a lowercase latin letter from 'a' to 'z'.
 *  An element can be present multiple times in a rock. 
 *  An element is called a 'gem-element' if it occurs at least once in each of the rocks.
 *  
 *  Given the list of rocks with their compositions, display the number of gem-elements that exist in those rocks.
 *  
 *  Input Format
 *  The first line consists of N, the number of rocks.
 *  Each of the next N lines contain rocks' composition. Each composition consists of lowercase letters of English alphabet.
 *  
 *  Output Format
 *  Print the number of gem-elements that are common in these rocks.
 *  
 *  Constraints
 *  1 ≤ N ≤ 100
 *  Each composition consists of only small latin letters ('a'-'z').
 *  1 ≤ Length of each composition ≤ 100
 *   
 */

package gemstone;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {
    public static Map<String, Integer> map = new HashMap<String, Integer>();;
    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int testcases = sc.nextInt();
        for ( char c = 'a'; c <= 'z'; c++ ) {
            map.put( String.valueOf(c), 1);
        }
        while ( testcases-- > 0 ) {
            String s = sc.next();
            Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
            while ( iter.hasNext() ) {
                Map.Entry<String, Integer> e = iter.next();
                if ( !s.contains( e.getKey().toString() )) {
                    iter.remove();
                }
            }
        }
        System.out.println( map.size());
        sc.close();
    }
}