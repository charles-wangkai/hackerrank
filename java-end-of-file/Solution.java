import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int i = 1; in.hasNextLine(); i++) {
			System.out.println(i + " " + in.nextLine());
		}
		in.close();
	}
}
