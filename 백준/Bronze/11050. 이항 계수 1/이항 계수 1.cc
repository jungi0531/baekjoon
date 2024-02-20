#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int i;
	int N, K;
	int answer = 1;

	scanf("%d %d", &N, &K);

	for (i = 0; i < K; i++) {
		answer *= (N - i);
	}
	for (i = 2; i <= K; i++) {
		answer /= i;
	}
	printf("%d", answer);

	return 0;
}