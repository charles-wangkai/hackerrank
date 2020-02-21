#include <iostream>
#include <vector>
#include <deque>

void solve(const std::vector<int> &A, int K)
{
    std::deque<int> q;
    int begin_index{0};
    for (int end_index{0}; end_index < A.size(); ++end_index)
    {
        while (!q.empty() && q.back() < A[end_index])
        {
            q.pop_back();
        }
        q.push_back(A[end_index]);

        if (end_index - begin_index == K)
        {
            if (!q.empty() && q.front() == A[begin_index])
            {
                q.pop_front();
            }

            ++begin_index;
        }

        if (end_index - begin_index + 1 == K)
        {
            std::cout << q.front() << " ";
        }
    }
    std::cout << "\n";
}

int main()
{
    int T;
    std::cin >> T;

    for (int tc{0}; tc < T; ++tc)
    {
        int N;
        int K;
        std::cin >> N >> K;

        std::vector<int> A(N);
        for (int &Ai : A)
        {
            std::cin >> Ai;
        }

        solve(A, K);
    }

    return 0;
}