#include <iostream>
#include <iomanip>

int main()
{
	int i;
	long l;
	char ch;
	float f;
	double d;
	std::cin >> i >> l >> ch >> f >> d;

	std::cout << i << "\n"
			  << l << "\n"
			  << ch << "\n"
			  << std::fixed << std::setprecision(3) << f << "\n"
			  << std::fixed << std::setprecision(9) << d << "\n";

	return 0;
}
