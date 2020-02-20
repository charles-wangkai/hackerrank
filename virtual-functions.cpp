#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Person
{
protected:
    std::string name;
    int age;

public:
    virtual void getdata() = 0;
    virtual void putdata() = 0;
};

class Professor : public Person
{
private:
    static int cur_id;

    int id;
    int publications;

public:
    virtual void getdata()
    {
        id = cur_id;
        ++cur_id;

        std::cin >> name >> age >> publications;
    }

    virtual void putdata()
    {
        std::cout << name << " " << age << " " << publications << " " << id << "\n";
    }
};
int Professor::cur_id{1};

class Student : public Person
{
private:
    static int cur_id;

    int id;
    std::vector<int> marks;

public:
    virtual void getdata()
    {
        id = cur_id;
        ++cur_id;

        std::cin >> name >> age;
        for (int i{0}; i < 6; ++i)
        {
            int mark;
            std::cin >> mark;

            marks.push_back(mark);
        }
    }

    virtual void putdata()
    {
        int markSum{0};
        for (int mark : marks)
        {
            markSum += mark;
        }

        std::cout << name << " " << age << " " << markSum << " " << id << "\n";
    }
};
int Student::cur_id{1};

int main()
{

    int n, val;
    cin >> n; //The number of objects that is going to be created.
    Person *per[n];

    for (int i = 0; i < n; i++)
    {

        cin >> val;
        if (val == 1)
        {
            // If val is 1 current object is of type Professor
            per[i] = new Professor;
        }
        else
            per[i] = new Student; // Else the current object is of type Student

        per[i]->getdata(); // Get the data from the user.
    }

    for (int i = 0; i < n; i++)
        per[i]->putdata(); // Print the required output for each object.

    return 0;
}
