#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

#define QUEUE_LEN 500000
#define TRUE	1
#define FALSE	0

typedef int Data;

typedef struct _node {
	Data data;
	struct _node* next;
} Node;

typedef struct _lqueue {
	Node* head;
	Node* tail;
} LQueue;

typedef LQueue Queue;

void QueueInit(Queue* pq) {
	pq->head = NULL;
	pq->tail = NULL;
}
int QIsEmpty(Queue* pq) {
	if (pq->head == NULL)
		return TRUE;
	else
		return FALSE;
}

void Enqueue(Queue* pq, Data data) {
	Node* newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data;
	newNode->next = NULL;

	if (pq->head == NULL) {
		pq->head = newNode;
	}
	else {
		pq->tail->next = newNode;
	}
	pq->tail = newNode;
}
Data Dequeue(Queue* pq) {
	Node* delnode;
	Data rdata;

	if (QIsEmpty(pq)) {
		printf("Dequeue -> queue is empty\n");
		return FALSE;
	}
	delnode = pq->head;
	rdata = pq->head->data;
	pq->head = pq->head->next;

	free(delnode);
	return rdata;
}

Data QPeek(Queue* pq) {
	if (QIsEmpty(pq)) {
		printf("QPeek -> queue is empty\n");
		return FALSE;
	}
	return pq->head->data;
}

Data QIsLast(Queue* pq) {
	if (pq->head->next == NULL) {
		return TRUE;
	}
	else return FALSE;
}

int main(void) {

	Queue q;
	int n, i;
	
	QueueInit(&q);

	scanf("%d", &n);

	for (i = 1; i <= n; i++) {
		Enqueue(&q, i);
	}

	while (!QIsLast(&q)) {
		Dequeue(&q);
		Enqueue(&q, Dequeue(&q));
	}
	printf("%d\n", QPeek(&q));

	return 0;
}