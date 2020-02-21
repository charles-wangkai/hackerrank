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

    int Q;
    std::cin >> Q;

    for (int i{0}; i < Q; ++i)
    {
        int Y;
        std::cin >> Y;

        auto it{std::lower_bound(v.begin(), v.end(), Y)};

        std::cout << ((it != v.end() && *it == Y) ? "Yes" : "No") << " " << it - v.begin() + 1 << "\n";
    }

    return 0;
}