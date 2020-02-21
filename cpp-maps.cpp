#include <iostream>
#include <map>

int main()
{
    int Q;
    std::cin >> Q;

    std::map<std::string, int> name_to_mark;

    for (int i{0}; i < Q; ++i)
    {
        int type;
        std::cin >> type;

        if (type == 1)
        {
            std::string X;
            int Y;
            std::cin >> X >> Y;

            name_to_mark[X] += Y;
        }
        else if (type == 2)
        {
            std::string X;
            std::cin >> X;

            name_to_mark.erase(X);
        }
        else if (type == 3)
        {
            std::string X;
            std::cin >> X;

            std::cout << name_to_mark[X] << "\n";
        }
    }

    return 0;
}