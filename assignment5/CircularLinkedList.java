class Node {
    int data;
    Node next;

    public Node (int data) {
        this.data = data;
        next = null;
    }
}

public class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        head = null;
    }

    public void insert (int data) {
        Node newNode = new Node(data);        
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != head) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        newNode.next = head;
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node currentNode = head;
        Node previousNode = null;

        if (head.data == data) {
            if (head.next == head) {
                head = null;
                System.out.println("Deleted: " + data);
                return;
            }
            
            Node lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            
            head = head.next;
            lastNode.next = head;
            System.out.println("Deleted: " + data);
            return;
        }

        previousNode = head;
        currentNode = head.next;
        
        while (currentNode != head) {
            if (currentNode.data == data) {
                previousNode.next = currentNode.next;
                System.out.println("Deleted: " + data);
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        System.out.println(data + " not found in list.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node currentNode = head;
        System.out.print("List: ");
        do {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        } while (currentNode != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        System.out.println("Inserting elements: 10, 20, 30, 40");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.display();

        System.out.println("\nDeleting 20:");
        list.delete(20);
        list.display();

        System.out.println("\nDeleting 10 (head):");
        list.delete(10);
        list.display();

        System.out.println("\nDeleting 50 (not in list):");
        list.delete(50);

        System.out.println("\nDeleting remaining elements:");
        list.delete(30);
        list.delete(40);
        list.display();
    }
}
