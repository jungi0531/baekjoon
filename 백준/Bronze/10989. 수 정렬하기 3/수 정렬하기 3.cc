#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	int i, j, n, num, count[10001] = { 0 };

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		scanf("%d", &num);
		count[num]++;
	}

	for (i = 0; i < 10001; i++) {
		for (j = 0; j < count[i]; j++) {
			printf("%d\n", i);
		}
	}

	return 0;
}