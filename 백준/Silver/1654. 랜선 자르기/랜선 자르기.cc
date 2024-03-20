#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int i;
	int N, K;
	int count, ans;
	long long* arr;
	long long max = 0;
	long long left, right, mid;

	scanf("%d %d", &N, &K);

	arr = (long long*)malloc(sizeof(long long) * N);

	for (i = 0; i < N; i++) {
		scanf("%lld", &arr[i]);
		if (arr[i] > max) max = arr[i];
	}

	ans = 0;
	left = 1;
	right = max;

	while (left <= right) {
		count = 0;
		mid = (left + right) / 2;

		for (i = 0; i < N; i++) {
			count += arr[i] / mid;
		}

		if (count >= K) {
			left = mid + 1;
			if (ans < mid) ans = mid;
		}
		else right = mid - 1;
	}
	printf("%d\n", ans);

	free(arr);
	return 0;
}