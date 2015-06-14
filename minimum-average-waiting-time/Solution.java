import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		Customer[] customers = new Customer[N];
		for (int i = 0; i < customers.length; i++) {
			int orderTime = in.nextInt();
			int cookTime = in.nextInt();
			customers[i] = new Customer(orderTime, cookTime);
		}
		Arrays.sort(customers, (c1, c2) -> c1.orderTime - c2.orderTime);

		MinHeap waitings = new MinHeap();
		long currentTime = 0;
		long totalWaitingTime = 0;
		int index = 0;
		while (!waitings.isEmpty() || index < customers.length) {
			while (index < customers.length
					&& customers[index].orderTime <= currentTime) {
				waitings.add(customers[index]);
				index++;
			}
			if (waitings.isEmpty()) {
				currentTime = customers[index].orderTime;
				continue;
			}

			Customer served = waitings.removeTop();
			currentTime += served.cookTime;
			totalWaitingTime += currentTime - served.orderTime;
		}
		System.out.println(totalWaitingTime / customers.length);

		in.close();
	}
}

class Customer {
	int orderTime;
	int cookTime;

	Customer(int orderTime, int cookTime) {
		this.orderTime = orderTime;
		this.cookTime = cookTime;
	}
}

class MinHeap {
	List<Customer> customers = new ArrayList<Customer>();

	private void swap(int index1, int index2) {
		Customer temp = customers.get(index1);
		customers.set(index1, customers.get(index2));
		customers.set(index2, temp);
	}

	void add(Customer customer) {
		customers.add(customer);

		int childIndex = customers.size() - 1;
		while (true) {
			int parentIndex = (childIndex - 1) / 2;

			if (parentIndex < 0
					|| customers.get(parentIndex).cookTime <= customers
							.get(childIndex).cookTime) {
				break;
			}

			swap(parentIndex, childIndex);
			childIndex = parentIndex;
		}
	}

	Customer removeTop() {
		Customer top = customers.get(0);

		swap(0, customers.size() - 1);
		customers.remove(customers.size() - 1);

		int parentIndex = 0;
		while (true) {
			int leftChildIndex = parentIndex * 2 + 1;
			int rightChildIndex = parentIndex * 2 + 2;

			if ((leftChildIndex >= customers.size() || customers
					.get(parentIndex).cookTime <= customers.get(leftChildIndex).cookTime)
					&& (rightChildIndex >= customers.size() || customers
							.get(parentIndex).cookTime <= customers
							.get(rightChildIndex).cookTime)) {
				break;
			}

			int childIndex;
			if (rightChildIndex >= customers.size()
					|| customers.get(leftChildIndex).cookTime <= customers
							.get(rightChildIndex).cookTime) {
				childIndex = leftChildIndex;
			} else {
				childIndex = rightChildIndex;
			}
			swap(parentIndex, childIndex);
			parentIndex = childIndex;
		}

		return top;
	}

	boolean isEmpty() {
		return customers.isEmpty();
	}
}
