import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(new myRegex().pattern));
		}
		in.close();
	}
}

class myRegex {
	private String part = "((25[0-5])|(2[0-4][0-9])|([0-1]{0,1}[0-9]{1,2}))";
	String pattern = String.format("%s\\.%s\\.%s\\.%s", part, part, part, part);
}