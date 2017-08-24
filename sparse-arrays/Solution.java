import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> str2count = new HashMap<String, Integer>();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			str2count.put(str, str2count.getOrDefault(str, 0) + 1);
		}

		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			String str = sc.next();
			System.out.println(str2count.getOrDefault(str, 0));
		}

		sc.close();
	}
}
