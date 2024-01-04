#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


int main(void) {

	int n, m;

	scanf("%d %d", &n, &m);

	printf("%d\n", (n + m) * (n - m));

	return 0;
}

