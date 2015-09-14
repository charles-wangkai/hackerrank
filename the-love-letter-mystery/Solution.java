import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String str = in.next();
			System.out.println(findOperationNum(str));
		}

		in.close();
	}

	static int findOperationNum(String str) {
		int operationNum = 0;
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			operationNum += Math.abs(str.charAt(i) - str.charAt(j));
		}
		return operationNum;
	}
}
