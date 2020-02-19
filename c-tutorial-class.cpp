#include <iostream>

class Student
{
private:
	int age;
	std::string first_name;
	std::string last_name;
	int standard;

public:
	int get_age()
	{
		return age;
	}

	void set_age(int age)
	{
		this->age = age;
	}

	const std::string &get_first_name()
	{
		return first_name;
	}

	void set_first_name(const std::string &first_name)
	{
		this->first_name = first_name;
	}

	const std::string &get_last_name()
	{
		return last_name;
	}

	void set_last_name(const std::string &last_name)
	{
		this->last_name = last_name;
	}

	int get_standard()
	{
		return standard;
	}

	void set_standard(int standard)
	{
		this->standard = standard;
	}

	std::string to_string()
	{
		return std::to_string(age) + "," + first_name + "," + last_name + "," + std::to_string(standard);
	}
};

int main()
{
	int age;
	std::string first_name;
	std::string last_name;
	int standard;
	std::cin >> age >> first_name >> last_name >> standard;

	Student st;
	st.set_age(age);
	st.set_standard(standard);
	st.set_first_name(first_name);
	st.set_last_name(last_name);

	std::cout << st.get_age() << "\n";
	std::cout << st.get_last_name() << ", " << st.get_first_name() << "\n";
	std::cout << st.get_standard() << "\n";
	std::cout << "\n";
	std::cout << st.to_string() << "\n";

	return 0;
}
