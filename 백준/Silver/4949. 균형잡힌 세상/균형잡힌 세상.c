#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char Data;

typedef struct _node {
    Data data;
    struct _node* next;
} Node;

typedef struct _liststack {
    Node* head;
} ListStack;

typedef ListStack Stack;

void StackInit(Stack* stack);
int SIsEmpty(Stack* stack);
void SPush(Stack* stack, Data data);
Data SPop(Stack* stack);
Data SPeek(Stack* stack);

int main(void) {
    
    char input[110];
    int i, len;
    int check;

    Stack stack;

    while (1) {
        StackInit(&stack);
        memset(input, '\0', sizeof(input));
        check = 0;

        gets(input);
        if (strcmp(input, ".") == 0) break;

        len = strlen(input);
        for (i = 0; i < len; i++) {
            if (input[i] == '(') {
                SPush(&stack, input[i]);
            }
            else if (input[i] == '[') {
                SPush(&stack, input[i]);
            }
            else if (input[i] == ')') {
                if (SPeek(&stack) == '(') {
                    SPop(&stack);
                }
                else {
                    check++;
                }
            }
            else if (input[i] == ']') {
                if (SPeek(&stack) == '[') {
                    SPop(&stack);
                }
                else {
                    check++;
                }
            }
        }
        if (check == 0 && SIsEmpty(&stack)) printf("yes\n");
        else printf("no\n");
    }
    return 0;
}

void StackInit(Stack* stack) {
    stack->head = NULL;
}

int SIsEmpty(Stack* stack) {
    if (stack->head == NULL) return 1;
    else return 0;
}

void SPush(Stack* stack, Data data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;

    newNode->next = stack->head;
    stack->head = newNode;
}

Data SPop(Stack* stack) {
    Data rdata;
    Node* rNode;

    if (SIsEmpty(stack)) {
        return 0;
    }

    rdata = stack->head->data;
    rNode = stack->head;
    stack->head = stack->head->next;

    free(rNode);
    return rdata;
}

Data SPeek(Stack* stack) {
    if (SIsEmpty(stack)) {
        return 0;
    }
    return stack->head->data;
}