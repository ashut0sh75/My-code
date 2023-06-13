#include <stdio.h> 
#include <stdlib.h> 
//Structure of  linked list
struct node{  
    int data;  
    struct node *next;  
};      
struct node *tail=NULL,*head,*p; 
//addNode will add the nodes in the linked list
void addNode() {  
   
    int n,i;
    printf ("Number of Elements \n");
    scanf("%d",&n);
    head=NULL;
    for(i=0;i<n;i++)
    {
        p=malloc(sizeof(struct node));
        scanf("%d",&p->data);
        p->next=NULL;
        //checks if the list is empty
        if(head==NULL)
            head=p;                   //if list is empty then the first element becomes the  head of list
        else
            tail->next=p;            //adding new element in the linked list
        tail=p;                           //end node  is updated 
    }  
}  
   
//delete() will delete a node from the beginning of the list  
void deleteNode() {  
  
      
    //Checks if the list is empty  
    if(head == NULL) {  
        printf("List is empty \n");  
        return;  
    }  
    else {  
        //Checks whether the list contains only one node  
        //If not, the head will point to next node in the list and tail will point to the new head.  
        if(head != tail) {  
            head = head->next;  
        }  
        //If the list contains only one node   
        //then, it will remove it and both head and tail will point to NULL  
        else {  
            free(head);
            head = tail = NULL;  
        }  
    }
    
}  
      
//display() will display all the nodes present in the list  
void display() {  
    //Node current will point to head  
    struct node *current = head;  
    if(head == NULL) {  
        printf("List is empty\n");  
        
    }  
    while(current != NULL) {  
        //Prints each node by incrementing pointer  
        printf("%d ", current->data);  
        current = current->next;  
    }  
    printf("\n");  
}  
void reverse()
{
   struct node *prevNode, *curNode;

    if(head != NULL)
    {
        prevNode = head;
        curNode = head->next;
        head = head->next;
    
        prevNode->next = NULL; // Make first node as last node

        while(head != NULL)
        {
            head = head->next;
            curNode->next = prevNode;

            prevNode = curNode;
            curNode = head;
        }

        head = prevNode;
}
}
      
int main()  
{  
        addNode();                  //addNode() will add new nodes to list
        reverse();
    printf("Original List: \n");  
    display();                         //will display the whole  linked list
      int del;
    printf("Enter the number of nodes to be deleted \n");         
    scanf("%d",&del);
      for(int i=1;i<=del;i++)
      {

        deleteNode();  
      }
        printf("Updated List: \n");  
        display();  
    
    
    return 0;  
}  
// This code is contributed by Ashutosh Gupta .