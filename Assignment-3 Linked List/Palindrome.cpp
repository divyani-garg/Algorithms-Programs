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
            printf("\n%d",temp->Data);
            temp=temp->next;
            if(temp==NULL)
			  {
			    break;
              }
           }
       }
  }

struct Node* reverseCopy(struct Node *head)
{
    struct Node *newHead = NULL, *temp;
    if (head == NULL)
    {
       printf("Error : Invalid node pointer !!!\n");
       return NULL;
    }

    while(head != NULL)
    {
        temp = (struct Node*) malloc(sizeof(struct Node));
        temp->Data = head->Data;
        temp->next = newHead;
        newHead = temp;
        head = head->next;
    }
    return newHead;
}

int compareLinkedList(struct Node* LLOne, struct Node* LLTwo)
{
    while (LLOne != NULL && LLTwo != NULL)
    {
        if (LLOne->Data != LLTwo->Data)
        {
            return 0;
        }
        LLOne = LLOne->next;
        LLTwo = LLTwo->next;
    }
    return (LLOne == NULL && LLTwo == NULL);
}

int main()
  {
    int a,n,i;
    printf("Enter the number of Elements of Linked List: ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
      {
          printf("Enter the element : ");
			scanf("%d",&a);
			ins8end(a);
      }
     Traverse();

     /* Reverse Input Linked List */
      struct Node *reverseLL;
    reverseLL = reverseCopy(start);

    if(compareLinkedList(start, reverseLL)){
        printf("\nPalindrome Linked List\n");
    } else {
        printf("\nNot a Palindrome Linked List\n");
    }
     return 0;
  }

