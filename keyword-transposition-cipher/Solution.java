import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int tc = 0; tc < N; tc++) {
			String keyword = sc.next();
			sc.nextLine();
			String ciphertext = sc.nextLine();

			Map<Character, Character> decodeMap = buildDecodeMap(keyword);
			System.out.println(ciphertext.chars().mapToObj(cipherLetter -> decodeMap.get((char) cipherLetter))
					.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
		}

		sc.close();
	}

	static Map<Character, Character> buildDecodeMap(String keyword) {
		String reducedKeyword = reduce(keyword);

		int columnNum = reducedKeyword.length();
		@SuppressWarnings("unchecked")
		List<Character>[] columns = new ArrayList[columnNum];
		for (int i = 0; i < columns.length; i++) {
			columns[i] = new ArrayList<Character>();

			columns[i].add(reducedKeyword.charAt(i));
		}

		int columnIndex = 0;
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			if (reducedKeyword.indexOf(letter) < 0) {
				columns[columnIndex].add(letter);

				columnIndex = (columnIndex + 1) % columnNum;
			}
		}

		Arrays.sort(columns, (column1, column2) -> column1.get(0) - column2.get(0));

		List<Character> encodeList = Arrays.stream(columns).collect(ArrayList<Character>::new, List<Character>::addAll,
				List<Character>::addAll);
		Map<Character, Character> decodeMap = new HashMap<Character, Character>();
		for (int i = 0; i < encodeList.size(); i++) {
			char originalLetter = (char) (i + 'A');
			decodeMap.put(encodeList.get(i), originalLetter);
		}
		decodeMap.put(' ', ' ');

		return decodeMap;
	}

	static String reduce(String str) {
		String reduced = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (reduced.indexOf(ch) < 0) {
				reduced += ch;
			}
		}
		return reduced;
	}
}
