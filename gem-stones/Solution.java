import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		Set<Integer> gemElements = null;
		for (int i = 0; i < N; i++) {
			String composition = in.next();
			Set<Integer> elements = composition.chars().collect(HashSet<Integer>::new, Set::add, Set::addAll);
			if (gemElements == null) {
				gemElements = elements;
			} else {
				gemElements = intersect(gemElements, elements);
			}
		}
		System.out.println(gemElements.size());

		in.close();
	}

	static Set<Integer> intersect(Set<Integer> a, Set<Integer> b) {
		Set<Integer> result = new HashSet<Integer>();
		for (int elemA : a) {
			if (b.contains(elemA)) {
				result.add(elemA);
			}
		}
		return result;
	}
}
