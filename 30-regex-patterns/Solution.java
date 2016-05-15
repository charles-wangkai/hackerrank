import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static final String EMAIL_REGEX = ".*@gmail.com$";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Email[] emails = new Email[N];
		for (int i = 0; i < emails.length; i++) {
			String firstName = sc.next();
			String emailId = sc.next();
			emails[i] = new Email(firstName, emailId);
		}

		Arrays.stream(emails).filter(email -> email.emailId.matches(EMAIL_REGEX))
				.sorted((email1, email2) -> email1.firstName.compareTo(email2.firstName))
				.forEach(email -> System.out.println(email.firstName));

		sc.close();
	}
}

class Email {
	String firstName;
	String emailId;

	Email(String firstName, String emailId) {
		this.firstName = firstName;
		this.emailId = emailId;
	}
}