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

void Delete()
  {
    Node *prev;
    if(start==NULL)
    {
        printf("\nThe list is empty...!\n");
    }
    else
    {
        temp=start;
        while(prev!=NULL)
        {
            prev = temp->next;
            printf("\nDeleting element %d...",temp->Data);
            free(temp);
            temp = prev;
        }
        start = NULL;
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
    int a,n,i,b;
    printf("Enter the number of Elements: ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
      {
	  printf("Enter the element : ");
			scanf("%d",&a);
			ins8end(a);
      }
     Delete();
     Traverse();
    return 0;
  }
