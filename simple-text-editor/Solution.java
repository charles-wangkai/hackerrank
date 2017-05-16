import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder S = new StringBuilder();
		Stack<Operation> operations = new Stack<Operation>();
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				String W = sc.next();
				S.append(W);

				operations.push(new Operation(type, W.length()));
			} else if (type == 2) {
				int k = sc.nextInt();
				String last = S.substring(S.length() - k);
				S.delete(S.length() - k, S.length());

				operations.push(new Operation(type, last));
			} else if (type == 3) {
				int k = sc.nextInt();
				System.out.println(S.charAt(k - 1));
			} else {
				Operation operation = operations.pop();

				if (operation.type == 1) {
					S.delete(S.length() - (int) operation.argument, S.length());
				} else {
					S.append(operation.argument);
				}
			}
		}

		sc.close();
	}
}

class Operation {
	int type;
	Object argument;

	Operation(int type, Object argument) {
		this.type = type;
		this.argument = argument;
	}
}