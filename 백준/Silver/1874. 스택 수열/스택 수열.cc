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
	int used[100001] = { 0 };
	int input;
	char answer[500001];
	int n, i, j;
	int count = 0;
	int no = 0;
	SInit(&stack);
	// 수 입력
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &input);
		if (input == STop(&stack)) {
			used[SPop(&stack)]++;
			answer[count++] = '-';
		}
		else if (input > STop(&stack)) {
			for (j = STop(&stack) + 1; j <= input; j++) {
				if (used[j] == 0) {
					SPush(&stack, j);
					answer[count++] = '+';
				}
			}
			used[SPop(&stack)]++;
			answer[count++] = '-';
		}
		else {
			no++;
		}
	}
	if (no) {
		printf("NO\n");
	}
	else {
		for (i = 0; i < count; i++) {
			printf("%c\n", answer[i]);
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
	if (SEmpty(pstack)) return 0;
	else return pstack->head->data;
}