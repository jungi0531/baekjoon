#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	int t, k, n, arr[15][15];

	scanf("%d", &t);

	for (int i = 0; i < 15; i++) {
		arr[0][i] = i + 1;
	}
	for (int i = 0; i < 15; i++) {
		arr[i][0] = 1;
	}
	for (int i = 1; i < 15; i++) {
		for (int j = 1; j < 15; j++) {
			arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
		}
	}
	for (int i = 0; i < t; i++) {
		scanf("%d %d", &k, &n);
		printf("%d\n", arr[k][n - 1]);
	}

	return 0;
}