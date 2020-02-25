#include <iostream>
#include <unordered_set>

constexpr unsigned int MOD{1u << 31};

unsigned int P;
unsigned int Q;

unsigned int move(unsigned int x)
{
    return (x * P + Q) % MOD;
}

int solve(int N, unsigned int S)
{
    unsigned int slow{move(S)};
    unsigned int fast{move(move(S))};
    int step{1};
    while (slow != fast)
    {
        if (step == N)
        {
            return N;
        }

        slow = move(slow);
        fast = move(move(fast));
        ++step;
    }

    int result{1};
    unsigned int p{S};
    while (p != slow)
    {
        ++result;
        p = move(p);
        slow = move(slow);
    }

    p = move(p);
    while (p != slow)
    {
        ++result;
        p = move(p);
    }

    return result;
}

int main()
{

    int N;
    unsigned int S;
    std::cin >> N >> S >> P >> Q;

    std::cout << solve(N, S) << "\n";

    return 0;
}