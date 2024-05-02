#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int N;
int M;
int arr[10];

void func(int level);

int main(void) {

	scanf("%d %d", &N, &M);

	func(1);

	return 0;
}

void func(int level) {
	if (level > M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}
	else {
		for (int i = 1; i <= N; i++) {
			arr[level - 1] = i;
			func(level + 1);
		}
	}
}