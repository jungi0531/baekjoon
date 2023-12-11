#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	int n;
	char input[51];

	scanf("%d ", &n);

	for (int i = 0; i < n; i++) {
		gets(input);
		printf("%d. %s\n", i + 1, input);
	}
	return 0;
}