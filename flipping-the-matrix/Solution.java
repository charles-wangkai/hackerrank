import java.util.Scanner;

public class Solution{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		while(q-- > 0){
			int n = in.nextInt();
			long mat[][] = new long[2*n][2*n];
			for( int i=0 ; i < 2*n ; i++){
				for(int j=0 ; j<2*n;j++){
					mat[i][j] = in.nextLong();
				}
			}
			long sum = 0;
			for(int i=0;i<n;i++){
				for(int j = 0 ; j < n ; j++){
					sum += findMax(mat[i][j],mat[2*n -1-i][j],mat[i][2*n -1 -j],mat[2*n-1-i][2*n-1-j]);
				}
			}
			System.out.println(sum);
		}
	}
	 public static long findMax(long a, long b,long c,long d){
		 if(a>=b && a>=c && a>=d)
			 return a;
		 else if(b>=a && b>=c && b>=d)
			 return b;
		 else if(c>=a && c>=b && c>=d)
			 return c;
		 else
			 return d;
	 }
}