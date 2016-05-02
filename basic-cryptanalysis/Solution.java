import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	static final String DICTIONARY_FILE_PATH = "dictionary.lst";

	public static void main(String[] args) throws Throwable {
		List<String> dictionary = readDictionary();
		List<String> cipherWords = readCiphertext();

		Map<Character, Character> decodeMap = new HashMap<Character, Character>();
		decode(dictionary, cipherWords, decodeMap);

		System.out.println(String.join(" ", cipherWords.stream().map(cipherWord -> decodeWord(decodeMap, cipherWord))
				.collect(Collectors.toList())));
	}

	static boolean decode(List<String> dictionary, List<String> cipherWords, Map<Character, Character> decodeMap) {
		boolean allDone = true;

		String chosenCipherWord = null;
		List<String> chosenMatchedDictionary = null;

		for (String cipherWord : cipherWords) {
			if (!isAllMapped(cipherWord, decodeMap)) {
				allDone = false;

				List<String> matchedDictionary = match(cipherWord, dictionary, decodeMap);
				if (chosenMatchedDictionary == null || matchedDictionary.size() < chosenMatchedDictionary.size()) {
					chosenCipherWord = cipherWord;
					chosenMatchedDictionary = matchedDictionary;
				}
			}
		}

		if (allDone) {
			return true;
		}

		if (chosenMatchedDictionary.isEmpty()) {
			return false;
		}

		for (String chosenMatchedDictionaryWord : chosenMatchedDictionary) {
			Map<Character, Character> addedDecodeMap = buildAddedDecodeMap(chosenCipherWord,
					chosenMatchedDictionaryWord, decodeMap);

			decodeMap.putAll(addedDecodeMap);
			if (decode(dictionary, cipherWords, decodeMap)) {
				return true;
			}
			for (char addedKey : addedDecodeMap.keySet()) {
				decodeMap.remove(addedKey);
			}
		}
		return false;
	}

	static List<String> match(String cipherWord, List<String> dictionary, Map<Character, Character> decodeMap) {
		return dictionary.stream().filter(dictionaryWord -> isMapped(cipherWord, dictionaryWord, decodeMap))
				.collect(Collectors.toList());
	}

	static boolean isMapped(String cipherWord, String dictionaryWord, Map<Character, Character> decodeMap) {
		if (cipherWord.length() != dictionaryWord.length()) {
			return false;
		}

		for (int i = 0; i < cipherWord.length(); i++) {
			char cipherLetter = cipherWord.charAt(i);

			if (decodeMap.containsKey(cipherLetter) && decodeMap.get(cipherLetter) != dictionaryWord.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	static Map<Character, Character> buildAddedDecodeMap(String cipherWord, String dictionaryWord,
			Map<Character, Character> decodeMap) {
		Map<Character, Character> addedDecodeMap = new HashMap<Character, Character>();
		for (int i = 0; i < cipherWord.length(); i++) {
			char cipherLetter = cipherWord.charAt(i);

			if (decodeMap.containsKey(cipherLetter)) {
				continue;
			}

			addedDecodeMap.put(cipherLetter, dictionaryWord.charAt(i));
		}
		return addedDecodeMap;
	}

	static boolean isAllMapped(String cipherWord, Map<Character, Character> decodeMap) {
		return cipherWord.chars().allMatch(letter -> decodeMap.containsKey((char) letter));
	}

	static String decodeWord(Map<Character, Character> decodeMap, String cipherWord) {
		return cipherWord.chars().mapToObj(cipherLetter -> decodeMap.get((char) cipherLetter))
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}

	static List<String> readCiphertext() {
		List<String> cipherWords = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			cipherWords.add(sc.next());
		}
		sc.close();

		return cipherWords;
	}

	static List<String> readDictionary() throws Throwable {
		List<String> dictionary = new ArrayList<String>();

		Scanner sc = new Scanner(new File(DICTIONARY_FILE_PATH));
		while (sc.hasNext()) {
			dictionary.add(sc.next().toLowerCase());
		}
		sc.close();

		return dictionary;
	}
}
