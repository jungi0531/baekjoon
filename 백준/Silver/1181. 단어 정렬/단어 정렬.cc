#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int compare(const void* a, const void* b);

int main(void) {

	int n;
	char arr[20000][51];
	
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%s", arr[i]);
	}

	qsort(arr, n, sizeof(arr[0]), compare);

	for (int i = 0; i < n; i++) {
		if (strcmp(arr[i], arr[i + 1]) != 0) printf("%s\n", arr[i]);
	}
	return 0;
}

int compare(const void* a, const void* b) {
	if (strlen((char*)a) > strlen((char*)b)) return 1;
	else if (strlen((char*)a) < strlen((char*)b)) return -1;
	else return strcmp((char*)a, (char*)b);
}

// 문제는 문자열 길이 -> 아스키코드 순을 비교 해야하는데
// 지금 아스키코드부터 비교해서 문자열 길이 순으로 정렬되고 있지 않음