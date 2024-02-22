#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int Factorial_ZeroNum(int N) {
	int i;
	int temp = 1;
	int count = 0;
	for (i = 1; i <= N; i++) {
		temp *= i;
		if (temp % 10 == 0) {
			while (temp % 10 == 0) {
				count++;
				temp /= 10;
			}
		}
		else {
			temp %= 10000;
		}
	}
	return count;
}

int main(void) {
	int N;

	scanf("%d", &N);

	printf("%d\n", Factorial_ZeroNum(N));

	return 0;
}