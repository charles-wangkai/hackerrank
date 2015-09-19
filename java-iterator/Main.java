import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static Iterator<Object> func(ArrayList<Object> mylist) {
		Iterator<Object> it = mylist.iterator();
		while (it.hasNext()) {
			Object element = it.next();
			if (element instanceof String) // Hints: use instanceof operator
				break;
		}
		return it;

	}

	public static void main(String[] argh) {
		ArrayList<Object> mylist = new ArrayList<Object>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			mylist.add(sc.nextInt());
		}
		mylist.add("###");
		for (int i = 0; i < m; i++) {
			mylist.add(sc.next());
		}

		Iterator<Object> it = func(mylist);
		while (it.hasNext()) {
			Object element = it.next();
			System.out.println((String) element);
		}

		sc.close();
	}
}
