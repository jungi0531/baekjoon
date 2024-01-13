#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

#define DEQUE_LEN 10000
#define TRUE	1
#define FALSE	0

typedef int Data;

typedef struct _arrayqueue {
	Data data[DEQUE_LEN];
	int front;
	int rear;
	int numOfData;
} ArrayQueue;

typedef ArrayQueue Queue;

void QueueInit(Queue* pq) {
	pq->front = 0;
	pq->rear = 0;
	pq->numOfData = 0;
}
int QIsEmpty(Queue* pq) {
	if (pq->front == pq->rear) {
		return TRUE;
	}
	return FALSE;
}

int NextPosIdx(int pos) {
	if (pos == DEQUE_LEN - 1)
		return 0;
	else
		return pos + 1;
}
int PrevPosIdx(int pos) {
	if (pos == 0)
		return DEQUE_LEN - 1;
	else
		return pos - 1;
}
void EnqueueBack(Queue* pq, Data data) {
	pq->rear = NextPosIdx(pq->rear);
	pq->data[pq->rear] = data;
	pq->numOfData++;
}
void EnqueueFront(Queue* pq, Data data) {
	pq->data[pq->front] = data;
	pq->front = PrevPosIdx(pq->front);
	pq->numOfData++;
}
Data DequeueFront(Queue* pq) {
	int ridx;

	if (QIsEmpty(pq)) {
		return -1;
	}

	pq->front = NextPosIdx(pq->front);
	ridx = pq->front;
	pq->numOfData--;
	return pq->data[ridx];
}
Data DequeueBack(Queue* pq) {
	int ridx;

	if (QIsEmpty(pq)) {
		return -1;
	}

	ridx = pq->rear;
	pq->rear = PrevPosIdx(pq->rear);
	pq->numOfData--;
	return pq->data[ridx];
}

Data QPeekFront(Queue* pq) {
	if (QIsEmpty(pq)) {
		return -1;
	}
	return pq->data[NextPosIdx(pq->front)];
}
Data QPeekBack(Queue* pq) {
	if (QIsEmpty(pq)) {
		return -1;
	}
	return pq->data[pq->rear];
}

int QueueSize(Queue* pq) {
	return pq->numOfData;
}


int main(void) {

	Queue q;
	int n, i, data;
	char input[20];
	
	QueueInit(&q);

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		scanf("%s", input);
		if (strcmp(input, "push_back") == 0) {
			scanf("%d", &data);
			EnqueueBack(&q, data);
		}
		else if (strcmp(input, "push_front") == 0) {
			scanf("%d", &data);
			EnqueueFront(&q, data);
		}
		else if (strcmp(input, "pop_front") == 0) {
			printf("%d\n", DequeueFront(&q));
		}
		else if (strcmp(input, "pop_back") == 0) {
			printf("%d\n", DequeueBack(&q));
		}
		else if (strcmp(input, "size") == 0) {
			printf("%d\n", QueueSize(&q));
		}
		else if (strcmp(input, "empty") == 0) {
			printf("%d\n", QIsEmpty(&q));
		}
		else if (strcmp(input, "front") == 0) {
			printf("%d\n", QPeekFront(&q));
		}
		else if (strcmp(input, "back") == 0) {
			printf("%d\n", QPeekBack(&q));
		}
		else {
			printf("input error.\n");
		}
	}
	return 0;
}