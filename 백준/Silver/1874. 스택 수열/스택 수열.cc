#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct _node {
	int data;
	struct _node* next;
} Node;

typedef struct _stack {
	Node* head;
	int numOfData;
} Stack;

void StackInit(Stack* pstack);
int SIsEmpty(Stack* pstack);
void SPush(Stack* pstack, int data);
int SPop(Stack* pstack);
int SPeek(Stack* pstack);

int main(void) {
	int i, j;
	int n;				
	int input;
	int count = 0;
	int check = 0;		// 1이면 불가능으로 NO 출력
	int used[100001] = { 0 };
	char ans[500000];	// 출력 값 저장
	Stack stack;

	StackInit(&stack);

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		scanf("%d", &input);
		if (input == SPeek(&stack)) {
			used[SPop(&stack)]++;
			ans[count++] = '-';
		}
		else if (input > SPeek(&stack)) {
			for (j = SPeek(&stack) + 1; j <= input; j++) {
				if (used[j] == 0) {
					SPush(&stack, j);
					ans[count++] = '+';
				}
			}
			used[SPop(&stack)]++;
			ans[count++] = '-';
		}
		else check++;
	}

	if (check) printf("NO\n");
	else {
		for (i = 0; i < count; i++) {
			printf("%c\n", ans[i]);
		}
	}

	return 0;
}

void StackInit(Stack* pstack) {
	pstack->head = NULL;
	pstack->numOfData = 0;
}
int SIsEmpty(Stack* pstack) {
	if (pstack->head == NULL) return 1;
	else return 0;
}
void SPush(Stack* pstack, int data) {
	Node* newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data;
	newNode->next = pstack->head;
	pstack->head = newNode;
}
int SPop(Stack* pstack) {
	Node* rNode;
	int rdata;
	if (SIsEmpty(pstack)) {
		return -1;
	}
	rNode = pstack->head;
	rdata = rNode->data;
	pstack->head = pstack->head->next;
	free(rNode);
	return rdata;
}
int SPeek(Stack* pstack) {
	if (SIsEmpty(pstack)) {
		return 0;
	}
	return pstack->head->data;
}