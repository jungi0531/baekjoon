#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

#define M	1234567891

int main(void) {
	int i;
	int L;
	char input[51];
	long long int answer = 0, R = 1;

	scanf("%d", &L);

	scanf("%s", input);

	for (i = 0; i < L; i++) {
		answer = (answer + (input[i] - 'a' + 1) * R) % M;
		R = (R * 31) % M;
	}
	printf("%lld\n", answer);

	return 0;
}