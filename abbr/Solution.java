import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			String a = sc.next();
			String b = sc.next();

			System.out.println(solve(a, b) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String a, String b) {
		boolean[][] possibles = new boolean[a.length() + 1][b.length() + 1];
		for (int lengthA = 0; lengthA <= a.length(); lengthA++) {
			for (int lengthB = 0; lengthB <= b.length(); lengthB++) {
				if (lengthA == 0) {
					if (lengthB == 0) {
						possibles[lengthA][lengthB] = true;
					} else {
						possibles[lengthA][lengthB] = false;
					}
				} else {
					char lastA = a.charAt(lengthA - 1);

					if (lengthB == 0) {
						if (Character.isLowerCase(lastA)) {
							possibles[lengthA][lengthB] = possibles[lengthA - 1][lengthB];
						} else {
							possibles[lengthA][lengthB] = false;
						}
					} else {
						char lastB = b.charAt(lengthB - 1);

						if (Character.isLowerCase(lastA)) {
							if (Character.toUpperCase(lastA) == lastB) {
								possibles[lengthA][lengthB] = possibles[lengthA - 1][lengthB]
										|| possibles[lengthA - 1][lengthB - 1];
							} else {
								possibles[lengthA][lengthB] = possibles[lengthA - 1][lengthB];
							}
						} else {
							if (lastA == lastB) {
								possibles[lengthA][lengthB] = possibles[lengthA - 1][lengthB - 1];
							} else {
								possibles[lengthA][lengthB] = false;
							}
						}
					}
				}
			}
		}
		return possibles[a.length()][b.length()];
	}
}
