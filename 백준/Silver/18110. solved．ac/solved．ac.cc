#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int compare(const void* a, const void* b) {
	int x = *(int*)a;
	int y = *(int*)b;
	if (x > y) return 1;
	else if (x < y) return -1;
	else return 0;
}

int main(void) {
	int n;
	int i;
	int* arr;
	int cut_Mean;
	int level = 0;
	int count = 0;

	scanf("%d", &n);

	arr = (int*)malloc(sizeof(int) * n);

	cut_Mean = (n * 0.15) + 0.5;

	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}

	qsort(arr, n, sizeof(int), compare);

	for (i = cut_Mean; i < n - cut_Mean; i++) {
		level += arr[i];
		count++;
	}
	level = ((float)level / (float)count) + 0.5;

	if (n == 0) printf("0\n");
	else printf("%d\n", level);

	return 0;
}