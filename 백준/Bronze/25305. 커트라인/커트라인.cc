#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	int n, k, score[1000];

	scanf("%d %d", &n, &k);

	for (int i = 0; i < n; i++) {
		scanf("%d", &score[i]);
	}
	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++) {
			if (score[i] > score[j]) {
				int temp = score[i];
				score[i] = score[j];
				score[j] = temp;
			}
		}
	}
	printf("%d\n", score[n - k]);

	return 0;
}