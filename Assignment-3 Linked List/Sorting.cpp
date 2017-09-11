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

void Swapping(Node *a, Node *b)
{
    int swap = a->Data;
    a->Data = b->Data;
    b->Data = swap;
}

void sortLinkedList(int n)
{

    for(int i = 0;i<n;i++)
    {
        temp=start;
        while(temp->next != NULL)
        {
            if(temp->Data > temp->next->Data)
            {
                curr = temp->next;
                Swapping(temp,curr);
            }
            temp=temp->next;
        }
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
        temp=start;
        for(;;)
          {
            printf("\n%d",temp->Data);
            temp=temp->next;
            if(temp==NULL)
			  {
			    break;
              }
           }
		}
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
     printf("\nBefore Sorting List is : ");
     Traverse();
     sortLinkedList(n);
     printf("\n\nAfter Sorting List is : ");
     Traverse();
     return 0;
  }
