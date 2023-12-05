#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b);

typedef struct {
	int age;
	char name[101];
} member;

int main(void) {

	int n;
	member* arr;

	scanf("%d", &n);

	arr = (member*)malloc(sizeof(member) * n);

	for (int i = 0; i < n; i++) {
		scanf("%d %s", &arr[i].age, arr[i].name);
	}

	qsort(arr, n, sizeof(member), compare);

	for (int i = 0; i < n; i++) {
		printf("%d %s\n", arr[i].age, arr[i].name);
	}

	return 0;
}

int compare(const void* a, const void* b) {
	return *(int*)a - *(int*)b;
}