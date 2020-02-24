#include <bits/stdc++.h>

using namespace std;

//Define the structs Workshops and Available_Workshops.
//Implement the functions initialize and CalculateMaxWorkshops
struct Workshop
{
    int start_time;
    int end_time;
};

struct Available_Workshops
{
    std::vector<Workshop> workshops;
};

Available_Workshops *initialize(int start_time[], int duration[], int n)
{
    Available_Workshops *result{new Available_Workshops};
    for (int i{0}; i < n; ++i)
    {
        result->workshops.push_back(Workshop{start_time[i], start_time[i] + duration[i] - 1});
    }

    return result;
}

int CalculateMaxWorkshops(Available_Workshops *p)
{
    std::sort(p->workshops.begin(), p->workshops.end(), [](const auto &w1, const auto &w2) { return w1.end_time < w2.end_time; });

    std::vector<int> nums(p->workshops.size());
    for (int i{0}; i < nums.size(); ++i)
    {
        auto last_index{std::lower_bound(p->workshops.begin(), p->workshops.begin() + i, p->workshops[i].start_time, [](const auto &w, int target) { return w.end_time < target; }) - p->workshops.begin() - 1};
        nums[i] = ((last_index >= 0) ? nums[last_index] : 0) + 1;

        if (i != 0)
        {
            nums[i] = std::max(nums[i], nums[i - 1]);
        }
    }

    return nums[nums.size() - 1];
}

int main(int argc, char *argv[])
{
    int n; // number of workshops
    cin >> n;
    // create arrays of unknown size n
    int *start_time = new int[n];
    int *duration = new int[n];

    for (int i = 0; i < n; i++)
    {
        cin >> start_time[i];
    }
    for (int i = 0; i < n; i++)
    {
        cin >> duration[i];
    }

    Available_Workshops *ptr;
    ptr = initialize(start_time, duration, n);
    cout << CalculateMaxWorkshops(ptr) << endl;
    return 0;
}
