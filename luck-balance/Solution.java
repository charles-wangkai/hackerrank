import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int result = 0;
		List<Integer> importantLucks = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int L = sc.nextInt();
			int T = sc.nextInt();

			if (T == 0) {
				result += L;
			} else {
				importantLucks.add(L);
			}
		}

		Collections.sort(importantLucks, Collections.reverseOrder());
		for (int i = 0; i < importantLucks.size(); i++) {
			result += importantLucks.get(i) * (i + 1 <= K ? 1 : -1);
		}
		System.out.println(result);

		sc.close();
	}
}
