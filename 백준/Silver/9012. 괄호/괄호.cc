#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main(void) {

	int n;
	int i, j, k;
	int count;
	char input[51];

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		count = 0;
		scanf("%s", input);
		k = strlen(input);
		for (j = 0; j < k; j++) {
			if (input[j] == '(') {
				count++;
			}
			else if (input[j] == ')') {
				count--;
			}
			if (count < 0) {
				break;
			}
		}
		if (count == 0) {
			printf("YES\n");
		}
		else {
			printf("NO\n");
		}
	}
	return 0;
}