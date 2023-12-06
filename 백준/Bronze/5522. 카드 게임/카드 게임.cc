#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	int num, sum = 0;

	for (int i = 0; i < 5; i++) {
		scanf("%d", &num);
		sum += num;
	}
	printf("%d\n", sum);

	return 0;
}