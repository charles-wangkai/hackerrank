import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
	static final int[] R_OFFSETS = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int rq = sc.nextInt();
		int cq = sc.nextInt();
		Set<Position> obstacles = new HashSet<Position>();
		for (int i = 0; i < k; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			obstacles.add(new Position(r, c));
		}

		System.out.println(solve(n, rq, cq, obstacles));

		sc.close();
	}

	static int solve(int n, int rq, int cq, Set<Position> obstacles) {
		return IntStream.range(0, R_OFFSETS.length).map(i -> attack(n, rq, cq, R_OFFSETS[i], C_OFFSETS[i], obstacles))
				.sum();
	}

	static int attack(int n, int rq, int cq, int rOffset, int cOffset, Set<Position> obstacles) {
		int result = 0;
		while (true) {
			rq += rOffset;
			cq += cOffset;

			if (!(rq >= 1 && rq <= n && cq >= 1 && cq <= n) || obstacles.contains(new Position(rq, cq))) {
				break;
			}

			result++;
		}
		return result;
	}
}

class Position {
	int r;
	int c;

	Position(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public int hashCode() {
		return r * c;
	}

	@Override
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		return r == other.r && c == other.c;
	}
}