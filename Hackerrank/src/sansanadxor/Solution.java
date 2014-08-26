package sansanadxor;

import java.util.Scanner;

/**
 * 
 * @author Ankush Bansal
 * 
 *         Problem Statement
 * 
 *         Sansa has an array. She wants to find the value obtained by XOR-ing
 *         the contiguous subarrays, followed by XOR-ing the values thus
 *         obtained. Can you help her in this task? Note : [1,2,3] is contiguous
 *         subarray of [1,2,3,4] while [1,2,4] is not.
 * 
 *         Input Format
 * 
 *         First line contains an integer T, number of the test cases. The first
 *         line of each test case contains an integer N, number of elements in
 *         the array. The second line of each test case contains N integers that
 *         are elements of the array.
 * 
 *         Output Format
 * 
 *         Print the answer corresponding to each test case in a seperate line.
 * 
 *         Constraints 1≤T≤5 2≤N≤105 1≤numbers in array≤108
 * 
 * 
 *         Sample Input 1 3 1 2 3
 * 
 *         Sample Output 2
 * 
 * 
 *         Solution
 * 
 *         If array size is even, then result is going to be zero. If array size
 *         is odd, then result is xor of all the even positioned elements of the
 *         array.
 * 
 *         This solution is based on following property of xor:
 * 
 *         x ^ x = 0
 * 
 */

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = 0;
		if (sc.hasNext()) {
			testcases = sc.nextInt();
		}
		while (testcases-- > 0) {
			int n = 0;
			if (sc.hasNext()) {
				n = sc.nextInt();
			}
			int[] array = new int[n];
			// Scanning for the array
			for (int i = 0; i < n; i++) {
				if (sc.hasNext()) {
					array[i] = sc.nextInt();
				}
			}
			// Corner case, if there is only 1 element in the array
			if (n == 1) {
				System.out.println(array[0]);
				continue;
			}
			// for even number of elements in the array
			if (n % 2 == 0) {
				System.out.println("0");
			} else {
				int result = 0;
				// xoring all the even positioned elements
				for (int i = 0; i < n; i = i + 2) {
					result ^= array[i];
				}
				System.out.println(result);
			}
		}
		sc.close();
	}
}
