#include <iostream>
using namespace std;
enum class Fruit
{
    apple,
    orange,
    pear
};
enum class Color
{
    red,
    green,
    orange
};

template <typename T>
struct Traits;

template <>
struct Traits<Fruit>
{
    static std::string name(int index)
    {
        if (index == static_cast<int>(Fruit::apple))
        {
            return "apple";
        }
        else if (index == static_cast<int>(Fruit::orange))
        {
            return "orange";
        }
        else if (index == static_cast<int>(Fruit::pear))
        {
            return "pear";
        }
        else
        {
            return "unknown";
        }
    }
};

template <>
struct Traits<Color>
{
    static std::string name(int index)
    {
        if (index == static_cast<int>(Color::red))
        {
            return "red";
        }
        else if (index == static_cast<int>(Color::green))
        {
            return "green";
        }
        else if (index == static_cast<int>(Color::orange))
        {
            return "orange";
        }
        else
        {
            return "unknown";
        }
    }
};

int main()
{
    int t = 0;
    std::cin >> t;

    for (int i = 0; i != t; ++i)
    {
        int index1;
        std::cin >> index1;
        int index2;
        std::cin >> index2;
        cout << Traits<Color>::name(index1) << " ";
        cout << Traits<Fruit>::name(index2) << "\n";
    }
}
