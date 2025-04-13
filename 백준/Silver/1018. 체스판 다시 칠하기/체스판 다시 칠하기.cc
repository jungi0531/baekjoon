#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	int N, M, min = 100, count = 0;
	char chess[51][51] = { NULL };
	
	scanf("%d %d", &N, &M);


	for (int i = 0; i < N; i++) {	// 체스 판 입력 받기
		scanf("%s", chess[i]);
	}


	for (int i = 0; i < N - 7; i++) {	// 걍 이 반복문에서는 첫번째 칸이 흰색인 경우만.
		for (int j = 0; j < M - 7; j++) {
			for (int k = i; k < i + 8; k++) {
				for (int t = j; t < j + 8; t++) {
					if ((k + t - i - j) % 2 == 0) {	// 짝수인 경우 (흰색이어야 함)
						if (chess[k][t] == 'B') {
							count++;
						}
					}
					else {	// 홀수인 경우 (검은색이어야 함)
						if (chess[k][t] == 'W') {
							count++;
						}
					}
				}
			}
			if (count < min) {
				min = count;
			}
			count = 0;

			for (int k = i; k < i + 8; k++) {
				for (int t = j; t < j + 8; t++) {
					if ((k + t - i - j) % 2 == 0) {	// 첫칸이 검은색이라고 가정한 경우
						if (chess[k][t] == 'W') {
							count++;
						}
					}
					else {	// 거믕거여야 하는 경우
						if (chess[k][t] == 'B') {
							count++;
						}
					}
				}
			}
			if (count < min) {
				min = count;
			}
			count = 0;
		}
	}
	printf("%d\n", min);	// 칠해야하는 최소 칸 개수 출력

	return 0;
}