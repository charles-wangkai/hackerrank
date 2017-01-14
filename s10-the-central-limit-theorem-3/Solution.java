import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sampleSize = sc.nextInt();
		double mean = sc.nextDouble();
		double std = sc.nextDouble();
		sc.nextDouble();
		double z = sc.nextDouble();

		System.out.printf("%.2f\n", mean - z * (std / Math.sqrt(sampleSize)));
		System.out.printf("%.2f\n", mean + z * (std / Math.sqrt(sampleSize)));

		sc.close();
	}
}
