#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	int arr[5], sum = 0;
	for (int i = 0; i < 5; i++) {
		scanf("%d", &arr[i]);
		sum += arr[i];
	}
	for (int i = 0; i < 5; i++) {
		for (int j = i; j < 5; j++) {
			if (arr[i] > arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	printf("%d\n%d", sum / 5, arr[2]);

	return 0;
}