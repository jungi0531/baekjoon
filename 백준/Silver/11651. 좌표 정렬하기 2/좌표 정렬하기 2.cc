#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int x;
	int y;
}coordinate;

int compare(const void* a, const void* b);

int main(void) {
	int n;
	coordinate* arr;
	scanf("%d", &n);

	arr = (coordinate*)malloc(sizeof(coordinate) * n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d", &arr[i].x, &arr[i].y);
	}
	qsort(arr, n, sizeof(coordinate), compare);
	for (int i = 0; i < n; i++) {
		printf("%d %d\n", arr[i].x, arr[i].y);
	}

	free(arr);
	return 0;
}

int compare(const void* a, const void* b) {
	coordinate cd1 = *(coordinate*)a;
	coordinate cd2 = *(coordinate*)b;
	if (cd1.y != cd2.y) return cd1.y - cd2.y;
	else return cd1.x - cd2.x;
}