#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main(void) {
	
	char n[100000];
	int i;

	while (1) {
		scanf("%s", &n);
		if (strcmp(n, "0") == 0) break;		// 0 입력 시 탈출
		for (i = 0; i < strlen(n) / 2; i++) {
			if (n[i] != n[strlen(n) - (i + 1)]) {
				printf("no\n");
				break;
			}
		}
		if (i == strlen(n) / 2) {
			printf("yes\n");
		}
	}
	return 0;
}