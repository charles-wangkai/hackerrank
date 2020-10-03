import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> name2phone = new HashMap<String, Integer>();

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			Integer phone = sc.nextLine();

			name2phone.put(name, phone);
		}

		while (sc.hasNext()) {
			String name = sc.next();

			if (name2phone.containsKey(name)) {
				System.out.println(name + "=" + name2phone.get(name));
			} else {
				System.out.println("Not found");
			}
		}

		sc.close();
	}
}
