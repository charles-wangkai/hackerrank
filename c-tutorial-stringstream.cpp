#include <sstream>
#include <vector>
#include <iostream>
using namespace std;

vector<int> parseInts(string str) {
	vector<int> integers;
	stringstream ss(str);
	bool first = true;
	char ch;
	int integer;
	while (!ss.eof()) {
		if (!first) {
			ss >> ch;
		}
		ss >> integer;
		integers.push_back(integer);
		first = false;
	}
	return integers;
}

int main() {
    string str;
    cin >> str;
    vector<int> integers = parseInts(str);
    for(int i = 0; i < integers.size(); i++) {
        cout << integers[i] << "\n";
    }

    return 0;
}
