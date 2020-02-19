#include <iostream>
#include <vector>

int main()
{
    int N;
    std::cin >> N;

    std::vector<int> A(N);
    for (int &x : A)
    {
        std::cin >> x;
    }

    for (auto it{A.rbegin()}; it != A.rend(); ++it)
    {
        std::cout << *it << " ";
    }

    return 0;
}