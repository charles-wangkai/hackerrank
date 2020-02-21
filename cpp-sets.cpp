#include <iostream>
#include <set>

int main()
{
    int Q;
    std::cin >> Q;

    std::set<int> s;

    for (int i{0}; i < Q; ++i)
    {
        int y;
        int x;
        std::cin >> y >> x;

        if (y == 1)
        {
            s.insert(x);
        }
        else if (y == 2)
        {
            s.erase(x);
        }
        else
        {
            std::cout << ((s.count(x) == 1) ? "Yes" : "No") << "\n";
        }
    }

    return 0;
}