#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Matrix
{
public:
    std::vector<std::vector<int>> a;
};

Matrix operator+(const Matrix &m1, const Matrix &m2)
{
    Matrix result;
    for (int i{0}; i < m1.a.size(); ++i)
    {
        std::vector<int> row;
        for (int j{0}; j < m1.a[i].size(); ++j)
        {
            row.push_back(m1.a[i][j] + m2.a[i][j]);
        }

        result.a.push_back(row);
    }

    return result;
}

int main()
{
    int cases, k;
    cin >> cases;
    for (k = 0; k < cases; k++)
    {
        Matrix x;
        Matrix y;
        Matrix result;
        int n, m, i, j;
        cin >> n >> m;
        for (i = 0; i < n; i++)
        {
            vector<int> b;
            int num;
            for (j = 0; j < m; j++)
            {
                cin >> num;
                b.push_back(num);
            }
            x.a.push_back(b);
        }
        for (i = 0; i < n; i++)
        {
            vector<int> b;
            int num;
            for (j = 0; j < m; j++)
            {
                cin >> num;
                b.push_back(num);
            }
            y.a.push_back(b);
        }
        result = x + y;
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < m; j++)
            {
                cout << result.a[i][j] << " ";
            }
            cout << endl;
        }
    }
    return 0;
}
