import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Set<Pair> pairs = new HashSet<Pair>();
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			String a = in.next();
			String b = in.next();
			pairs.add(new Pair(a, b));
			System.out.println(pairs.size());
		}
		in.close();
	}
}

class Pair {
	String a;
	String b;

	Pair(String a, String b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int hashCode() {
		return a.hashCode() * b.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Pair other = (Pair) obj;
		return a.equals(other.a) && b.equals(other.b);
	}
}