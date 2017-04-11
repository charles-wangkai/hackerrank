import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String steps = sc.next();
		System.out.println(solve(steps));

		sc.close();
	}

	static int solve(String steps) {
		int valleyNum = 0;
		int level = 0;
		for (char step : steps.toCharArray()) {
			if (level == -1 && step == 'U') {
				valleyNum++;
			}

			if (step == 'U') {
				level++;
			} else {
				level--;
			}
		}
		return valleyNum;
	}
}
