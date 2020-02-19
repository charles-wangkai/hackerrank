#include <sstream>
#include <vector>
#include <iostream>

std::vector<int> parseInts(std::string str)
{
	std::vector<int> result;
	std::stringstream ss{str};
	while (ss)
	{
		int x;
		ss >> x;
		result.push_back(x);

		ss.get();
	}

	return result;
}

int main()
{
	std::string str;
	std::cin >> str;
	std::vector<int> integers{parseInts(str)};
	for (int x : integers)
	{
		std::cout << x << "\n";
	}

	return 0;
}
