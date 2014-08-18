package utopiantree;

/**Problem Statement
 * 
 * The Utopian tree goes through 2 cycles of growth every year. 
 * The first growth cycle of the tree occurs during the monsoon, when it doubles in height.
 *  The second growth cycle of the tree occurs during the summer, when its height increases by 1 meter.
 *  Now, a new Utopian tree sapling is planted at the onset of the monsoon.
 *  Its height is 1 meter. Can you find the height of the tree after N growth cycles?
 *  Input Format
 *  The first line contains an integer, T, the number of test cases.
 *  T lines follow. Each line contains an integer, N, that denotes the number of cycles for that test case.
 
 *  Constraints
 *  1 <= T <= 10
 *  0 <= N <= 60

 *  Output Format
 *  For each test case, print the height of the Utopian tree after N cycles. 
 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		while (testcases-- > 0) {
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println("1");
			} else {
				int h = 1;
				for (int i = 1; i <= n; i++) {
					if (i % 2 == 0) {
						h += 1;
					} else {
						h *= 2;
					}
				}
				System.out.println(h);
			}
		}
		sc.close();
	}
}