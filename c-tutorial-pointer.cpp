#include <stdio.h>
#include <stdlib.h>

void update(int *a,int *b) {
    int sum = *a + *b;
    int absDiff = abs(*a - *b);
    *a = sum;
    *b = absDiff;
}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;

    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}
