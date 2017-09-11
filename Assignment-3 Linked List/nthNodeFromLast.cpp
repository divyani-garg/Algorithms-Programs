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

Node* nthNodeFromLast(int n,int m)
{
    int count = 0;

    if(m>n)
    {
        return NULL;
    }
    else
    if(start==NULL)
      {
        printf("\nThe list is empty...!\n");
      }
    else
      {
        temp=start;
        for(;;)
          {
            if(count==(n-m))
            {
               return temp;
            }
            temp=temp->next;
            count++;
            if(temp==NULL)
			{
               break;
            }
           }
       }
}

int main()
  {
    int a,n,i,m;
    printf("Enter the number of Elements: ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
      {
          printf("Enter the element : ");
			scanf("%d",&a);
			ins8end(a);
      }
     printf("\nEnter the nth position : ");
     scanf("%d",&m);
     Node *temp = nthNodeFromLast(n,m);
     if(temp==NULL)
     {
       printf("\nPosition %d exceeded Linked list size...!",m);
     }
     else
     {
       printf("\nElement at %d Position from last is : ",m);
       printf("%d",temp->Data);
     }
     return 0;
  }
