import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
	static final int MODULUS = 1000000007;

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			line = in.readLine();
			st = new StringTokenizer(line);

			BigInteger A = new BigInteger(st.nextToken());
			BigInteger B = new BigInteger(st.nextToken());

			System.out.println(solve(A, B));
		}
	}

	static int solve(BigInteger A, BigInteger B) {
		return A.modPow(B, BigInteger.valueOf(MODULUS)).intValue();
	}
}
