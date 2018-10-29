#include <stdio.h>

int max_of_two(int x, int y) {
    return (x >= y) ? x : y;
}

int max_of_four(int a, int b, int c, int d) {
    return max_of_two(max_of_two(a, b), max_of_two(c, d));
}

int main() {
    int a, b, c, d;
    scanf("%d%d%d%d", &a, &b, &c, &d);

    printf("%d\n", max_of_four(a, b, c, d));
    
    return 0;
}