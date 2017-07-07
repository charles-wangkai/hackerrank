import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        /* Create a table to store all the heights.
           As in the problem, the height at nth stage depends on (n-1)th stage,
           we can take the help of dynamic programming */
           
        int[] heights = new int[61];
        
        heights[0] = 1;
        int knownUpto = 0;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            /* We know heights upto `knownUpto`. Hence if n < than knownUpto, it's already
               calculated and stored in the table. So we print it directly */
            if(knownUpto >= n){
                System.out.println(heights[n]);
            }
            else{
            
                /* We don't heights from height > knownUpto and height = n. So we calculate it and store.*/
                for(int i=knownUpto+1;i<=n;i++){
                    if(i%2 != 0)
                        heights[i] = heights[i-1] *2;
                    else
                        heights[i] = heights[i-1] + 1;
                    
                    knownUpto = i;
                }
                System.out.println(heights[n]);
            }
        }
    }
}
