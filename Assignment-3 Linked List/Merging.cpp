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
Node *start1=NULL;
Node *start2=NULL;
Node *temp,*curr,*temp1;

void ins8end(int b, Node **head)
  {
    if((*head)==NULL)
      {
        temp=(Node*)malloc(sizeof (Node));
        (*head)=temp;
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
        printf("\nThe list is : ");
        temp=(*head);
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

struct Node* Merging()
{
    struct Node *resultHead, *resultTail, *temp;
    resultHead = resultTail = NULL;
    while(1)
    {
        if(start == NULL)
        {
            resultTail->next = start1;
            break;
        }

        if(start1 == NULL)
        {
            resultTail->next = start;
            break;
        }

        if(start->Data <= start1->Data)
        {
            temp = start;
            start = start->next;
        }
        else
        {
            temp = start1;
            start1 = start1->next;
        }

        if(resultHead == NULL)
        {
            resultHead = resultTail = temp;
        }
        else
        {
            resultTail->next = temp;
            resultTail = temp;
        }
        resultTail->next = NULL;
    }
    return resultHead;
}

int main()
  {
    int a,n,i,m;
    printf("\nEnter the number of Elements of first Linked List: ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
      {
          printf("Enter the element : ");
			scanf("%d",&a);
			ins8end(a,&start);
      }
    Traverse(&start);
    printf("\nEnter the number of Elements of second Linked List: ");
    scanf("%d",&m);
    for(i=0;i<m;i++)
      {
          printf("Enter the element : ");
			scanf("%d",&a);
			ins8end(a,&start1);
      }
     Traverse(&start1);
     Node * newnode = Merging(n,m);
     Traverse(&newnode);
     return 0;
  }
