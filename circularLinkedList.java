class Node {
  int data;
  Node next;

  public Node(int data) {
      this.data = data;
      this.next = null;
  }
}

class CircularLinkedList {
  Node head;

  public CircularLinkedList() {
      this.head = null;
  }

  // Method to insert a new node at the beginning of the circular linked list
  public void insert(int data) {
      Node newNode = new Node(data);
      if (head == null) {
          head = newNode;
          head.next = head; // Point to itself since it's the only node
      } else {
          Node temp = head;
          while (temp.next != head) {
              temp = temp.next;
          }
          temp.next = newNode;
          newNode.next = head;
          head = newNode;
      }
  }

  // Method to display the circular linked list
  public void display() {
      if (head == null) {
          System.out.println("Circular Linked List is empty.");
          return;
      }
      Node current = head;
      do {
          System.out.print(current.data + " ");
          current = current.next;
      } while (current != head);
      System.out.println();
  }
}

class Execute {
  public static void main(String[] args) {
      CircularLinkedList circularList = new CircularLinkedList();
      circularList.insert(1);
      circularList.insert(2);
      circularList.insert(3);
      circularList.insert(4);

      System.out.println("Circular Linked List:");
      circularList.display();
  }
}
