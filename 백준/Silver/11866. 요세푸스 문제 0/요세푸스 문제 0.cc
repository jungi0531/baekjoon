#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

#define TRUE	1
#define FALSE	0

#define QUEUE_LEN	1001

typedef int Data;

typedef struct _cqueue {
	int front;
	int rear;
	Data queArr[QUEUE_LEN];
} CQueue;

typedef CQueue Queue;

void QueueInit(Queue* pq);
int QIsEmpty(Queue* pq);

void Enqueue(Queue* pq, Data data);
Data Dequeue(Queue* pq);
Data QPeek(Queue* pq);

int main(void) {

	Queue q;
	QueueInit(&q);

	int n, k, i;

	scanf("%d %d", &n, &k);

	for (i = 0; i < n; i++) {
		Enqueue(&q, i + 1);
	}
	printf("<");
	while (!QIsEmpty(&q)) {
		for (i = 0; i < k - 1; i++) {
			Enqueue(&q, Dequeue(&q));
		}
		printf("%d", Dequeue(&q));
		if (!QIsEmpty(&q))
			printf(", ");
	}
	printf(">\n");

	return 0;
}

void QueueInit(Queue* pq) {
	pq->front = 0;
	pq->rear = 0;
}
int QIsEmpty(Queue* pq) {
	if (pq->front == pq->rear) return TRUE;
	else return FALSE;
}

int NextPosIdx(int pos) {
	if (pos == QUEUE_LEN - 1)  return 0;
	else return pos + 1;
}
void Enqueue(Queue* pq, Data data) {
	if (NextPosIdx(pq->rear) == pq->front) {
		printf("Queue is full\n");
		exit(0);
	}
	pq->rear = NextPosIdx(pq->rear);
	pq->queArr[pq->rear] = data;
}
Data Dequeue(Queue* pq) {
	if (QIsEmpty(pq)) {
		printf("In Dequeue, Queue Memory Error!\n");
		exit(-1);
	}
	pq->front = NextPosIdx(pq->front);
	return pq->queArr[pq->front];
}
Data QPeek(Queue* pq) {
	if (QIsEmpty(pq)) {
		printf("Queue Memory Error!\n");
		exit(0);
	}
	return pq->queArr[NextPosIdx(pq->front)];
}