#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main(void) {

	char input[3];
	float score;

	gets(input);

	if (input[0] == 'A') score = 4.0;
	else if (input[0] == 'B') score = 3.0;
	else if (input[0] == 'C') score = 2.0;
	else if (input[0] == 'D') score = 1.0;
	else score = 0.0;

	if (input[1] == '+') score += 0.3;
	else if (input[1] == '-') score -= 0.3;

	printf("%.1f\n", score);

	return 0;
}

