#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int lcd(int a, int b) {
    // a > b 라고 가정
    int c = a % b;

    if (c == 0) {
        return b;
    }

    if (b % c == 0) {
        return c;
    }
    else {
        return lcd(b, c);
    }
}

int main() {
    int t;

    scanf("%d", &t);

    int a, b;
    for (int i = 0; i < t; i++) {
        scanf("%d %d", &a, &b);

        printf("%d\n", a * b / lcd(b, a));
    }

    return 0;
}