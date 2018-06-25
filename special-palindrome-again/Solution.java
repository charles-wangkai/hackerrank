import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static long solve(String s) {
		List<Block> blocks = buildBlocks(s);

		long result = 0;
		for (int i = 0; i < blocks.size(); i++) {
			result += (long) blocks.get(i).length * (blocks.get(i).length + 1) / 2;

			if (blocks.get(i).length == 1 && i > 0 && i + 1 < blocks.size()
					&& blocks.get(i - 1).letter == blocks.get(i + 1).letter) {
				result += Math.min(blocks.get(i - 1).length, blocks.get(i + 1).length);
			}
		}
		return result;
	}

	static List<Block> buildBlocks(String s) {
		List<Block> blocks = new ArrayList<>();

		char letter = 0;
		int length = -1;
		for (int i = 0; i <= s.length(); i++) {
			if (i < s.length() && s.charAt(i) == letter) {
				length++;
			} else {
				if (letter > 0) {
					blocks.add(new Block(letter, length));
				}

				if (i < s.length()) {
					letter = s.charAt(i);
					length = 1;
				}
			}
		}

		return blocks;
	}
}

class Block {
	char letter;
	int length;

	Block(char letter, int length) {
		this.letter = letter;
		this.length = length;
	}
}