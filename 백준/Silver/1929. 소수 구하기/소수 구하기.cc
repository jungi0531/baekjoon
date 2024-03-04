#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int M, N;
	int i, j;
	int* IsPrime;

	scanf("%d %d", &M, &N);

	IsPrime = (int*)calloc(N + 1, sizeof(int));

	IsPrime[1] = 1;

	for (i = 2; i <= N; i++) {
		for (j = 2; i * j <= N; j++) {
			IsPrime[i * j] = 1;
		}
	}

	for (i = M; i <= N; i++) {
		if (IsPrime[i] == 0) printf("%d\n", i);
	}

	return 0;
}