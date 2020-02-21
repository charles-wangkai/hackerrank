#include <iostream>
#include <vector>

int main()
{
    int N;
    std::cin >> N;

    std::vector<int> v(N);
    for (int &vi : v)
    {
        std::cin >> vi;
    }

    int x;
    std::cin >> x;

    v.erase(v.begin() + x - 1);

    int a;
    int b;
    std::cin >> a >> b;

    v.erase(v.begin() + a - 1, v.begin() + b - 1);

    std::cout << v.size() << "\n";
    for (int vi : v)
    {
        std::cout << vi << " ";
    }

    return 0;
}