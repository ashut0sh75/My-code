#include <stdlib.h>
#include <stdio.h>
struct node
{
    int data;
    struct node *next;
};
struct node *head=NULL;

void append(struct node *head,int data)
{
    struct node *temp,*p;
    temp= (struct node *)malloc(sizeof(struct node));
    temp->data=data;
    temp->next=NULL;
    p=(struct node *)head;
    while(p->next != NULL){
       p=p->next;
    }
    p->next =temp;
   return ;
}
void  tranversal(struct node *head)
{
    struct node *temp = head;
printf("\n\nList elements are - \n");
while(temp != NULL) {
  printf("%d --->",temp->data);
  temp = temp->next;
}

}
int getCount(struct node* head)
{
    int count = 0; // Initialize count
    struct node* current = head; // Initialize current
    while (current != NULL) {
        count++;
        current = current->next;
    }
    return count;
}
int main()
{ 
    int len;
  scanf(" %d", &len);
  while(len>0)
    {int data;
    scanf("%d",&data);
        head=append(head,data);
        len--;
    }
    tranversal(head);//print LL
    int count =getCount(head);
    printf("Length of LL is %d",count);
    
    return 0;
}