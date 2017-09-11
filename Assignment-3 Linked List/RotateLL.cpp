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

void Traverse()
  {
    if(start==NULL)
      {
        printf("\nThe list is empty...!\n");
      }
    else
      {
        printf("\nThe list is : ");
        temp=start;
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

void rotate(struct Node **head, int k)
{
    if (k == 0)
    {
       return;
    }
    struct Node *temp = *head;
    int count = 1;
    while (count < k && temp != NULL)
    {
        temp = temp->next;
        count++;
    }
    if (temp == NULL)
    {
        return;
    }
    struct Node *kthNode = temp;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = *head;
    *head = kthNode->next;
    kthNode->next = NULL;
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
     printf("Enter the kth node to rotate : ");
     scanf("%d",&k);
     Traverse();
     rotate(&start,k);
     printf("\n\nAfter Rotation... ");
     Traverse();
     return 0;
  }
