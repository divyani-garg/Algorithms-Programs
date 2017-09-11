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


struct Node* reverse (struct Node *head, int k)
{
    struct Node* current = head;
    struct Node* next = NULL;
    struct Node* prev = NULL;
    int count = 0;
    while (current != NULL && count < k)
    {
        next  = current->next;
        current->next = prev;
        prev = current;
        current = next;
        count++;
    }
    if (next !=  NULL)
    {
       head->next = reverse(next, k);
    }
    return prev;
}


int main()
  {
    int a,n,i,k;
    printf("Enter the number of Elements: ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
      {
          printf("Enter the element : ");
			scanf("%d",&a);
			ins8end(a);
      }
     printf("Enter the kth element to reverse linked list : ");
     scanf("%d",&k);
     printf("\nLinked List entered is : ");
     Traverse(&start);
     struct Node *reverseLL;
     reverseLL = reverse(start,k);
     printf("\nReversed Linked List is : ");
     Traverse(&reverseLL);
     return 0;
  }
