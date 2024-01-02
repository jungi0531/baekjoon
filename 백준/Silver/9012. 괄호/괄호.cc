#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main(void) {

	int n;
	int i, j, k;
	int count_1 = 0;
	int count_2 = 0;

	char input[51];

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		scanf("%s", input);
		k = strlen(input);
		for (j = 0; j < k; j++) {
			if (input[j] == '(') {
				count_1++;
			}
			else if (input[j] == ')') {
				count_2++;
			}
			if (count_1 < count_2) {
				break;
			}
		}
		if (count_1 == count_2) {
			printf("YES\n");
		}
		else {
			printf("NO\n");
		}
		count_1 = 0;
		count_2 = 0;
	}
	return 0;
}