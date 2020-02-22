#include <iostream>

class Triangle
{
public:
    void triangle()
    {
        std::cout << "I am a triangle\n";
    }
};

class Isosceles : public Triangle
{
public:
    void isosceles()
    {
        std::cout << "I am an isosceles triangle\n";
    }
};

//Write your code here.
class Equilateral : public Isosceles
{
public:
    void equilateral()
    {
        std::cout << "I am an equilateral triangle\n";
    }
};

int main()
{

    Equilateral eqr;
    eqr.equilateral();
    eqr.isosceles();
    eqr.triangle();

    return 0;
}
