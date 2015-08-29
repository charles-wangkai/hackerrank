import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line = in.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			line = in.readLine();
			st = new StringTokenizer(line);
			int R = Integer.parseInt(st.nextToken());
			String[] G = new String[R];
			for (int i = 0; i < G.length; i++) {
				G[i] = in.readLine();
			}

			line = in.readLine();
			st = new StringTokenizer(line);
			int r = Integer.parseInt(st.nextToken());
			String[] P = new String[r];
			for (int i = 0; i < P.length; i++) {
				P[i] = in.readLine();
			}

			System.out.println(hasPattern(G, P) ? "YES" : "NO");
		}

		in.close();
	}

	static boolean hasPattern(String[] grid, String[] pattern) {
		int patternRowLength = pattern[0].length();

		Set<String> patternSet = new HashSet<String>();
		for (String onePattern : pattern) {
			patternSet.add(onePattern);
		}

		@SuppressWarnings("unchecked")
		Map<String, Set<Integer>>[] str2indicesArray = new Map[grid.length];
		for (int i = 0; i < str2indicesArray.length; i++) {
			str2indicesArray[i] = new HashMap<String, Set<Integer>>();
			for (int j = 0; j + patternRowLength <= grid[i].length(); j++) {
				String str = grid[i].substring(j, j + patternRowLength);
				if (patternSet.contains(str)) {
					if (!str2indicesArray[i].containsKey(str)) {
						str2indicesArray[i].put(str, new HashSet<Integer>());
					}
					str2indicesArray[i].get(str).add(j);
				}
			}
		}

		for (int i = 0; i + pattern.length <= str2indicesArray.length; i++) {
			if (!merge(str2indicesArray, pattern, i).isEmpty()) {
				return true;
			}
		}
		return false;
	}

	static Set<Integer> merge(Map<String, Set<Integer>>[] str2indicesArray,
			String[] pattern, int beginRow) {
		Set<Integer> result = null;

		for (int i = beginRow; i < beginRow + pattern.length; i++) {
			if (!str2indicesArray[i].containsKey(pattern[i - beginRow])) {
				return Collections.emptySet();
			}

			Set<Integer> indices = str2indicesArray[i]
					.get(pattern[i - beginRow]);
			result = (result == null) ? indices : intersect(result, indices);
			if (result.isEmpty()) {
				break;
			}
		}
		return result;
	}

	static Set<Integer> intersect(Set<Integer> a, Set<Integer> b) {
		return a.stream().filter(elemA -> b.contains(elemA))
				.collect(Collectors.toSet());
	}
}
