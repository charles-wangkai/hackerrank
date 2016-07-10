import java.util.BitSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		BitSet[] B = new BitSet[3];
		for (int i = 1; i < B.length; i++) {
			B[i] = new BitSet(N);
		}
		for (int i = 0; i < M; i++) {
			String operation = sc.next();
			int arg1 = sc.nextInt();
			int arg2 = sc.nextInt();
			if (operation.equals("AND")) {
				B[arg1].and(B[arg2]);
				;
			} else if (operation.equals("OR")) {
				B[arg1].or(B[arg2]);
			} else if (operation.equals("XOR")) {
				B[arg1].xor(B[arg2]);
			} else if (operation.equals("FLIP")) {
				B[arg1].flip(arg2);
			} else if (operation.equals("SET")) {
				B[arg1].set(arg2);
			}

			System.out.println(B[1].cardinality() + " " + B[2].cardinality());
		}

		sc.close();
	}
}
