
//author shafaet, shafaet@hackerrank.com
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;

@SuppressWarnings({ "rawtypes", "unchecked" })
class MapReduce {
	private LinkedHashMap intermediate;
	private JSONObject finalResult = new JSONObject();
	private int resultCount;

	MapReduce() {
		resultCount = 0;
		finalResult = new JSONObject();
		intermediate = new LinkedHashMap();
	}

	JSONObject execute(JSONObject inputdata) {
		for (int i = 0; i < inputdata.size(); i++) {
			LinkedHashMap record = (LinkedHashMap) inputdata.get(i);
			mapper(record);
		}

		Iterator it = intermediate.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			reducer((int) pair.getKey(), (HashSet) pair.getValue());
			it.remove();
		}
		return finalResult;

	}

	private void emit(LinkedHashMap obj) {
		finalResult.put(resultCount++, obj);
	}

	private void reducer(int key, HashSet value) {
		LinkedHashMap obj = new LinkedHashMap();
		obj.put("key", key);
		emit(obj);

	}

	private void mapper(LinkedHashMap record) {
		String value = (String) record.get("value");
		int key = (int) record.get("key");
		emitIntermediate(key, value); // Complete this line

	}

	private void emitIntermediate(int key, String value) {
		if (!intermediate.containsKey(key))
			intermediate.put(key, new HashSet());

		HashSet temp = (HashSet) intermediate.get(key);
		temp.add(value);
		intermediate.put(key, temp);
	}
}

@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
public class Solution {

	public static void main(String[] argh) {
		JSONObject inputdata = new JSONObject();
		Scanner sc = new Scanner(System.in);
		int Nr = sc.nextInt();
		int Ns = sc.nextInt();
		int[] R = new int[Nr];
		int[] S = new int[Ns];
		int c = 0;
		for (int i = 0; i < Nr; i++) {

			Map obj = new LinkedHashMap();
			R[i] = sc.nextInt();
			obj.put("value", "R");
			obj.put("key", R[i]);
			inputdata.put(c, obj);
			c++;
		}

		for (int i = 0; i < Ns; i++) {
			Map obj = new LinkedHashMap();
			S[i] = sc.nextInt();
			obj.put("value", "S");
			obj.put("key", S[i]);
			inputdata.put(c, obj);
			c++;
		}

		MapReduce mapred = new MapReduce();
		JSONObject result = mapred.execute(inputdata);

		for (int i = 0; i < result.size(); i++) {
			LinkedHashMap record = (LinkedHashMap) result.get(i);
			System.out.println(record.get("key"));

		}

	}

}
