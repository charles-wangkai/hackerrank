import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] n = new int[3];
		for (int i = 0; i < n.length; i++) {
			n[i] = sc.nextInt();
		}

		@SuppressWarnings("unchecked")
		Deque<Integer>[] stacks = new Deque[3];
		int[] totalHeights = new int[3];
		for (int i = 0; i < stacks.length; i++) {
			stacks[i] = new LinkedList<Integer>();

			for (int j = 0; j < n[i]; j++) {
				int height = sc.nextInt();
				stacks[i].add(height);
				totalHeights[i] += height;
			}
		}

		while (!(totalHeights[0] == totalHeights[1] && totalHeights[1] == totalHeights[2])) {
			int maxTotalHeightIndex = 0;
			for (int i = 1; i < totalHeights.length; i++) {
				if (totalHeights[i] > totalHeights[maxTotalHeightIndex]) {
					maxTotalHeightIndex = i;
				}
			}

			totalHeights[maxTotalHeightIndex] -= stacks[maxTotalHeightIndex].pollFirst();
		}
		System.out.println(totalHeights[0]);

		sc.close();
	}
}
