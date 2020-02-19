#include <iostream>
#include <array>

int main()
{
	std::array<std::string, 9> names{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	int a;
	int b;
	std::cin >> a >> b;
	for (int n = a; n <= b; n++)
	{
		if (n >= 1 && n <= 9)
		{
			std::cout << names[n - 1] << "\n";
		}
		else if (n % 2 == 0)
		{
			std::cout << "even\n";
		}
		else
		{
			std::cout << "odd\n";
		}
	}

	return 0;
}
