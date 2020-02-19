#include <iostream>
#include <array>

int main()
{
	std::array<std::string, 9> names{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	int n;
	std::cin >> n;
	if (n >= 1 && n <= 9)
	{
		std::cout << names[n - 1] << "\n";
	}
	else
	{
		std::cout << "Greater than 9\n";
	}

	return 0;
}
