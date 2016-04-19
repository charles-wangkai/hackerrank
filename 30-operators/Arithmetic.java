import java.util.Scanner;

public class Arithmetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double mealCost = sc.nextDouble();
		int tipPercent = sc.nextInt();
		int taxPercent = sc.nextInt();

		int totalCost = (int) Math.round(mealCost + mealCost * tipPercent / 100 + mealCost * taxPercent / 100);
		System.out.println("The total meal cost is " + totalCost + " dollars.");

		sc.close();
	}
}
