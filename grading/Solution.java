import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int grade = sc.nextInt();
			System.out.println(grade < 38 ? grade : round(grade));
		}

		sc.close();
	}

	static int round(int grade) {
		int nextFive = (grade / 5 + 1) * 5;
		int distanceToNextFive = nextFive - grade;
		return (distanceToNextFive < 3) ? nextFive : grade;
	}
}
