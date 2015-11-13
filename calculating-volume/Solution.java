import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Permission;

class Calculate {
	BufferedReader br;
	Output output = new Output();

	Calculate() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	int getINTVal() throws NumberFormatException, IOException {
		int value = Integer.parseInt(br.readLine());
		if (value <= 0) {
			throwNumberFormatException();
		}
		return value;
	}

	double getDoubleVal() throws NumberFormatException, IOException {
		double value = Double.parseDouble(br.readLine());
		if (value <= 0) {
			throwNumberFormatException();
		}
		return value;
	}

	void throwNumberFormatException() {
		throw new NumberFormatException("All the values must be positive");
	}

	static Volume get_Vol() {
		return new Volume();
	}
}

class Volume {
	double main(int a) {
		return a * a * a;
	}

	double main(int l, int b, int h) {
		return l * b * h;
	}

	double main(double r) {
		return Math.PI * r * r * r * 2 / 3;
	}

	double main(double r, double h) {
		return Math.PI * r * r * h;
	}
}

class Output {
	void display(double volume) {
		System.out.printf("%.3f\n", volume);
	}
}

public class Solution {

	public static void main(String[] args) {
		Do_Not_Terminate.forbidExit();
		try {
			Calculate cal = new Calculate();
			int T = cal.getINTVal();
			while (T-- > 0) {
				double volume = 0.0d;
				int ch = cal.getINTVal();
				if (ch == 1) {

					int a = cal.getINTVal();
					volume = Calculate.get_Vol().main(a);

				} else if (ch == 2) {

					int l = cal.getINTVal();
					int b = cal.getINTVal();
					int h = cal.getINTVal();
					volume = Calculate.get_Vol().main(l, b, h);

				} else if (ch == 3) {

					double r = cal.getDoubleVal();
					volume = Calculate.get_Vol().main(r);

				} else if (ch == 4) {

					double r = cal.getDoubleVal();
					double h = cal.getDoubleVal();
					volume = Calculate.get_Vol().main(r, h);

				}
				cal.output.display(volume);
			}

		} catch (NumberFormatException e) {
			System.out.print(e);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}

	}
}

/**
 * This class prevents the user from using System.exit(0) from terminating the
 * program abnormally.
 */
class Do_Not_Terminate {

	@SuppressWarnings("serial")
	public static class ExitTrappedException extends SecurityException {
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}// end of Do_Not_Terminate
