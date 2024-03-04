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

int Average(int arr[], int N);
int Median(int arr[], int N);
int Mode(int arr[], int N);
int Range(int arr[], int N);

int main(void) {
	int N;
	int i;
	int* arr;

	scanf("%d", &N);

	arr = (int*)malloc(sizeof(int) * N);

	for (i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}

	qsort(arr, N, sizeof(int), compare);

	printf("%d\n", Average(arr, N));
	printf("%d\n", Median(arr, N));
	printf("%d\n", Mode(arr, N));
	printf("%d\n", Range(arr, N));

	return 0;
}

int Average(int arr[], int N) {
	int sum = 0;
	int i;
	double answer;

	for (i = 0; i < N; i++) {
		sum += arr[i];
	}
	answer = round((double)sum / N);
	return answer;
}
int Median(int arr[], int N) {
	return arr[N / 2];
}
int Mode(int arr[], int N) {
	int i;
	int count_Arr[8002] = { 0 };
	int Max = 0;
	int count = 0;
	int mode;
	int mode_2;

	for (i = 0; i < N; i++) {
		count_Arr[arr[i] + 4000]++;
	}

	for (i = 0; i <= 8000; i++) {
		if (count_Arr[i] > Max) {
			count = 1;
			Max = count_Arr[i];
			mode = i - 4000;
		}
		else if (count_Arr[i] == Max && count == 1) {
			count = 0;
			mode = i - 4000;
		}
	}
	return mode;
}
int Range(int arr[], int N) {
	return arr[N - 1] - arr[0];
}