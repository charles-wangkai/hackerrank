#include <iostream>
#include <cstdio>
using namespace std;

int main() {
	const char* NAMES[] = {NULL, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	int a;
	int b;
	scanf("%d%d", &a, &b);
	for (int n = a; n <= b; n++) {
		if (n >= 1 && n <= 9) {
			printf("%s\n", NAMES[n]);
		} else if (n % 2 == 0) {
			printf("even\n");
		} else {
			printf("odd\n");
		}
	}

    return 0;
}
