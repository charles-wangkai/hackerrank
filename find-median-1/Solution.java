import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		MedianFinder medianFinder = new MedianFinder();
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			int number = in.nextInt();
			medianFinder.add(number);
			System.out.printf("%.1f\n", medianFinder.getMedian());
		}

		in.close();
	}
}

class MedianFinder {
	private Heap lowerHeap = new Heap((parent, child) -> parent >= child);
	private Heap upperHeap = new Heap((parent, child) -> parent <= child);

	public void add(int number) {
		if (lowerHeap.size() > 0 && number <= lowerHeap.top()) {
			lowerHeap.add(number);
		} else {
			upperHeap.add(number);
		}

		if (lowerHeap.size() - upperHeap.size() == 2) {
			upperHeap.add(lowerHeap.removeTop());
		} else if (upperHeap.size() - lowerHeap.size() == 2) {
			lowerHeap.add(upperHeap.removeTop());
		}
	}

	public double getMedian() {
		if (lowerHeap.size() > upperHeap.size()) {
			return lowerHeap.top();
		} else if (upperHeap.size() > lowerHeap.size()) {
			return upperHeap.top();
		} else {
			return (lowerHeap.top() + upperHeap.top()) / 2.0;
		}
	}
}

class Heap {
	private ParentChildComparator parentChildComparator;
	private List<Integer> numbers;

	public Heap(ParentChildComparator parentChildComparator) {
		this.parentChildComparator = parentChildComparator;
		numbers = new ArrayList<Integer>();
	}

	private void swap(int index1, int index2) {
		int temp = numbers.get(index1);
		numbers.set(index1, numbers.get(index2));
		numbers.set(index2, temp);
	}

	public void add(int number) {
		numbers.add(number);

		int childIndex = numbers.size() - 1;
		while (true) {
			int parentIndex = (childIndex - 1) / 2;

			if (parentIndex < 0
					|| parentChildComparator.compare(numbers.get(parentIndex),
							numbers.get(childIndex))) {
				break;
			}

			swap(parentIndex, childIndex);
			childIndex = parentIndex;
		}
	}

	public int removeTop() {
		int top = top();

		swap(0, numbers.size() - 1);
		numbers.remove(numbers.size() - 1);

		int parentIndex = 0;
		while (true) {
			int leftChildIndex = parentIndex * 2 + 1;
			int rightChildIndex = parentIndex * 2 + 2;

			if ((leftChildIndex >= numbers.size() || parentChildComparator
					.compare(numbers.get(parentIndex),
							numbers.get(leftChildIndex)))
					&& (rightChildIndex >= numbers.size() || parentChildComparator
							.compare(numbers.get(parentIndex),
									numbers.get(rightChildIndex)))) {
				break;
			}

			int childIndex;
			if (rightChildIndex >= numbers.size()
					|| parentChildComparator.compare(
							numbers.get(leftChildIndex),
							numbers.get(rightChildIndex))) {
				childIndex = leftChildIndex;
			} else {
				childIndex = rightChildIndex;
			}
			swap(parentIndex, childIndex);
			parentIndex = childIndex;
		}

		return top;
	}

	public int size() {
		return numbers.size();
	}

	public int top() {
		return numbers.get(0);
	}
}

@FunctionalInterface
interface ParentChildComparator {
	boolean compare(int parent, int child);
}
