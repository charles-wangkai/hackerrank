import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
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

	private void reducer(String key, ArrayList value) {
		// Complete the line below by filling up the question marks
		int total = (int) value.stream().mapToInt(x -> (int) x).count();
		LinkedHashMap obj = new LinkedHashMap();
		obj.put("key", key);
		obj.put("value", total);
		emit(obj);

	}

	private void mapper(JSONObject record) {
		String value = (String) record.get("value");
		int key = (int) record.get("key");

		for (String word : value.split(" ")) {
			// Complete the line below by filling up the question marks
			emitIntermediate(word, 1);
		}

	}

	private void emitIntermediate(String key, int value) {
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
			if (line.length() == 0)
				continue;
			Map obj = new JSONObject();
			obj.put("key", linecount);
			obj.put("value", line);

			inputdata.put(linecount++, obj);
		}
		MapReduce mapred = new MapReduce();
		JSONObject result = mapred.execute(inputdata);

		for (int i = 0; i < result.size(); i++) {
			LinkedHashMap record = (LinkedHashMap) result.get(i);
			String key = (String) record.get("key");
			int value = (int) record.get("value");
			System.out.println("{\"key\":\"" + key + "\",\"value\":" + value + "}");

		}

	}

}
