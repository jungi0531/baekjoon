#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {

	char str[1000];
	int order;

	scanf("%s", str);
	scanf("%d", &order);
	printf("%c", str[order - 1]);
	
	return 0;
}