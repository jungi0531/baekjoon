#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

#define QUEUE_LEN	101

typedef struct _data {
	int value;
	int check;
} Data;

typedef struct _circularqueue {
	Data data[QUEUE_LEN];
	int front;
	int rear;
	int numOfData;
} CircularQueue;

typedef CircularQueue Queue;

void QueueInit(Queue* pq);
int QIsEmpty(Queue* pq);
int NextPosIdx(int pos);
void Enqueue(Queue* pq, Data data);
Data Dequeue(Queue* pq);
Data QPeek(Queue* pq);
int FindMax(Queue* pq);

int main(void) {
	int K, N, M;
	int i, j;
	int count;
	int max;

	Queue q;

	Data input;

	scanf("%d", &K);

	for (i = 0; i < K; i++) {
		QueueInit(&q);
		count = 0;

		scanf("%d %d", &N, &M);
		for (j = 0; j < N; j++) {
			scanf("%d", &input.value);
			if (j == M) input.check = 1;
			else input.check = 0;
			Enqueue(&q, input);
		}

		// max 값 구하고 max값 dequeue 하면 다시 맥스값 찾고 그 값 디큐할 때까지
		while (!QIsEmpty(&q)) {
			max = FindMax(&q);
			while (1) {
				if (QPeek(&q).value == max) {
					if (QPeek(&q).check == 1) {
						printf("%d\n", count + 1);
					}
					else {
						count++;
					}
					Dequeue(&q);
					break;
				}
				else {
					Enqueue(&q, Dequeue(&q));
				}
			}
		}
	}

	return 0;
}

void QueueInit(Queue* pq) {
	pq->numOfData = 0;
	pq->front = 0;
	pq->rear = 0;
}
int QIsEmpty(Queue* pq) {
	if (pq->front == pq->rear) return 1;
	else return 0;
}

int NextPosIdx(int pos) {
	if (pos == QUEUE_LEN - 1) return 0;
	else return pos + 1;
}
void Enqueue(Queue* pq, Data data) {
	if (NextPosIdx(pq->rear) == pq->front) {
		printf("Queue is full.\n");
		return;
	}
	pq->rear = NextPosIdx(pq->rear);
	pq->data[pq->rear] = data;
	pq->numOfData++;
}
Data Dequeue(Queue* pq) {
	if (QIsEmpty(pq)) {
		printf("Queue is Empty.\n");
		exit(-1);
	}
	pq->front = NextPosIdx(pq->front);
	pq->numOfData--;
	return pq->data[pq->front];
}

Data QPeek(Queue* pq) {
	if (QIsEmpty(pq)) {
		printf("Queue is empty.\n");
		exit(-1);
	}
	return pq->data[NextPosIdx(pq->front)];
}

int FindMax(Queue* pq) {
	int i = NextPosIdx(pq->front);
	int max = 0;

	while (i != NextPosIdx(pq->rear)) {
		if (pq->data[i].value > max) max = pq->data[i].value;
		i = NextPosIdx(i);
	}

	return max;
}