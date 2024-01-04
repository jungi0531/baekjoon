#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	long long int n, m;

	scanf("%lld %lld", &n, &m);

	printf("%lld\n", (n + m) * (n - m));

	return 0;
}

