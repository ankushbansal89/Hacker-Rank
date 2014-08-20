package angrychildren;

/**
 * Bill Gates is on one of his philanthropic journeys to a village in Utopia.
 * He has N packets of candies and would like to distribute one packet to each of the K children in the village (each packet may contain different number of candies). To avoid any fighting among the children, he would like to pick K out of N packets, such that unfairness is minimized.
 * Suppose the K packets have (x1, x2, x3,....xk) candies in them, where xi denotes the number of candies in the ith packet, then we define unfairness as
 * max(x1,x2,...xk) - min(x1,x2,...xk)
 * awhere max denotes the highest value amongst the elements, and min denotes the least value amongst the elements. 
 * Can you figure out the minimum unfairness and print it?
 * 
 * 
 * Input Format
 * The first line contains an integer N.
 * The second line contains an integer K. N lines follow. Each line contains an integer that denotes the candy in the ith packet.
 * 
 * 
 * Output Format
 * An integer that denotes the minimum possible value of unfairness.
 * 
 * 
 * 
 * Constraints
 * 1<=N<=105
 * 1<=K<=N
 * 0<= number of candies in any packet <=109
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Solution {
   static BufferedReader in = new BufferedReader(new InputStreamReader(
         System.in));
   static StringBuilder out = new StringBuilder();

   public static void main(String[] args) throws NumberFormatException, IOException {
      int numPackets = Integer.parseInt(in.readLine());
      int numKids = Integer.parseInt(in.readLine());
      int[] packets = new int[numPackets];
      
      for(int i = 0; i < numPackets; i ++)
      {
         packets[i] = Integer.parseInt(in.readLine());
      }
      
      int unfairness = Integer.MAX_VALUE;
      
      Arrays.sort(packets);
      for ( int i = numKids - 1 ; i < numPackets; i++ ) {
          int diff = packets[i] - packets[i - numKids + 1];
          if ( unfairness > diff ) {
              unfairness = diff;
          }  
      }
      System.out.println(unfairness);
   }
}

