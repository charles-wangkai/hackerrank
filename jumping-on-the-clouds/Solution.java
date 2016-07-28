import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}

		int[] minSteps = new int[c.length];
		Arrays.fill(minSteps, 1, minSteps.length, -1);
		for (int i = 0; i < minSteps.length; i++) {
			if (c[i] == 1) {
				continue;
			}

			if (i >= 1 && c[i - 1] == 0 && minSteps[i - 1] >= 0) {
				minSteps[i] = Math.min((minSteps[i] < 0) ? Integer.MAX_VALUE : minSteps[i], minSteps[i - 1] + 1);
			}
			if (i >= 2 && c[i - 2] == 0 && minSteps[i - 2] >= 0) {
				minSteps[i] = Math.min((minSteps[i] < 0) ? Integer.MAX_VALUE : minSteps[i], minSteps[i - 2] + 1);
			}
		}
		System.out.println(minSteps[minSteps.length - 1]);

		sc.close();
	}
}
