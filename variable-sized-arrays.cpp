#include <iostream>
#include <vector>

int main()
{
    int n;
    int q;
    std::cin >> n >> q;

    std::vector<std::vector<int>> a(n);
    for (auto &ai : a)
    {
        int k;
        std::cin >> k;

        ai.resize(k);

        for (int &x : ai)
        {
            std::cin >> x;
        }
    }

    for (int tc{0}; tc < q; ++tc)
    {
        int i;
        int j;
        std::cin >> i >> j;

        std::cout << a[i][j] << "\n";
    }

    return 0;
}