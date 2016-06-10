
//Author Shafaet, Shafaet@hackerrank.com
import java.util.ArrayList;
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
			JSONObject record = (JSONObject) inputdata.get(i);
			mapper(record);
		}

		Iterator it = intermediate.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			reducer((String) pair.getKey(), (ArrayList) pair.getValue());
			it.remove();
		}
		return finalResult;

	}

	private void emit(LinkedHashMap obj) {
		finalResult.put(resultCount++, obj);
	}

	private <T> void reducer(T key, ArrayList value) {
		LinkedHashMap obj = new LinkedHashMap();
		obj.put("key", key);
		// ??? Complete this line
		double population = value.stream().mapToDouble(x -> (double) x).sum();
		obj.put("value", Math.round(population));
		emit(obj);

	}

	private void mapper(JSONObject record) {
		String state = (String) record.get("key");
		double population = Double.parseDouble((String) record.get("value"));
		// Complete the line below
		emitIntermediate(state, population);

	}

	private <T1, T2> void emitIntermediate(T1 key, T2 value) {
		if (!intermediate.containsKey(key))
			intermediate.put(key, new ArrayList());

		ArrayList temp = (ArrayList) intermediate.get(key);
		temp.add(value);
		intermediate.put(key, temp);
	}
}

@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
public class Main {

	public static void main(String[] argh) {
		JSONObject inputdata = new JSONObject();
		Scanner sc = new Scanner(System.in);

		int linecount = 0;
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] temp = line.split("\t");
			Map obj = new JSONObject();
			obj.put("key", temp[0] + "," + temp[1]);
			obj.put("value", temp[3]);

			inputdata.put(linecount++, obj);
		}
		MapReduce mapred = new MapReduce();
		JSONObject result = mapred.execute(inputdata);

		for (int i = 0; i < result.size(); i++) {
			LinkedHashMap record = (LinkedHashMap) result.get(i);
			String key = (String) record.get("key");
			long value = (long) record.get("value");

			System.out.println("{\"key\":\"" + key + "\",\"value\":" + value + "}");

		}

	}

}
