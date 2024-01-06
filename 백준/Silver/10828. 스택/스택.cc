#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef int Data;

typedef struct _node {
	Data data;
	struct _node* next;
} Node;

typedef struct _stack {
	Node* head;
} Stack;

void SInit(Stack* pstack);
void SPush(Stack* pstack, Data data);
int SPop(Stack* pstack);
int SSize(Stack* pstack);
int SEmpty(Stack* pstack);
int STop(Stack* pstack);

int main(void) {
	Stack stack;
	Data pdata;
	char input[10];
	int n, i;
	SInit(&stack);

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%s", input);
		if (strcmp(input, "push") == 0) {
			scanf("%d", &pdata);
			// printf("push 입력\n");
			SPush(&stack, pdata);
		}
		else if (strcmp(input, "pop") == 0) {
			// printf("pop 입력\n");
			printf("%d\n", SPop(&stack));
		}
		else if (strcmp(input, "size") == 0) {
			// printf("size 입력\n");
			printf("%d\n", SSize(&stack));
		}
		else if (strcmp(input, "empty") == 0) {
			// printf("empty 입력\n");
			printf("%d\n", SEmpty(&stack));
		}
		else if (strcmp(input, "top") == 0) {
			// printf("top 입력\n");
			printf("%d\n", STop(&stack));
		}
		else {
			printf("잘못 입력하셨습니다.\n");
		}
	}
	return 0;
}

void SInit(Stack* pstack) {	
	pstack->head = NULL;
}

void SPush(Stack* pstack, Data data) {	
	Node* newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data;

	newNode->next = pstack->head;
	pstack->head = newNode;
}

int SPop(Stack* pstack) {	
	Node* rpos;
	Data rdata;

	if (SEmpty(pstack)) {
		return -1;
	}

	rpos = pstack->head;
	rdata = pstack->head->data;
	pstack->head = pstack->head->next;

	free(rpos);
	return rdata;
}

int SSize(Stack* pstack) {	
	int count = 0;
	Node* cur = pstack->head;
	while (cur != NULL) {
		cur = cur->next;
		count++;
	}
	return count;
}

int SEmpty(Stack* pstack) {
	if (pstack->head == NULL) return 1;
	else return 0;
}

int STop(Stack* pstack) {
	if (SEmpty(pstack)) return -1;
	else return pstack->head->data;
}