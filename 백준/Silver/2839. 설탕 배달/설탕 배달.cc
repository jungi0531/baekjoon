#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	int n, i, j;

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			if ((i * 3) + (j * 5) == n) break;
		}
		if ((i * 3) + (j * 5) == n) break;
	}
	if ((i * 3) + (j * 5) == n) printf("%d\n", i + j);
	else printf("-1\n");

	return 0;
}