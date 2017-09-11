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

int search(struct Node *head, int num)
{
    while (head != NULL)
    {
        if (head->Data == num)
        {
            return 1;
        }
        head = head->next;
    }
    return 0;
}

struct Node* findunion()
{
    struct Node *unionLL = NULL;
    struct Node *temp = start;
    struct Node *temp1 = start1;
    while(temp != NULL)
    {
        ins8end(temp->Data, &unionLL);
        temp = temp->next;
    }

    while(temp1 != NULL)
    {
        if(!search(start, temp1->Data))
        {
            ins8end(temp1->Data, &unionLL);
        }
        temp1 = temp1->next;
    }
    return unionLL;
}

struct Node* intersection()
{
    struct Node *intersectionLL = NULL;
    struct Node *temp = start;
    while(temp != NULL)
    {
        if(search(start1, temp->Data))
        {
            ins8end(temp->Data, &intersectionLL);
        }
        temp = temp->next;
    }
    return intersectionLL;
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
    printf("\n\nFirst Linked List entered is : ");
    Traverse(&start);
    printf("\n\nEnter the number of Elements of second Linked List: ");
    scanf("%d",&m);
    for(i=0;i<m;i++)
      {
          printf("Enter the element : ");
			scanf("%d",&a);
			ins8end(a,&start1);
      }
     printf("\n\nSecond Linked List entered is : ");
     Traverse(&start1);
     struct Node *unionLL = NULL;
     struct Node *intersectionLL = NULL;
     unionLL = findunion();
     intersectionLL = intersection();
     printf("\n\nUnion of Linked List : ");
     Traverse(&unionLL);
     printf("\n\nIntersection of Linked List : ");
     Traverse(&intersectionLL);
     return 0;
  }
