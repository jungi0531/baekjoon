#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	
	int chess[6];
	int answer[6] = { 1, 1, 2, 2, 2, 8 };
	int output[6];

	for (int i = 0; i < 6; i++) {
		scanf("%d", &chess[i]);
		output[i] = answer[i] - chess[i];
		printf("%d ", output[i]);
	}
	return 0;
}