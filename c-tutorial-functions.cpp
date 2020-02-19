#include <iostream>

int max_of_four(int a, int b, int c, int d)
{
    return std::max(std::max(a, b), std::max(c, d));
}

int main()
{
    int a;
    int b;
    int c;
    int d;
    std::cin >> a >> b >> c >> d;

    int ans{max_of_four(a, b, c, d)};
    std::cout << ans << "\n";

    return 0;
}
