#include <iostream>
#include <vector>
#include <algorithm>

int main()
{
    int N;
    std::cin >> N;

    std::vector<int> V(N);
    for (auto &x : V)
    {
        std::cin >> x;
    }

    std::sort(V.begin(), V.end());

    for (const auto &x : V)
    {
        std::cout << x << " ";
    }

    return 0;
}