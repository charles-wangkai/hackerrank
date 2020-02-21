#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    int T;
    cin >> T;
    cout << setiosflags(ios::uppercase);
    cout << setw(0xf) << internal;
    while (T--)
    {
        double A;
        cin >> A;
        double B;
        cin >> B;
        double C;
        cin >> C;

        /* Enter your code here */
        std::cout << std::nouppercase << std::setw(0) << std::hex << std::showbase << static_cast<long long>(A) << "\n";
        std::cout << std::showpos << std::setw(15) << std::setfill('_') << std::right << std::fixed << std::setprecision(2) << B << "\n";
        std::cout << std::uppercase << std::noshowpos << std::scientific << std::setprecision(9) << C << "\n";
    }
    return 0;
}