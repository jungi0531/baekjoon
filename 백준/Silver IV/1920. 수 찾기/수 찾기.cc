#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int BST(int arr[], int left, int right, int target);

int compare(const void* a, const void* b) {
	int x = *(int*)a;
	int y = *(int*)b;
	if (x < y) return -1;
	else if (x > y) return 1;
	else return 0;
}

int main(void) {
	int n, k, i, input;
	int Arr[100000];

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		scanf("%d", &Arr[i]);
	}

	// 정렬..
	qsort(Arr, n, sizeof(int), compare);

	scanf("%d", &k);

	for (i = 0; i < k; i++) {
		scanf("%d", &input);
		printf("%d\n", BST(Arr, 0, n - 1, input));
	}

	return 0;
}

int BST(int arr[], int left, int right, int target) {
	int mid;
	while (left <= right) {
		mid = (left + right) / 2;
		if (arr[mid] == target) return 1;
		else if (arr[mid] < target) {
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}
	return 0;
}