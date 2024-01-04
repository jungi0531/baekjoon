#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main(void) {

	char input[101];

	gets(input);

	for (int i = 0; i < strlen(input); i++) {
		if (input[i] > 96) {
			input[i] -= 32;
		}
		else {
			input[i] += 32;
		}
	}
	puts(input);

	return 0;
}

