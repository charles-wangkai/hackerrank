#include <iostream>

void update(int *a, int *b)
{
    int sum = *a + *b;
    int diff = std::abs(*a - *b);

    *a = sum;
    *b = diff;
}

int main()
{
    int a;
    int b;
    std::cin >> a >> b;

    update(&a, &b);

    std::cout << a << "\n"
              << b << "\n";

    return 0;
}
