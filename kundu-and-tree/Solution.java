import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	static final int MODULO = 1000000007;
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		Vertex[] vertices = new Vertex[N + 1];
		for (int i = 1; i <= N; i++) {
			vertices[i] = new Vertex();
		}

		for (int i = 0; i < N - 1; i++) {
			int v1 = in.nextInt();
			int v2 = in.nextInt();
			String color = in.next();

			if (color.equals("b")) {
				int root1 = findRoot(vertices, v1);
				int root2 = findRoot(vertices, v2);
				vertices[root2].parent = root1;
				vertices[root1].size += vertices[root2].size;
			}
		}

		Map<Integer, Integer> size2count = new HashMap<Integer, Integer>();
		for (int i = 1; i <= N; i++) {
			if (vertices[i].parent == -1) {
				int size = vertices[i].size;
				if (!size2count.containsKey(size)) {
					size2count.put(size, 0);
				}
				size2count.put(size, size2count.get(size) + 1);
			}
		}

		List<SizeNCount> scList = size2count.entrySet().stream()
				.map(entry -> new SizeNCount(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());

		answer = 0;
		search(scList, 0, 3, 1);
		System.out.println(answer);

		in.close();
	}

	static void search(List<SizeNCount> scList, int index, int remain,
			int product) {
		if (index == scList.size()) {
			if (remain == 0) {
				answer = addMod(answer, product);
			}
			return;
		}

		SizeNCount sc = scList.get(index);
		for (int i = 0; i <= Math.min(sc.count, remain); i++) {
			int nextProduct = multiplyMod(product, C(sc.count, i));
			for (int j = 0; j < i; j++) {
				nextProduct = multiplyMod(nextProduct, sc.size);
			}
			search(scList, index + 1, remain - i, nextProduct);
		}
	}

	static int C(int n, int m) {
		int[] factors = new int[m];
		for (int i = 0; i < factors.length; i++) {
			factors[i] = n - i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 0;; j++) {
				if (factors[j] % i == 0) {
					factors[j] /= i;
					break;
				}
			}
		}

		int result = 1;
		for (int factor : factors) {
			result = multiplyMod(result, factor);
		}
		return result;
	}

	static int addMod(int a, int b) {
		return (a + b) % MODULO;
	}

	static int multiplyMod(int a, int b) {
		return (int) ((long) a * b % MODULO);
	}

	static int findRoot(Vertex[] vertices, int index) {
		int root = index;
		while (vertices[root].parent != -1) {
			root = vertices[root].parent;
		}

		int p = index;
		while (p != root) {
			int nextP = vertices[p].parent;
			vertices[p].parent = root;
			p = nextP;
		}

		return root;
	}
}

class Vertex {
	int parent = -1;
	int size = 1;
}

class SizeNCount {
	int size;
	int count;

	SizeNCount(int size, int count) {
		this.size = size;
		this.count = count;
	}
}
