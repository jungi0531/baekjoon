#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	int num, sum[2] = { 0 };

	for (int i = 0; i < 4; i++) {
		scanf("%d", &num);
		sum[0] += num;
	}
	for (int i = 0; i < 4; i++) {
		scanf("%d", &num);
		sum[1] += num;
	}
	if (sum[0] < sum[1]) printf("%d\n", sum[1]);
	else printf("%d\n", sum[0]);

	return 0;
}