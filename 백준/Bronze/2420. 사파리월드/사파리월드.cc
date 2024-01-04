#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	long long int n, m;

	scanf("%lld %lld", &n, &m);

	if (n - m < 0) printf("%lld\n", -(n - m));
	else printf("%lld\n", n - m);

	return 0;
}