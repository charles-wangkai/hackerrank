#include <iostream>
#include <cstdio>
using namespace std;

int main() {
	int i;
	long l;
	long long ll;
	char ch;
	float f;
	double d;

	scanf("%d %ld %lld %c %f %lf", &i, &l, &ll, &ch, &f, &d);
	printf("%d\n%ld\n%lld\n%c\n%f\n%lf\n", i, l, ll, ch, f, d);

    return 0;
}
