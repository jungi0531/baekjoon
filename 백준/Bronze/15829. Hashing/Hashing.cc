#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

int main(void) {

	int n, sum = 0;
	char input;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf(" %c", &input);
		sum += (input - 'a' + 1) * pow(31, i);
	}
	printf("%d\n", sum);

	return 0;
}