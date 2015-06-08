import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Solution {
	static Map<Class, String> type2name = new LinkedHashMap<Class, String>();
	static {
		type2name.put(Byte.class, "byte");
		type2name.put(Short.class, "short");
		type2name.put(Integer.class, "int");
		type2name.put(Long.class, "long");
	}

	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String number = in.next();

			List<String> fittedTypes = new ArrayList<String>();
			for (Entry<Class, String> entry : type2name.entrySet()) {
				Class type = entry.getKey();
				String name = entry.getValue();

				try {
					type.getMethod("valueOf", String.class)
							.invoke(null, number);
				} catch (Exception e) {
					continue;
				}

				fittedTypes.add(name);
			}

			if (fittedTypes.isEmpty()) {
				System.out.println(number + " can't be fitted anywhere.");
			} else {
				System.out.println(number + " can be fitted in:");
				for (String fittedType : fittedTypes) {
					System.out.println("* " + fittedType);
				}
			}
		}
		in.close();
	}
}
