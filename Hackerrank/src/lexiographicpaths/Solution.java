/**
 * 
 */
package lexiographicpaths;

import java.util.Scanner;

/**
 * Problem Statement
 * 
 * Krishnakant is standing at (0,0) in the Cartesian plane.
 * He wants to go to the point (N,M) in the same plane using only horizontal and vertical moves of 1 unit. 
 * There are many ways of doing this, and he is writing down all such ways. 
 * Every way will comprise of few H moves and few V moves. i.e. moves in horizontal and vertical direction respectively. 
 * For example, if we want to go to point (2,2) from point (0,0), HVHV is one of the possible ways.
 * 
 * Given the value of K, he wants to know lexicographically Kth smallest way of going to (N,M) from (0,0).
 * 
 * Input Format
 * 
 * The first line contains an integer T , i.e., number of test cases.
 * Next T lines will contain integers N,M and K.
 * 
 * 
 * Output Format
 * 
 * For each test case, print lexicographically Kth smallest path.
 * 
 * Constraints
 * 1≤T≤100000
 * 1≤N≤10
 * 1≤M≤10
 * 0≤K<number of paths
 * 
 * Sample Input
 * 
 * 2
 * 2 2 2
 * 2 2 3
 * 
 * Sample Output
 * HVVH
 * VHHV
 * 
 * 
 * Explanation
 * 
 * All the paths of going to (2,2) from (0,0) in lexicographically increasing order:
 * 0.HHVV
 * 1.HVHV
 * 2.HVVH
 * 3.VHHV
 * 4.VHVH
 * 5.VVHH
 * 
 * @author Ankush Bansal
 *
 */

public class Solution {

	/**
	 * Finds next integer with same number of 1's bits as parameter integer
	 * @param integer
	 * @return next integer with same number of 1's bits
	 */
   public static int nextBinary(int t) {
        int c = t & -t;
        int r = c + t;
        return ((((r ^ t) >> 2) / c ) | r ); 
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = 0;
        if ( sc.hasNext() ) {
            testcases = sc.nextInt();
        }
        while ( testcases-- > 0 ) {
            int n = 0;
            int m = 0;
            int k = 0;
            if ( sc.hasNext() ) {
                n = sc.nextInt();
            }   
            if ( sc.hasNext() ) {
                m = sc.nextInt();
            }
            if ( sc.hasNext() ) {
                k = sc.nextInt();
            }
            StringBuilder shortest = new StringBuilder("");
            // Lexiographic shortest path from (0,0) to (n,m) will always be n times H + m times V
            //replacing H with 0 bit and V with 1 bit
            for ( int i = 0; i < n; i++ ) {
                shortest.append("0");
            }
            for ( int i = 0; i < m; i++ ) {
                shortest.append("1");
            }
            int len = shortest.length();
            //Storing it in integer using binary format
            int temp = Integer.parseInt(shortest.toString(), 2);
            //finding kth next number with same number of 1's bit as shortest
            for ( int i = 1; i <= k ; i ++ ) {
                temp = nextBinary(temp);
            }
            //converting result into H & V format
            for ( int i = len - 1; i >= 0; i-- ) {
                if ( temp % 2 == 0 ) {
                    shortest = shortest.replace(i,i + 1, "H");
                }else {
                    shortest = shortest.replace(i,i + 1, "V");
                }   
                    temp /= 2;
            }
            //Printing the result
            System.out.println(shortest.toString());
        }
        sc.close();
    }
}
