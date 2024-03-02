#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct _node {
	int Data;
	struct _node* next;
} Node;

typedef struct _liststack {
	Node* head;
} ListStack;

typedef ListStack Stack;

void StackInit(Stack* pstack);
void SPush(Stack* pstack, int Data);
int SPop(Stack* pstack);
int SSum(Stack* pstack);

int main(void) {
	int K;
	int input;
	int i;

	Stack stack;

	StackInit(&stack);

	scanf("%d", &K);

	for (i = 0; i < K; i++) {
		scanf("%d", &input);
		if (input == 0) {
			SPop(&stack);
		}
		else {
			SPush(&stack, input);
		}
	}
	printf("%d\n", SSum(&stack));

	return 0;
}

void StackInit(Stack* pstack) {
	pstack->head = NULL;
}

void SPush(Stack* pstack, int Data) {
	Node* newNode = (Node*)malloc(sizeof(Node));

	newNode->Data = Data;
	newNode->next = pstack->head;

	pstack->head = newNode;
}

int SPop(Stack* pstack) {
	int rdata;
	Node* rNode;

	rdata = pstack->head->Data;
	rNode = pstack->head;

	pstack->head = pstack->head->next;
	free(rNode);

	return rdata;
}

int SSum(Stack* pstack) {
	int sum = 0;
	Node* cur = pstack->head;
	while (cur != NULL) {
		sum += cur->Data;
		cur = cur->next;
	}
	return sum;
}