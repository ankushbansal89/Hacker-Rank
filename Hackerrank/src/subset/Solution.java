package subset;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Problem Statement
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int setLength = scanner.nextInt();
        int[] set = new int[setLength];
        for (int i = 0; i < setLength; i++) {
            set[i] = scanner.nextInt();
        }

        Arrays.sort(set);
        for (int startIndex = 0; startIndex < setLength; startIndex++) {
            for (int lengthOfSubset = 0; lengthOfSubset < setLength; lengthOfSubset++) {
                //Storing the first element in the subset, then finding the rest of the subset
                int[] subset = new int[lengthOfSubset + 1];
                subset[0] = set[startIndex];
                findSubSet(set, lengthOfSubset, startIndex + 1, subset, 1);
            }
        }
    }

    public static void findSubSet(int[] set, int lengthSubset, int startIndex, int[] subset, int index) {
        if (lengthSubset <= 0) {
            System.out.print("[");
            int len = subset.length;
            for ( int i = 0; i < len; i++) {
                System.out.print(subset[i]);
                if ( i != len - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
            return;
        }
        if (lengthSubset > set.length - startIndex) {
            return;
        }
        subset[index] = set[startIndex];
        findSubSet(set, lengthSubset - 1, startIndex + 1, subset, index + 1);
        findSubSet(set, lengthSubset, startIndex + 1, subset, index);
    }

}
