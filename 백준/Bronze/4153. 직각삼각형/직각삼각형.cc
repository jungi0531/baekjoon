#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b);

int main(void) {

	int tri[3];

	while (1) {
		scanf("%d %d %d", &tri[0], &tri[1], &tri[2]);
		if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0) break;
		qsort(tri, 3, sizeof(int), compare);
		if (tri[0] * tri[0] == tri[1] * tri[1] + tri[2] * tri[2]) printf("right\n");
		else printf("wrong\n");
	}
	return 0;
}

int compare(const void* a, const void* b) {
	return *(int*)b - *(int*)a;
}