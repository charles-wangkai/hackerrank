import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		int[] L = readArray(br, q);
		int[] R = readArray(br, q);

		int[] solution = solve(L, R);
		StringBuilder sb = new StringBuilder();
		for (int element : solution) {
			sb.append(element).append("\n");
		}
		System.out.print(sb);
	}

	static int[] readArray(BufferedReader br, int size) throws Throwable {
		int[] result = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		return result;
	}

	static int[] solve(int[] L, int[] R) {
		int[] result = new int[L.length];
		Map<Integer, Integer> personToParent = new HashMap<>();
		Map<Integer, Integer> rootToSize = new HashMap<>();
		int maxSize = 1;
		for (int i = 0; i < result.length; i++) {
			addIfNotFound(personToParent, rootToSize, L[i]);
			addIfNotFound(personToParent, rootToSize, R[i]);

			int rootL = findRoot(personToParent, L[i]);
			int rootR = findRoot(personToParent, R[i]);

			if (rootL != rootR) {
				personToParent.put(rootL, rootR);
				rootToSize.put(rootR, rootToSize.get(rootR) + rootToSize.get(rootL));
				rootToSize.remove(rootL);

				maxSize = Math.max(maxSize, rootToSize.get(rootR));
			}

			result[i] = maxSize;
		}
		return result;
	}

	static int findRoot(Map<Integer, Integer> personToParent, int person) {
		int root = person;
		while (personToParent.get(root) >= 0) {
			root = personToParent.get(root);
		}

		int p = person;
		while (p != root) {
			int parent = personToParent.get(p);
			personToParent.put(p, root);

			p = parent;
		}

		return root;
	}

	static void addIfNotFound(Map<Integer, Integer> personToParent, Map<Integer, Integer> rootToSize, int person) {
		if (!personToParent.containsKey(person)) {
			personToParent.put(person, -1);
			rootToSize.put(person, 1);
		}
	}
}
