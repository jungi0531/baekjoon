#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

typedef struct _peoplesize {
	int weight;
	int height;
} PeopleSize;

int main(void) {
	int i, j;
	int N;
	int count;

	PeopleSize peoplesize[50];

	scanf("%d", &N);

	for (i = 0; i < N; i++) {
		scanf("%d %d", &peoplesize[i].weight, &peoplesize[i].height);
	}

	for (i = 0; i < N; i++) {
		count = 1;
		for (j = 0; j < N; j++) {
			if (peoplesize[i].height < peoplesize[j].height && peoplesize[i].weight < peoplesize[j].weight)
				count++;
		}
		printf("%d ", count);
	}

	return 0;
}