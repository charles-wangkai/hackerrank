import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Customer[] customers = new Customer[n];
		for (int i = 0; i < customers.length; i++) {
			int order = sc.nextInt();
			int prep = sc.nextInt();

			customers[i] = new Customer(i + 1, order, prep);
		}
		System.out.println(
				String.join(" ", solve(customers).stream().map(Object::toString).collect(Collectors.toList())));

		sc.close();
	}

	static List<Integer> solve(Customer[] customers) {
		Arrays.sort(customers, (c1, c2) -> (c1.serve() != c2.serve()) ? Integer.compare(c1.serve(), c2.serve())
				: Integer.compare(c1.number, c2.number));

		return Arrays.stream(customers).map(customer -> customer.number).collect(Collectors.toList());
	}
}

class Customer {
	int number;
	int order;
	int prep;

	Customer(int number, int order, int prep) {
		this.number = number;
		this.order = order;
		this.prep = prep;
	}

	int serve() {
		return order + prep;
	}
}