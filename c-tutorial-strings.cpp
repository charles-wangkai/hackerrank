#include <iostream>
#include <string>

int main()
{
	std::string a;
	std::string b;
	std::cin >> a >> b;

	std::cout << a.size() << " " << b.size() << "\n";
	std::cout << a + b << "\n";
	std::cout << b[0] + a.substr(1) << " " << a[0] + b.substr(1) << "\n";

	return 0;
}
