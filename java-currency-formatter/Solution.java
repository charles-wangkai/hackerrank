import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
	static final CountryInfo[] COUNTRY_INFOS = { new CountryInfo("en", "US", "US"),
			new CountryInfo("en", "IN", "India") };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double payment = sc.nextDouble();
		for (CountryInfo countryInfo : COUNTRY_INFOS) {
			System.out.printf("%s format = %s\n", countryInfo.name, NumberFormat
					.getCurrencyInstance(new Locale(countryInfo.language, countryInfo.country)).format(payment));
		}

		sc.close();
	}
}

class CountryInfo {
	String language;
	String country;
	String name;

	CountryInfo(String language, String country, String name) {
		this.language = language;
		this.country = country;
		this.name = name;
	}
}