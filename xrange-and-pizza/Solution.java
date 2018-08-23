import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		Operation[] operations = new Operation[m];
		for (int i = 0; i < operations.length; i++) {
			int type = sc.nextInt();
			int k = sc.nextInt();

			operations[i] = new Operation(type, k);
		}

		Operation answer = solve(n, operations);
		System.out.println(String.format("%d %d", answer.type, answer.k));

		sc.close();
	}

	static Operation solve(int n, Operation[] operations) {
		boolean flip = false;
		int pos0 = 0;
		for (Operation operation : operations) {
			if (operation.type == 1) {
				pos0 = (pos0 + operation.k) % n;
			} else {
				pos0 = (operation.k - pos0 + n) % n;

				flip = !flip;
			}
		}

		if (flip) {
			return new Operation(2, pos0);
		} else {
			return new Operation(1, (n - pos0) % n);
		}
	}
}

class Operation {
	int type;
	int k;

	Operation(int type, int k) {
		this.type = type;
		this.k = k;
	}
}