#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int n, m;
	int i;
	int input;

	scanf("%d", &n);
	int* arr = (int*)calloc(20000001, sizeof(int));

	for (i = 0; i < n; i++) {
		scanf("%d", &input);
		arr[input + 10000000]++;
	}

	scanf("%d", &m);

	for (i = 0; i < m; i++) {
		scanf("%d", &input);
		printf("%d ", arr[input + 10000000]);
	}

	return 0;
}