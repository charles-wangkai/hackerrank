#define foreach(v, i) for (int i{0}; i < v.size(); ++i)
#define toStr(x) #x
#define io(x) std::cin >> x
#define FUNCTION(f, op)     \
    void f(int &res, int x) \
    {                       \
        if (x op res)       \
        {                   \
            res = x;        \
        }                   \
    }
#define INF 200'000'000

#include <iostream>
#include <vector>
using namespace std;

#if !defined toStr || !defined io || !defined FUNCTION || !defined INF
#error Missing preprocessor definitions
#endif

FUNCTION(minimum, <)
FUNCTION(maximum, >)

int main()
{
    int n;
    cin >> n;
    vector<int> v(n);
    foreach (v, i)
    {
        io(v)[i];
    }
    int mn = INF;
    int mx = -INF;
    foreach (v, i)
    {
        minimum(mn, v[i]);
        maximum(mx, v[i]);
    }
    int ans = mx - mn;
    cout << toStr(Result =) << ' ' << ans;
    return 0;
}