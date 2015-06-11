#include <iostream>
#include <cstdio>
using namespace std;

int main() {
	const char* NAMES[] = {NULL, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	int n;
	scanf("%d", &n);
	if (n >= 1 && n <= 9) {
		printf("%s\n", NAMES[n]);
	} else {
		printf("Greater than 9\n");
	}

    return 0;
}
