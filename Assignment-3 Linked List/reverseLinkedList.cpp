#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<malloc.h>

struct Node
  {
    int Data;
    struct Node *next;
  };

Node *start=NULL;
Node *temp,*curr;

void ins8end(int b)
  {
    if(start==NULL)
      {
        temp=(Node*)malloc(sizeof (Node));
        start=temp;
        temp->Data=b;
        temp->next=NULL;
        curr=temp;
      }
    else
      {
        temp=(Node*)malloc(sizeof (Node));
        temp->Data=b;
        temp->next=NULL;
        curr->next=temp;
        curr=temp;
       }
  }

void Traverse(Node **head)
  {
    if((*head)==NULL)
      {
        printf("\nThe list is empty...!\n");
      }
    else
      {
        temp=(*head);
        for(;;)
          {
            printf("%d  ",temp->Data);
            temp=temp->next;
            if(temp==NULL)
			  {
			    break;
              }
           }
		}
  }

struct Node* reverseLinkedList(struct Node *head)
{
    struct Node *newHead = NULL, *temp;
    /* Input Validation */
    if (head == NULL) {
       printf("Error : Invalid node pointer !!!\n");
       return NULL;
    }

    while(head != NULL) {
        temp = (struct Node*) malloc(sizeof(struct Node));
        temp->Data = head->Data;
        temp->next = newHead;
        newHead = temp;
        head = head->next;
    }

    return newHead;
}

int main()
  {
    int a,n,i;
    printf("Enter the number of Elements: ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
      {
          printf("Enter the element : ");
			scanf("%d",&a);
			ins8end(a);
      }
     printf("\nLinked List entered is : ");
     Traverse(&start);
     struct Node *reverseLL;
     reverseLL = reverseLinkedList(start);
     printf("\nReversed Linked List is : ");
     Traverse(&reverseLL);
     return 0;
  }
